/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.dao;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Faraz
 */
public interface DAO {

    List<Map<String, Object>> getData(String query);

    JdbcTemplate getJdbcTemplate();

    boolean insertAll(String[] query, String userName);

    boolean insertAll(List<String> query, String userName);

    @Autowired
    void setDataSource(DataSource dataSource);

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}
