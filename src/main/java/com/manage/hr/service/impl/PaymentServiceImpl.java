package com.manage.hr.service.impl;

import com.manage.hr.dao.ArchiveDao;
import com.manage.hr.dao.PaymentDao;
import com.manage.hr.dao.PayrollDao;
import com.manage.hr.dao.PayrollDetailDao;
import com.manage.hr.entity.Payment;
import com.manage.hr.entity.Payroll;
import com.manage.hr.entity.PayrollDetail;
import com.manage.hr.service.ArchiveService;
import com.manage.hr.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Resource
    private PayrollDao payrollDao;
    @Resource
    private PayrollDetailDao payrollDetailDao;
    @Resource
    private ArchiveDao archiveDao;

    //查询所有
    public List<Payment> listPayment() {
        //查询所有薪酬单
        List<Payment> paymentList = paymentDao.listPayment();

//        List<Department> departmentList = LoadDataBase.DATA_BASE.get("department");
//        //1.根据部门id和薪酬单id查询工资条
//        for (Payment payment : paymentList) {
//            int paymentId = payment.getId();
//            for (Department department : departmentList) {
//                payrollDao.getPayrollByPmDdp(paymentId, department.getId());
//            }
//        }

        //查询薪酬单总金额
        //根据薪酬单id查询所有的工资条
//        for (Payment payment : paymentList) {
//            BigDecimal actualTotal = BigDecimal.valueOf(0);
//            List<Payroll> payrollList = payrollDao.listPayrollByPm(payment.getId());
//            for (Payroll payroll : payrollList) {
//                List<PayrollDetail> payrollDetailList = payrollDetailDao.listPayrollDetailByPrId(payroll.getId());
//                for (PayrollDetail payrollDetail : payrollDetailList) {
//                    actualTotal = actualTotal.add(payrollDetail.getItemAmount());
//                }
//            }
//            payment.setActualTotal(actualTotal);
//            //查询薪酬人数
//            payment.setPeopleNumber(payrollDao.countPayrollByPaymentId(payment.getId()));

//        }

        return paymentDao.listPayment();
    }

    @Override
    public int savePayment(List<Payment> paymentList) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        for (Payment payment : paymentList) {
            int ms = payment.getModelStatus();
            if (ms != 0) {
                if (ms == 2) {
                    paymentDao.insertPayment(payment);
                }
            }
        }
        return 1;
    }


}
