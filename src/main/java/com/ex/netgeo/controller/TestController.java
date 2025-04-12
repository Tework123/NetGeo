package com.ex.netgeo.controller;

import com.ex.netgeo.service.GeoIpService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/geo")
public class TestController {
    private final GeoIpService geoIpService;


    @GetMapping("/search")
    public List<Map<String, Object>> search(@RequestParam String query) {
        return geoIpService.getCountryCodeByIp(query);
    }
}