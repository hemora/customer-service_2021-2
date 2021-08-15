package com.dws.customerservice.repository;

import com.dws.customerservice.dto.Customer;
import com.dws.customerservice.dto.Region;
import com.dws.customerservice.dto.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomers() {
        String query =  "SELECT * FROM customer c, region r WHERE c.id_region = r.id;";
        List<Customer> customers = new ArrayList<>();
        customers = jdbcTemplate.query(
                query
                , new RowMapper<Customer>() {
                    @Override
                    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

                        Customer customer = new Customer();
                        customer.setId(resultSet.getInt(1));
                        customer.setNombre(resultSet.getString(2));
                        customer.setApellidos(resultSet.getString(3));
                        customer.setRfc(resultSet.getString(3));
                        customer.setCorreo(resultSet.getString(3));
                        //
                        Region region = new Region();
                        region.setId(resultSet.getInt(7));
                        region.setRegion(resultSet.getString(8));
                        //
                        customer.setRegion(region);
                        //
                        return customer;
                    }
                }
        );
        return customers;
    }

    public Customer getCustomer(int id) {
        String query
                =  "SELECT * FROM customer c, region r WHERE c.id_region = r.id AND c.id = " + id + ";";
        Customer customer = new Customer();
        customer = jdbcTemplate.queryForObject(
                query
                , new RowMapper<Customer>() {
                    @Override
                    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

                        Customer customer = new Customer();
                        customer.setId(resultSet.getInt(1));
                        customer.setNombre(resultSet.getString(2));
                        customer.setApellidos(resultSet.getString(3));
                        customer.setRfc(resultSet.getString(3));
                        customer.setCorreo(resultSet.getString(3));
                        //
                        Region region = new Region();
                        region.setId(resultSet.getInt(7));
                        region.setRegion(resultSet.getString(8));
                        //
                        customer.setRegion(region);
                        //
                        return customer;
                    }
                }
        );
        return customer;
    }

    public RespuestaApi createCustomer(Customer customer) {
        String query =
                "INSERT INTO customer (nombre, apellidos, rfc, correo, id_region) VALUES ("
                        + "'" + customer.getNombre()  + "',"
                        + "'" + customer.getApellidos() +  "',"
                        + "'" + customer.getRfc() + "',"
                        + "'" + customer.getCorreo() + "',"
                        + "'" + customer.getRegion().getId() + "'"
                        + ");" ;
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("El cliente ha sido registrado.");
        return msg;
    }

    public RespuestaApi updateCustomer(Customer customer, int id) {
        String query =
                "UPDATE customer SET "
                        + "nombre = '" + customer.getNombre() + "',"
                        + "apellidos = '" + customer.getApellidos() + "',"
                        + "rfc = '" + customer.getRfc() + "',"
                        + "correo = '" + customer.getCorreo() + "',"
                        + "id_region = '" + customer.getRegion().getId() + "'"
                        + "WHERE id = " + id + ";";
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("El cliente ha sido actualizado");
        return msg;
    }

    public RespuestaApi deleteCustomer(int id) {
        String query = "DELETE FROM customer WHERE id = " + id + ";";
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("El cliente ha sido eliminado");
        return msg;
    }


}
