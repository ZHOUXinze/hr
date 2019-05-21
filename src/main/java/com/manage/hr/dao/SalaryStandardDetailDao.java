package com.manage.hr.dao;

import com.manage.hr.entity.SalaryStandardDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryStandardDetailDao {
    //根据标准编号查询所有小项
    List<SalaryStandardDetail> listSalaryStandardDetailByCode(String standardCode);

    //根据itemName查询
    List<SalaryStandardDetail> listSalaryStandardDetailByName(String itemName);

    //更新
    int updateSalaryStandardDetail(SalaryStandardDetail salaryStandardDetail);

    //添加
    int insertSalaryStandardDetail(SalaryStandardDetail salaryStandardDetail);

    //级联更新
    int updateSsdByItemName(@Param("newItemName") String newItemName, @Param("oldItemName") String oldItemName);


    //删除
    int deleteSsdByItemName(String itemName);

    int deleteSsdByStandardCode(String standardCode);

}
