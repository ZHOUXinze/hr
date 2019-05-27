package com.manage.hr.dao;

import com.manage.hr.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PositionDao {
    List<Position> listPosition();
    List<Position> cachePosition();
   List<Position> findAllPosition(@Param("position")Position position,@Param("from")int from,
                                  @Param("pageSize") int pageSize );
    int findAllPotCount(@Param("position")Position position);
    int addPosition(Position position);
    Position findPositionByID(@Param("positionId")int positionId);
    int updatePosition(Position position);
    int detPositionByID(int positionId);
    String findPositByCode(String posCode);
}
