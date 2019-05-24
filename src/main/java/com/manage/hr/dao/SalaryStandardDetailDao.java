package com.manage.hr.dao;

import com.manage.hr.entity.SalaryStandardDetail;
import com.manage.hr.entity.Ssd;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    List<Map<String,Object>> listSsdView();

}
