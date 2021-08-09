package com.dws.customerservice.service;

import com.dws.customerservice.dto.Region;
import com.dws.customerservice.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RegionServiceImp implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> getRegions() {
        return regionRepository.getRegions();
    }
}
