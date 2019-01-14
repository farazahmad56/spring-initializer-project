/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.home;

import com.fabsol.fb.dao.DAO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Faraz
 */
public interface HomeService {

    /**
     * @return the dao
     */
    DAO getDao();

    /**
     * @param dao the dao to set
     */
    void setDao(DAO dao);

    List<Map<String, Object>> getCountries();
}
