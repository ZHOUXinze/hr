package com.manage.hr.dao;

import com.manage.hr.entity.Archive;
import com.manage.hr.util.ArchiveTools;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArchiveDao {
    int addArchive(Archive archive);
    Integer findMaxId();
    int findArchiveCount(@Param("archiveTools") ArchiveTools archiveTools);
    List<Archive> findArchiveList(@Param("archiveTools") ArchiveTools archiveTools,@Param("from") int from,@Param("pageSize") int pageSize);
    int updateArchive(Archive archive);
    int deleteArchive(int id);
    Archive findArchiveById(@Param("id") int id);
    //更新用户表的电话
    /*int addArchivePhone();*/
    String findPosCode(int id);
    int  delUpdateArchiveStatus(@Param("id") int id);
    int recoverReg(@Param("id") int id,@Param("isdelete") int isdelete);
    int deleteAnnex(@Param("id") int id);

    int findArchiveWaitCount(@Param("archiveTools") ArchiveTools archiveTools);
    List<Archive> findArchiveWaitList(@Param("archiveTools") ArchiveTools archiveTools,@Param("from") int from,@Param("pageSize") int pageSize);
    String findArchiveByName(@Param("userName") String  userName);

}
