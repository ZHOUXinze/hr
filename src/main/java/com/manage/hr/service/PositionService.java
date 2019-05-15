package com.manage.hr.service;

import com.manage.hr.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> listPosition();
    List<Position> cachePosition();
}
