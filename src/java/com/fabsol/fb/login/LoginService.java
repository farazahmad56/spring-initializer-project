/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.login;

import com.fabsol.fb.dao.DAO;
import com.fabsol.fb.model.UserVO;

/**
 *
 * @author Faraz
 */
public interface LoginService {

    /**
     * @return the dao
     */
    DAO getDao();

    /**
     * @param dao the dao to set
     */
    void setDao(DAO dao);

    UserVO verifyLogin(String userName, String password);

    String insertUserSession(String userName, String ip, String action, String id);
    
    boolean changePassword(String userName, String newPassword);
}
