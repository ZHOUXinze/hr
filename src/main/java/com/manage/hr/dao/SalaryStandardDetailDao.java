package com.manage.hr.dao;

import com.manage.hr.entity.SalaryStandardDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalaryStandardDetailDao {
    //根据标准编号查询所有小项
    List<SalaryStandardDetail> listSalaryStandardDetailByCode(String standardCode);
    //根据项目名称查询所有小项
}
