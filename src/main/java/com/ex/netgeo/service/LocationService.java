package com.ex.netgeo.service;

import com.ex.netgeo.dto.LocationRequestDto;
import com.ex.netgeo.entity.Device;
import com.ex.netgeo.entity.LocationPoint;
import com.ex.netgeo.repository.DeviceRepository;
import com.ex.netgeo.repository.LocationPointRepository;
import jakarta.persistence.EntityNotFoundException;
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
    private final DeviceRepository deviceRepository;

    /**
     * Сохраняет координаты устройства в базу данных.
     *
     * @param request объект с координатами и временем
     */
    @Transactional
    public void save(LocationRequestDto request) {
        Device device = deviceRepository.findById(request.getDeviceId())
                .orElseThrow(() -> new EntityNotFoundException("Device not found with id: " + request.getDeviceId()));

        LocationPoint point = LocationPoint.builder()
                .device(device)
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .timeCreate(request.getTimeCreate())
                .build();
        locationPointRepository.save(point);
    }
}