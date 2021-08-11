package com.dws.customerservice.repository;

import com.dws.customerservice.dto.Region;
import com.dws.customerservice.dto.RespuestaApi;
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

    public Region getRegion(int id) {
        Region region =
                jdbcTemplate.queryForObject(
                        String.format("SELECT * FROM region WHERE id = %id ;", id)
                        , new BeanPropertyRowMapper<>(Region.class)
                );
        return region;
    }

    public RespuestaApi createRegion(Region region) {
        jdbcTemplate.update(
                String.format("INSERT INTO region (region) VALUES ('%region')", region.getRegion())
        );
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("La región ha sido registrada");
        return msg;
    }

    public RespuestaApi updateRegion(Region region, int id) {
        jdbcTemplate.update(
                String.format("UPDATE region SET region = %region WHERE id = %id;"
                                , region.getRegion()
                                , id)
        );
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("La región ha sido actualizada");
        return msg;
    }

}
