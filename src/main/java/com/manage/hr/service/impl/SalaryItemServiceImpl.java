package com.manage.hr.service.impl;

import com.manage.hr.dao.SalaryItemDao;
import com.manage.hr.entity.SalaryItem;
import com.manage.hr.service.SalaryItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SalaryItemServiceImpl implements SalaryItemService {

    @Resource
    private SalaryItemDao salaryItemDao;

    @Override
    public List<SalaryItem> listSalaryItem() {
        return salaryItemDao.listSalaryItem();
    }


    @Override
    public int saveSalaryItem(List<SalaryItem> salaryItemList) {
//        return
//        1：成功
//        2：必填字段未填
        for (SalaryItem salaryItem : salaryItemList) {
            int modelStatus = salaryItem.getModelStatus();//获取页面的操作状态
            if (modelStatus == 0) { //0：没有操作
                continue;
            } else {    // 存在操作
                String itemCode = salaryItem.getItemCode();
                String itemName = salaryItem.getItemName();
                //验证数据。如果必填项为空，返回错误码
                if ((itemCode.isEmpty() || itemCode == null) || (itemName.isEmpty() || itemName == null)) {
                    return 2;
                }
                //给enable为null的对象赋值
                salaryItem.setEnable(salaryItem.getEnable() == null ? 4 : 3);
                //判断操作码
                //1：更新
                //2：插入
                if (modelStatus == 1) {
                    salaryItemDao.updateSalaryItem(salaryItem);
                } else if (modelStatus == 2) {
                    salaryItemDao.insertSalaryItem(salaryItem);
                }
            }
        }
        // 成功执行循环
        return 1;
    }

    @Override
    public int deleteSalaryItem(int id) {
        return salaryItemDao.deleteSalaryItem(id);
    }

}
