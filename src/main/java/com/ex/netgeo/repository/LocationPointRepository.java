package com.ex.netgeo.repository;

import com.ex.netgeo.entity.LocationPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Репозиторий для работы с сущностью {@link LocationPoint}.
 */
@Repository
public interface LocationPointRepository extends JpaRepository<LocationPoint, Long> {

    @Query(
            value = "SELECT * FROM location_point WHERE device_id = :deviceId ORDER BY time_create DESC LIMIT 1",
            nativeQuery = true
    )
    LocationPoint findLastByDeviceId(@Param("deviceId") UUID deviceId);


    /**
     * Возвращает список координат для заданного устройства за указанный временной интервал.
     *
     * @param deviceId идентификатор устройства
     * @param from     начало временного интервала (включительно)
     * @param to       конец временного интервала (включительно)
     * @return список точек, отсортированных по времени в порядке возрастания
     */
//    List<LocationPoint> findByDeviceIdAndTimeCreateBetweenOrderByTimeCreateAsc(
//            String deviceId,
//            LocalDateTime from,
//            LocalDateTime to
//    );
}