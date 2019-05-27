package com.manage.hr.service;

import com.manage.hr.entity.Position;

import com.manage.hr.util.PageSurport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionService {
    List<Position> listPosition();
    List<Position> cachePosition();
    PageSurport<Position> findAllPosition(Position position, int pageIndex, int pageSize);
    int addPosition(Position position);
    Position findPositionByID(int positionId);
    int updatePosition(Position position);
    int detPositionByID(int positionId);
    String findPositByCode(String posCode);
}
