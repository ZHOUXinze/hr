package com.manage.hr.service.impl;

import com.manage.hr.dao.SalaryItemDao;
import com.manage.hr.dao.SalaryStandardDetailDao;
import com.manage.hr.entity.SalaryItem;
import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.service.SalaryStandardDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class SalaryStandardDetailServiceImpl implements SalaryStandardDetailService {

    @Resource
    private SalaryStandardDetailDao salaryStandardDetailDao;
    @Resource
    private SalaryItemDao salaryItemDao;

    @Override
    public List<SalaryStandardDetail> listSalaryStandardDetailByCode(String standardCode) {
        return salaryStandardDetailDao.listSalaryStandardDetailByCode(standardCode);
    }

    @Override
    public int updateSalaryStandardDetail(List<SalaryStandardDetail> salaryStandardDetails) {
        for (SalaryStandardDetail salaryStandardDetail : salaryStandardDetails) {
            if (salaryStandardDetail.getIsChange() == 1) {
                salaryStandardDetailDao.updateSalaryStandardDetail(salaryStandardDetail);
            }
        }
        return 1;
    }

    @Override
    public int insertSalaryStandardDetail(List<SalaryStandardDetail> salaryStandardDetails) {
        for (SalaryStandardDetail salaryStandardDetail : salaryStandardDetails) {
                salaryStandardDetailDao.insertSalaryStandardDetail(salaryStandardDetail);
        }
        return 1;
    }


}
