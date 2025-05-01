package com.ex.netgeo.service;

import com.ex.netgeo.AppStartupLogger;
import com.ex.netgeo.dto.deviceDto.CreateDeviceRequestDto;
import com.ex.netgeo.dto.deviceDto.GetDeviceResponseDto;
import com.ex.netgeo.entity.Device;
import com.ex.netgeo.mapper.DeviceMapper;
import com.ex.netgeo.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeviceService {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupLogger.class);

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;


    /**
     * Создает устройство в базе данных.
     *
     * @param createDeviceRequestDto поля устройства
     */
    @Transactional
    public void save(CreateDeviceRequestDto createDeviceRequestDto) {
        Device device = Device.builder()
                .name(createDeviceRequestDto.getName())
                .build();
        deviceRepository.save(device);
        logger.info("Устройство создано с id {}", device.getDeviceId());
    }

    public GetDeviceResponseDto getDeviceById(UUID deviceId) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(()
                -> new EntityNotFoundException("Device not found with id: " + deviceId));

        return deviceMapper.toResponseDto(device);
    }
}
