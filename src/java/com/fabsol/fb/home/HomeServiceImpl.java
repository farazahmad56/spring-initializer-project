/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.home;

import com.fabsol.fb.dao.DAO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faraz
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    DAO dao;

    /**
     * @return the dao
     */
    @Override
    public DAO getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    @Override
    public void setDao(DAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Map<String, Object>> getCountries() {
        List<Map<String, Object>> list = null;
        try {
            String query = "SELECT * FROM COUNTRY ORDER BY COUNTRY_NME";
            list = this.dao.getData(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
