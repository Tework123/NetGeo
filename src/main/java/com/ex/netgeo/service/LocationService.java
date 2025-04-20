package com.ex.netgeo.service;

import com.ex.netgeo.dto.LocationRequestDto;
import com.ex.netgeo.entity.LocationPoint;
import com.ex.netgeo.repository.LocationPointRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для обработки координатных данных от устройств.
 * <p>
 * Отвечает за преобразование входных данных и сохранение их в базу данных.
 */
@Service
@AllArgsConstructor
public class LocationService {

    private final LocationPointRepository locationPointRepository;

    /**
     * Сохраняет координаты устройства в базу данных.
     *
     * @param request объект с координатами и временем
     */
    @Transactional
    public void save(LocationRequestDto request) {
        LocationPoint point = LocationPoint.builder()
                .deviceId(request.getDeviceId())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .timeCreate(request.getTimeCreate())
                .build();
        locationPointRepository.save(point);
    }
}