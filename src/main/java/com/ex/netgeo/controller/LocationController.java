package com.ex.netgeo.controller;

import com.ex.netgeo.dto.LocationRequestDto;
import com.ex.netgeo.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для приёма координатных данных от устройств.
 * <p>
 * Ожидает POST-запросы по адресу {@code /location}, содержащие в теле JSON с координатами и временем.
 * Данные сохраняются через сервис {@link LocationService}.
 */
@RestController
@RequestMapping("/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    /**
     * Принимает координаты устройства и сохраняет их в систему.
     *
     * @param request объект запроса, содержащий координаты и время отправки
     * @return HTTP-ответ 200 OK в случае успешного сохранения
     */
    @PostMapping
    public ResponseEntity<Void> receiveLocation(@RequestBody LocationRequestDto request) {
        locationService.save(request);
        return ResponseEntity.ok().build();
    }
}