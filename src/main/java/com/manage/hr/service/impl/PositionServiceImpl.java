package com.manage.hr.service.impl;

import com.manage.hr.dao.PositionDao;
import com.manage.hr.entity.Position;
import com.manage.hr.service.PositionService;
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
}
