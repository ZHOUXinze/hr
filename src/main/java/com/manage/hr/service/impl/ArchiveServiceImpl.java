package com.manage.hr.service.impl;

import com.manage.hr.dao.ArchiveDao;
import com.manage.hr.entity.Archive;
import com.manage.hr.service.ArchiveService;
import com.manage.hr.util.ArchiveTools;
import com.manage.hr.util.PageSurport;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Resource
    private ArchiveDao archiveDao;
    @Override
    public int addArchive(Archive archive) {
        return archiveDao.addArchive(archive);
    }

    @Override
    public Integer findMaxId() {
        return archiveDao.findMaxId();
    }
    //分页查询
    @Override
    public PageSurport<Archive> findArchiveList(ArchiveTools archiveTools, int pageIndex, int pageSize) {
        PageSurport<Archive> pageSurport=new PageSurport<Archive>();
        int from=(pageIndex-1)*pageSize;
        pageSurport.setDataList(archiveDao.findArchiveList(archiveTools,from,pageSize));
        pageSurport.setTotalCount(archiveDao.findArchiveCount(archiveTools));
        return pageSurport;
    }

    @Override
    public int updateArchive(Archive archive) {
        return archiveDao.updateArchive(archive);
    }

    @Override
    public int deleteArchive(int id) {
        return archiveDao.deleteArchive(id);
    }

    @Override
    public Archive findArchiveById(int id) {
        return archiveDao.findArchiveById(id);
    }

    @Override
    public String findPosCode(int id) {
        return archiveDao.findPosCode(id);
    }

    @Override
    public int delUpdateArchiveStatus(int id) {
        return archiveDao.delUpdateArchiveStatus(id);
    }

    @Override
    public int recoverReg(int id, int isdelete) {
        return archiveDao.recoverReg(id,isdelete);
    }

    @Override
    public int deleteAnnex(int id) {
        return archiveDao.deleteAnnex(id);
    }

    @Override
    public PageSurport<Archive> findArchiveWaitList(ArchiveTools archiveTools, int pageIndex, int pageSize) {
        PageSurport<Archive> pageSurport=new PageSurport<Archive>();
        int from=(pageIndex-1)*pageSize;
        pageSurport.setDataList(archiveDao.findArchiveWaitList(archiveTools,from,pageSize));
        pageSurport.setTotalCount(archiveDao.findArchiveWaitCount(archiveTools));
        return pageSurport;
    }
    @Override
    public  String findArchiveByName(String userName){
        return archiveDao.findArchiveByName(userName);
    }

}
