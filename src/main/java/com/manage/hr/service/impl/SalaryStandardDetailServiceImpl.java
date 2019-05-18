package com.manage.hr.service.impl;

import com.manage.hr.dao.SalaryStandardDetailDao;
import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.service.SalaryStandardDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SalaryStandardDetailServiceImpl implements SalaryStandardDetailService {

    @Resource
    private SalaryStandardDetailDao salaryStandardDetailDao;

    @Override
    public List<SalaryStandardDetail> listSalaryStandardDetailByCode(String  standardCode) {
        return salaryStandardDetailDao.listSalaryStandardDetailByCode(standardCode);
    }
}
