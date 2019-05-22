package com.manage.hr.service;

import com.manage.hr.entity.Archive;
import com.manage.hr.util.ArchiveTools;
import com.manage.hr.util.PageSurport;


public interface ArchiveService {
    int addArchive(Archive archive);
    Integer findMaxId();
    //分页查询
    PageSurport<Archive> findArchiveList(ArchiveTools archiveTools, int pageIndex, int pageSize);
    int updateArchive(Archive archive);
    int deleteArchive(int id);
    Archive findArchiveById(int id);
    String findPosCode(int id);
    int  delUpdateArchiveStatus(int id);
    int recoverReg(int id,int isdelete);
    int deleteAnnex(int id);
    //代办查询
    PageSurport<Archive> findArchiveWaitList(ArchiveTools archiveTools, int pageIndex, int pageSize);
    String findArchiveByName( String  userName);

}
