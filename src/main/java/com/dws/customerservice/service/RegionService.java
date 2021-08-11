package com.dws.customerservice.service;

import com.dws.customerservice.dto.Region;
import com.dws.customerservice.dto.RespuestaApi;
import org.apache.logging.log4j.message.Message;

import java.util.List;

public interface RegionService {

    public List<Region> getRegions();

    public Region getRegion(int id);

    public RespuestaApi createRegion(Region region);

    public RespuestaApi updateRegion(Region region, int id);

    public RespuestaApi deleteRegion(int id);
}
