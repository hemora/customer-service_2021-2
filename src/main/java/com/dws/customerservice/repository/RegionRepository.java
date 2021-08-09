package com.dws.customerservice.repository;

import com.dws.customerservice.dto.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RegionRepository {

    @Autowired JdbcTemplate jdbcTemplate;

    public List<Region> getRegions() {
        List<Region> regions =
                jdbcTemplate.query("SELECT * FROM region;",
                new BeanPropertyRowMapper<>(Region.class));
        return regions;
    }
}
