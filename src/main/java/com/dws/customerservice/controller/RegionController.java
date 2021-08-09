package com.dws.customerservice.controller;

import com.dws.customerservice.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping
    public ResponseEntity<Object> getRegions() {
        return new ResponseEntity<>(regionService.getRegions(), HttpStatus.OK);
    }
}
