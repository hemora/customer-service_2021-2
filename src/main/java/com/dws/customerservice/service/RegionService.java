package com.dws.customerservice.service;

import com.dws.customerservice.dto.Region;
import org.apache.logging.log4j.message.Message;

import java.util.List;

public interface RegionService {

    public List<Region> getRegions();

    public Region getRegion(int id);

    public Message createRegion(Region region);

    public Message updateRegion(Region region, int id);

    public Message deleteRegion(int id);
}
