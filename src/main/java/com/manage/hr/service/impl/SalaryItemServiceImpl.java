package com.manage.hr.service.impl;

import com.manage.hr.dao.SalaryItemDao;
import com.manage.hr.dao.SalaryStandardDao;
import com.manage.hr.dao.SalaryStandardDetailDao;
import com.manage.hr.entity.SalaryItem;
import com.manage.hr.entity.SalaryStandard;
import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.service.SalaryItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class SalaryItemServiceImpl implements SalaryItemService {

    @Resource
    private SalaryItemDao salaryItemDao;
    @Resource
    private SalaryStandardDao salaryStandardDao;
    @Resource
    private SalaryStandardDetailDao salaryStandardDetailDao;

    @Override
    public List<SalaryItem> listSalaryItem() {
        return salaryItemDao.listSalaryItem();
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int saveSalaryItem(List<SalaryItem> salaryItemList) {
        //return
        //1：成功
        //2：必填字段未填
        for (SalaryItem salaryItem : salaryItemList) {
            int modelStatus = salaryItem.getModelStatus();//获取页面的操作状态
            if (modelStatus != 0) { //0：没有操作
                // 存在操作
                String itemCode = salaryItem.getItemCode();
                String itemName = salaryItem.getItemName();
                //验证数据。如果必填项为空，返回错误码
                if ((itemCode.isEmpty() || itemCode == null) || (itemName.isEmpty() || itemName == null)) {
                    return 2;
                }
//                //给enable为null的对象赋值
//                salaryItem.setEnable(salaryItem.getEnable().equals("on") ? 3 : 4);
                //判断操作码
                //1：更新
                //2：插入
                if (modelStatus == 1) {
                    SalaryItem oldSalaryItem = salaryItemDao.getSalaryItemById(salaryItem.getId());
                    //旧的项目名
                    String oldItemName = oldSalaryItem.getItemName();
                    //更新薪资项目
                    salaryItemDao.updateSalaryItem(salaryItem);
                    //更新薪资标准详情
                    salaryStandardDetailDao.updateSsdByItemName(salaryItem.getItemName(), oldItemName);
                } else if (modelStatus == 2) {
                    salaryItemDao.insertSalaryItem(salaryItem);
                    //查询所有薪资标准
                    List<SalaryStandard> salaryStandardList = salaryStandardDao.listSalaryStandard();
                    //新建薪资标准详细
                    SalaryStandardDetail salaryStandardDetail = new SalaryStandardDetail();
                    //标准项目名称为薪资项目名
                    salaryStandardDetail.setItemName(salaryItem.getItemName());
                    salaryStandardDetail.setItemAmount(BigDecimal.valueOf(0));
                    for (SalaryStandard salaryStandard : salaryStandardList) {
                        salaryStandardDetail.setStandardCode(salaryStandard.getStandardCode());
                        salaryStandardDetailDao.insertSalaryStandardDetail(salaryStandardDetail);
                    }
                }
            }
        }
        // 成功执行循环
        return 1;
    }

    @Override
    public int deleteSalaryItem(int id) {
        SalaryItem salaryItem = salaryItemDao.getSalaryItemById(id);
        List<SalaryStandardDetail> salaryStandardDetailList = salaryStandardDetailDao.listSalaryStandardDetailByName(salaryItem.getItemName());
        for (SalaryStandardDetail salaryStandardDetail : salaryStandardDetailList) {
            System.out.println(salaryStandardDetail.getItemName());
            //删除标准详情
            salaryStandardDetailDao.deleteSsdByItemName(salaryStandardDetail.getItemName());
        }
        return salaryItemDao.deleteSalaryItem(id);
    }

}
