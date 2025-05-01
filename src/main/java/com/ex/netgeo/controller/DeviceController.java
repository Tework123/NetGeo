package com.ex.netgeo.controller;

import com.ex.netgeo.dto.deviceDto.CreateDeviceRequestDto;
import com.ex.netgeo.dto.DeviceSaveRequestDto;
import com.ex.netgeo.dto.deviceDto.GetDeviceResponseDto;
import com.ex.netgeo.dto.deviceDto.UpdateDeviceDto;
import com.ex.netgeo.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/device")
@AllArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;


    /**
     * Регистрирует новое устройство.
     *
     * @param createDeviceRequestDto объект запроса, содержащий информацию об устройстве
     * @return HTTP-ответ 200 OK в случае успешного сохранения
     */
    @PostMapping
    public ResponseEntity<Void> createDevice(@RequestBody CreateDeviceRequestDto createDeviceRequestDto) {
        deviceService.save(createDeviceRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{device_id}")
    public GetDeviceResponseDto getDevice(@PathVariable UUID deviceId) {
        return deviceService.getDeviceById(deviceId);

    }

    @PutMapping("/{device_id}")
    public ResponseEntity<Void> updateDevice(@PathVariable UUID deviceId, @RequestBody UpdateDeviceDto dto) {
//        deviceService.update(deviceId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{device_id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable UUID deviceId) {
//        deviceService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
