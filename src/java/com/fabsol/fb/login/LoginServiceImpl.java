/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.login;

import com.fabsol.fb.dao.DAO;
import com.fabsol.fb.model.Encryption;
import com.fabsol.fb.model.UserVO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faraz
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private DAO dao;

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
    public UserVO verifyLogin(String userName, String password) {
        UserVO user = null;
        try {
            List list = this.getDao().getData("SELECT WU.*,CN.COUNTRY_NME,C.CITY_NME FROM WEB_USERS WU,COUNTRY CN,CITY C "
                    + " WHERE WU.COUNTRY_ID=CN.COUNTRY_ID AND WU.CITY_ID=C.CITY_ID AND UPPER(WU.USERNAME)='" + userName.toUpperCase() + "' "
                    + " AND WU.PASSWORD='" + password + "' ");
            if (list != null && list.size() > 0) {
                user = new UserVO();
                Map map = (Map) list.get(0);
                user.setUsername(map.get("USERNAME") != null ? map.get("USERNAME").toString() : "");
                user.setFullName(map.get("FULL_NME") != null ? map.get("FULL_NME").toString() : "");
                user.setEmail(map.get("EMAIL") != null ? map.get("EMAIL").toString() : "");
                user.setContactNo(map.get("CONTACT_NO") != null ? map.get("CONTACT_NO").toString() : "");
                user.setUserType(map.get("ACCOUNT_TYP") != null ? map.get("ACCOUNT_TYP").toString() : "");
                user.setProfileName(map.get("PROFILE_IMG") != null ? map.get("PROFILE_IMG").toString() : "");
                user.setCoverImage(map.get("COVER_IMG") != null ? map.get("COVER_IMG").toString() : "");
                user.setCountryName(map.get("COUNTRY_NME") != null ? map.get("COUNTRY_NME").toString() : "");
                user.setCityName(map.get("CITY_NME") != null ? map.get("CITY_NME").toString() : "");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public String insertUserSession(String userName, String ip, String action, String id) {
        boolean flag = false;
        String sessionId = "";
        try {
            String query = "";
            if (action != null && action.equalsIgnoreCase("LogIn")) {
                List list = this.getDao().getJdbcTemplate().queryForList("SELECT SEQ_USER_SESSION_ID.NEXTVAL SESSIONID FROM DUAL");
                if (list != null && list.size() > 0) {
                    Map map = (Map) list.get(0);
                    sessionId = map.get("SESSIONID").toString();
                }
                query = "INSERT INTO USER_SESSION(USER_SESSION_ID,LOGIN_TIME,IP_ADDRESS,USER_NME) "
                        + " VALUES(" + sessionId + ",SYSDATE,'" + ip + "','" + userName + "') ";
            } else if (id != null && !id.isEmpty()) {
                query = "UPDATE USER_SESSION SET LOGOUT_TIME=SYSDATE WHERE USER_SESSION_ID=" + id + "";
            } //                query = "INSERT INTO USER_SESSION(USER_SESSION_ID,LOGOUT_TIME,IP_ADDRESS,USER_NME) VALUES"
            //                        + "(SEQ_USER_SESSION_ID.NEXTVAL,SYSDATE,'" + ip + "','" + userName + "')";

            int i = this.getDao().getJdbcTemplate().update(query);
            if (i > 0) {
                flag = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (flag) {
            return sessionId;
        } else {
            return "";
        }
    }
    
    @Override
    public boolean changePassword(String userName, String newPassword) {
        boolean flag = false;
        try {
            Encryption pswdSec = new Encryption();
            newPassword = pswdSec.encrypt(newPassword);
            String query = "UPDATE WEB_USERS SET PASSWORD='" + newPassword + "' WHERE UPPER(USERNAME)='" + userName.toUpperCase() + "'  ";
            int i = this.dao.getJdbcTemplate().update(query);
            if (i > 0) {
                flag = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
