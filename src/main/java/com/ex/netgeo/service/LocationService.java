package com.ex.netgeo.service;

import com.ex.netgeo.dto.LocationRequest;
import com.ex.netgeo.entity.LocationPoint;
import com.ex.netgeo.repository.LocationPointRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Сервис для обработки координатных данных от устройств.
 * <p>
 * Отвечает за преобразование входных данных и сохранение их в базу данных.
 */
@Service
public class LocationService {

    private final LocationPointRepository locationPointRepository;

    public LocationService(LocationPointRepository locationPointRepository) {
        this.locationPointRepository = locationPointRepository;
    }

    /**
     * Сохраняет координаты устройства в базу данных.
     *
     * @param request объект с координатами и временем
     */
    @Transactional
    public void save(LocationRequest request) {
        LocationPoint point = LocationPoint.builder()
                .deviceId(UUID.fromString(request.getDeviceId()))
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .timeCreate(request.getTimeCreate())
                .build();
        locationPointRepository.save(point);
    }
}