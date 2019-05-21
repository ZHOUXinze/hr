package com.manage.hr.dao;

import com.manage.hr.entity.SalaryStandardDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryStandardDetailDao {
    //根据标准编号查询所有小项
    List<SalaryStandardDetail> listSalaryStandardDetailByCode(String standardCode);

    //更新
    int updateSalaryStandardDetail(SalaryStandardDetail salaryStandardDetail);

    //添加
    int insertSalaryStandardDetail(SalaryStandardDetail salaryStandardDetail);
}
