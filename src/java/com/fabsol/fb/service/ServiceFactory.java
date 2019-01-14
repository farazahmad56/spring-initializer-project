/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.service;

import com.fabsol.fb.home.HomeService;
import com.fabsol.fb.login.LoginService;
import com.fabsol.fb.mobile.MobileService;

/**
 *
 * @author Faraz
 */
public interface ServiceFactory {

    HomeService getHomeService();

    void setHomeService(HomeService homeService);

    LoginService getLoginService();

    void setLoginService(LoginService loginService);

    MobileService getMobileService();

    void setMobileService(MobileService mobileService);
}
