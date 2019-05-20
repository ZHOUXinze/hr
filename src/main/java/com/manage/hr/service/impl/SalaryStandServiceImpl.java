package com.manage.hr.service.impl;

import com.manage.hr.dao.SalaryStandardDao;
import com.manage.hr.entity.SalaryStandard;
import com.manage.hr.service.SalaryStandardService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SalaryStandServiceImpl implements SalaryStandardService {
    @Resource
    private SalaryStandardDao salaryStandardDao;

    @Override
    public List<SalaryStandard> listSalaryStandard() {
        List<SalaryStandard> salaryStandardList = new ArrayList<>();
        LoadDataBase.loadDictionary();
        for (SalaryStandard salaryStandard : salaryStandardDao.listSalaryStandard()) {
            salaryStandard.setStatusName(LoadDataBase.DICTIONARY.get("revStatus").get(salaryStandard.getStatus()));
            salaryStandardList.add(salaryStandard);
        }
        return salaryStandardList;
    }

    @Override
    public SalaryStandard getSalaryStandardById(int id) {
        SalaryStandard salaryStandard = salaryStandardDao.getSalaryStandardById(id);
        return salaryStandard;
    }

    @Override
    public int insertSalaryStandard(SalaryStandard salaryStandard) {
        return 0;
    }

    @Override
    public int updateSalaryStandard(SalaryStandard salaryStandard) {
        return 0;
    }

    @Override
    public int deleteSalaryStandard(int id) {
        return 0;
    }

    @Override
    public int reviewSalaryStandard(int id, String review, String reviewOpinion) {
        SalaryStandard salaryStandard = new SalaryStandard();
        salaryStandard.setId(id);
        salaryStandard.setReviewOpinion(reviewOpinion);
        //添加审核状态
        if (review.equals("审核通过")) {
            salaryStandard.setStatus(5);
        } else if (review.equals("驳回")) {
            salaryStandard.setStatus(8);
        }
        return salaryStandardDao.reviewSalaryStandard(salaryStandard);
    }

    @Override
    public List<SalaryStandard> listSalaryStandardByCondition(String salaryStandardCode, String statusName, Date start, Date end) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String newStart = simpleDateFormat.format(start);
//        String newEnd = simpleDateFormat.format(end);
       return salaryStandardDao.listSalaryStandardByCondition(salaryStandardCode, statusName, start, end);
    }


}