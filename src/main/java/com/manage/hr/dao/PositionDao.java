package com.manage.hr.dao;

import com.manage.hr.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PositionDao {
    List<Position> listPosition();
    List<Position> cachePosition();
}
