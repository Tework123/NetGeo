package com.ex.netgeo.service;

import com.ex.netgeo.dto.locationPointDto.CreateLocationRequestDto;
import com.ex.netgeo.dto.locationPointDto.GetLastLocationPointDto;
import com.ex.netgeo.entity.Device;
import com.ex.netgeo.entity.LocationPoint;
import com.ex.netgeo.mapper.LocationPointMapper;
import com.ex.netgeo.repository.DeviceRepository;
import com.ex.netgeo.repository.LocationPointRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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
    private final LocationPointMapper locationPointMapper;

    /**
     * Сохраняет координаты устройства в базу данных.
     *
     * @param dto объект с координатами и временем
     */
    @Transactional
    public void save(CreateLocationRequestDto dto) {
        Device device = deviceRepository.findById(dto.getDeviceId())
                .orElseThrow(() -> new EntityNotFoundException("Device not found with id: " + dto.getDeviceId()));

        LocationPoint locationPoint = locationPointMapper.toEntity(dto, device);
        locationPointRepository.save(locationPoint);
    }

    public GetLastLocationPointDto getLast(UUID deviceId) {
        if (!deviceRepository.existsById(deviceId)) {
            throw new EntityNotFoundException("Device not found with id: " + deviceId);
        }

        LocationPoint locationPoint = locationPointRepository.findLastByDeviceId(deviceId);
        return locationPointMapper.toResponseDto(locationPoint);

    }

}