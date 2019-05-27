package com.manage.hr.service.impl;

import com.manage.hr.dao.PositionDao;
import com.manage.hr.entity.Position;

import com.manage.hr.service.PositionService;
import com.manage.hr.util.PageSurport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;
    @Override
    public List<Position> listPosition() {
        return positionDao.listPosition();
    }

    @Override
    public List<Position> cachePosition() {
        return positionDao.cachePosition();
    }

    @Override
    public PageSurport<Position> findAllPosition(Position position, int pageIndex, int pageSize) {
        PageSurport<Position> pageSurport=new PageSurport<>();
        int from=(pageIndex-1)*pageSize;
        pageSurport.setDataList(positionDao.findAllPosition(position,from,pageSize));
   ;
        pageSurport.setTotalCount(positionDao.findAllPotCount(position));

        return pageSurport;
    }

    @Override
    public int addPosition(Position position) {
        return positionDao.addPosition(position);
    }

    @Override
    public Position findPositionByID(int positionId) {
        return positionDao.findPositionByID(positionId);
    }

    @Override
    public int updatePosition(Position position) {
        return positionDao.updatePosition(position);
    }

    @Override
    public int detPositionByID(int positionId) {
        return positionDao.detPositionByID(positionId);
    }

    @Override
    public String findPositByCode(String posCode) {
        return positionDao.findPositByCode(posCode);
    }
}
