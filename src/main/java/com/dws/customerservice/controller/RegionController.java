package com.dws.customerservice.controller;

import com.dws.customerservice.dto.Region;
import com.dws.customerservice.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRegion(@PathVariable("id") int id) {
        return new ResponseEntity<>(regionService.getRegion(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createRegion(@RequestBody Region region) {
        return new ResponseEntity<>(regionService.createRegion(region), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRegion(@RequestBody Region region, @PathVariable("id") int id) {
        return new ResponseEntity<>(regionService.updateRegion(region, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRegion(@PathVariable("id") int id) {
        return new ResponseEntity<>(regionService.deleteRegion(id), HttpStatus.OK);
    }
}
