/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.mobile;

import com.fabsol.fb.dao.DAO;

/**
 *
 * @author Faraz Ahmad
 */
public interface MobileService {

    /**
     * @return the dao
     */
    DAO getDao();

    /**
     * @param dao the dao to set
     */
    void setDao(DAO dao);

}
