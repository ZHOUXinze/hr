package com.manage.hr.service.impl;

import com.manage.hr.dao.SalaryStandardDao;
import com.manage.hr.dao.SalaryStandardDetailDao;
import com.manage.hr.entity.SalaryStandard;
import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.service.SalaryStandardService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SalaryStandServiceImpl implements SalaryStandardService {
    @Resource
    private SalaryStandardDao salaryStandardDao;
    @Resource
    private SalaryStandardDetailDao salaryStandardDetailDao;

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
    public int insertSalaryStandard(SalaryStandard salaryStandard, int type) {
        SalaryStandard newSalaryStandard = salaryStandard;
        newSalaryStandard.setStatus(type == 1 ? 7 : 6);
        return salaryStandardDao.insertSalaryStandard(salaryStandard);
    }


    @Override
    public int updateSalaryStandard(SalaryStandard salaryStandard, int type) {
        SalaryStandard newSalaryStandard = salaryStandard;
        newSalaryStandard.setStatus(type == 1 ? 7 : 6);
        if (newSalaryStandard.getChangeReason() == null || newSalaryStandard.getChangeReason().isEmpty()) {
            newSalaryStandard.setChangeReason("");
        }
        if (newSalaryStandard.getReviewOpinion() == null || newSalaryStandard.getReviewOpinion().isEmpty()) {
            newSalaryStandard.setReviewOpinion("");
        }
        return salaryStandardDao.updateSalaryStandard(newSalaryStandard);
    }

    @Override
    public int deleteSalaryStandard(int id) {
        SalaryStandard salaryStandard = salaryStandardDao.getSalaryStandardById(id);
        List<SalaryStandardDetail> salaryStandardDetails = salaryStandardDetailDao.listSalaryStandardDetailByCode(salaryStandard.getStandardCode());
        for(SalaryStandardDetail salaryStandardDetail: salaryStandardDetails){
            salaryStandardDetailDao.deleteSsdByStandardCode(salaryStandard.getStandardCode());
        }
        return salaryStandardDao.deleteSalaryStandard(id);
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
        //把statusName换成status
        int status;
        if (statusName.equals("通过")) {
            status = 5;
        } else if (statusName.equals("起草")) {
            status = 6;
        } else if (statusName.equals("审核中")) {
            status = 7;
        } else if (statusName.equals("驳回")) {
            status = 8;
        } else {
            status = -1;
        }
        return salaryStandardDao.listSalaryStandardByCondition(salaryStandardCode, status, start, end);
    }


}
