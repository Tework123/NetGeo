package com.ex.netgeo.controller;

import com.ex.netgeo.dto.LocationRequestDto;
import com.ex.netgeo.dto.TrackingDeviceSaveRequestDto;
import com.ex.netgeo.service.TrackingDeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracking_device")
@AllArgsConstructor
public class TrackingDeviceController {

    private final TrackingDeviceService trackingDeviceService;


    /**
     * Регистрирует новое устройство.
     *
     * @param request объект запроса, содержащий информацию об устройстве
     * @return HTTP-ответ 200 OK в случае успешного сохранения
     */
    @PostMapping
    public ResponseEntity<Void> receiveLocation(@RequestBody TrackingDeviceSaveRequestDto request) {

        trackingDeviceService.save(request);
        return ResponseEntity.ok().build();
    }
}
