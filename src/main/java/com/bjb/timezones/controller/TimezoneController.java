package com.bjb.timezones.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.timezones.services.TimezoneService;

@RestController
@RequestMapping("/api")
public class TimezoneController {

    private final TimezoneService timezoneService;


    public TimezoneController(TimezoneService timezoneService) {
        this.timezoneService = timezoneService;
    }

    @GetMapping("/timezones")
    public ResponseEntity<List<String>> getTimezones(){
        return new ResponseEntity<>(timezoneService.getTimezones(), HttpStatus.OK);
    }
}