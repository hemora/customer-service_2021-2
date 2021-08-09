package com.dws.customerservice.service;

import com.dws.customerservice.dto.Region;
import com.dws.customerservice.repository.RegionRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImp implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> getRegions() {
        return regionRepository.getRegions();
    }

    @Override
    public Region getRegion(int id) {
        return null;
    }

    @Override
    public Message createRegion(Region region) {
        return null;
    }

    @Override
    public Message updateRegion(Region region, int id) {
        return null;
    }

    @Override
    public Message deleteRegion(int id) {
        return null;
    }
}
