package com.manage.hr.service.impl;

import com.manage.hr.dao.SalaryStandardDao;
import com.manage.hr.dao.SalaryStandardDetailDao;
import com.manage.hr.entity.SalaryStandard;
import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.service.SalaryStandardService;
import com.manage.hr.util.LoadDataBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        /*List<Map<String, Object>> mapList = salaryStandardDetailDao.listSsdView();
        for (Map<String, Object> map : mapList) {
            for (String key : map.keySet()) {
                System.out.println(key);
            }
        }*/
        return salaryStandardList;
    }

    @Override
    public SalaryStandard getSalaryStandardById(int id) {
        return salaryStandardDao.getSalaryStandardById(id);
    }

    @Override
    public int insertSalaryStandard(SalaryStandard salaryStandard, int type) {
        salaryStandard.setStatus(type == 1 ? 7 : 6);
        return salaryStandardDao.insertSalaryStandard(salaryStandard);
    }


    @Override
    public int updateSalaryStandard(SalaryStandard salaryStandard, int type) {
        salaryStandard.setStatus(type == 1 ? 7 : 6);
        if (salaryStandard.getChangeReason() == null || salaryStandard.getChangeReason().isEmpty()) {
            salaryStandard.setChangeReason("");
        }
        if (salaryStandard.getReviewOpinion() == null || salaryStandard.getReviewOpinion().isEmpty()) {
            salaryStandard.setReviewOpinion("");
        }
        return salaryStandardDao.updateSalaryStandard(salaryStandard);
    }

    @Override
    public int deleteSalaryStandard(int id) {
        SalaryStandard salaryStandard = salaryStandardDao.getSalaryStandardById(id);
        List<SalaryStandardDetail> salaryStandardDetails = salaryStandardDetailDao.listSalaryStandardDetailByCode(salaryStandard.getStandardCode());
        for (int i = 0; i < salaryStandardDetails.size(); i++) {
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
    public List<SalaryStandard> listSalaryStandardByCondition(String salaryStandardCode, String statusName, String start, String end) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date startTime = null;
        Date endTime = null;
        if (!start.isEmpty()) {
            try {
                startTime = simpleDateFormat.parse(start);
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        if (!end.isEmpty()) {
            try {
                endTime = simpleDateFormat.parse(end);
                if (endTime.before(startTime)) {
                    startTime = null;
                    endTime = null;
                }
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        System.out.println(startTime);
        //把statusName换成status
        int status;
        switch (statusName) {
            case "通过":
                status = 5;
                break;
            case "起草":
                status = 6;
                break;
            case "审核中":
                status = 7;
                break;
            case "驳回":
                status = 8;
                break;
            default:
                status = -1;
                break;
        }
        List<SalaryStandard> salaryStandardList = new ArrayList<>();
        for (SalaryStandard salaryStandard : salaryStandardDao.listSalaryStandardByCondition(salaryStandardCode, status, startTime, endTime)) {
            salaryStandard.setStatusName(LoadDataBase.DICTIONARY.get("revStatus").get(salaryStandard.getStatus()));
            salaryStandardList.add(salaryStandard);
        }
        return salaryStandardList;

    }


}
