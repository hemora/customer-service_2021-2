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
        String query = "SELECT * FROM region WHERE id = " + id + " ;";
        Region region =
                jdbcTemplate.queryForObject(
                        query
                        , new BeanPropertyRowMapper<>(Region.class)
                );
        return region;
    }

    public RespuestaApi createRegion(Region region) {
        String query = "INSERT INTO region (region) VALUES ('" + region.getRegion() + "');";
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("La región ha sido registrada");
        return msg;
    }

    public RespuestaApi updateRegion(Region region, int id) {
        String query = "UPDATE region SET region = '"+ region.getRegion() +"' WHERE id = "+ id +";";
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("La región ha sido actualizada");
        return msg;
    }

    public RespuestaApi deleteRegion(int id) {
        String query = "DELETE FROM region WHERE id = " + id + ";";
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("La región ha sido eliminada");
        return msg;
    }
}
