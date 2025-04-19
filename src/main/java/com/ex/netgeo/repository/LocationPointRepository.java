package com.ex.netgeo.repository;

import com.ex.netgeo.entity.LocationPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Репозиторий для работы с сущностью {@link LocationPoint}.
 * <p>
 * Предоставляет базовые CRUD-операции, а также метод для получения маршрута устройства за указанный период.
 */
@Repository
public interface LocationPointRepository extends JpaRepository<LocationPoint, Long> {

    /**
     * Возвращает список координат для заданного устройства за указанный временной интервал.
     *
     * @param deviceId идентификатор устройства
     * @param from     начало временного интервала (включительно)
     * @param to       конец временного интервала (включительно)
     * @return список точек, отсортированных по времени в порядке возрастания
     */
    List<LocationPoint> findByDeviceIdAndTimeCreateBetweenOrderByTimeCreateAsc(
            String deviceId,
            LocalDateTime from,
            LocalDateTime to
    );
}