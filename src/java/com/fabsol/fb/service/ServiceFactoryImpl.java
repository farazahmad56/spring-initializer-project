package com.fabsol.fb.service;

import com.fabsol.fb.home.HomeService;
import com.fabsol.fb.login.LoginService;
import com.fabsol.fb.mobile.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactoryImpl implements ServiceFactory {

    @Autowired
    private HomeService homeService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MobileService mobileService;

    @Override
    public HomeService getHomeService() {
        return this.homeService;
    }

    @Override
    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }

    /**
     * @return the loginService
     */
    @Override
    public LoginService getLoginService() {
        return loginService;
    }

    /**
     * @param loginService the loginService to set
     */
    @Override
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * @return the mobileService
     */
    @Override
    public MobileService getMobileService() {
        return mobileService;
    }

    /**
     * @param mobileService the mobileService to set
     */
    @Override
    public void setMobileService(MobileService mobileService) {
        this.mobileService = mobileService;
    }
}
