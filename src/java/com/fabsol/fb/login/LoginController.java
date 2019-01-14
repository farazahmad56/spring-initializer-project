/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.login;

import com.fabsol.fb.model.Encryption;
import com.fabsol.fb.service.ServiceFactory;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.fabsol.fb.model.UserVO;
import java.io.IOException;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Faraz
 */
@Controller
@RequestMapping(path = "login")
public class LoginController {

    @Autowired
    ServiceFactory serviceFactory;

    @RequestMapping(path = "")
    public ModelAndView login() {
        Map map = new HashMap();
        return new ModelAndView("login", "refData", map);
    }

    @RequestMapping(path = "verify-user-login")
    public ModelAndView verfiyLogin(HttpServletRequest request, HttpServletResponse res) {
        Map map = new HashMap();
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String ipAddress = "";
        ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        Encryption pswdSec = new Encryption();
        if (userName != null && userName.length() > 0 && password != null && password.length() > 0) {
            password = pswdSec.encrypt(password);
            UserVO user = this.serviceFactory.getLoginService().verifyLogin(userName, password);
            if (user != null) {
                String sessionId = this.serviceFactory.getLoginService().insertUserSession(userName, ipAddress, "LogIn", "");
                request.getSession().setAttribute("userName", user.getUsername());
                request.getSession().setAttribute("moduleId", "1");
                request.getSession().setAttribute("countries", this.serviceFactory.getHomeService().getCountries());
                user.setSessionId(sessionId);
                user.setUsername(user.getUsername());
                request.getSession().setAttribute("user", user);
                request.getSession().setMaxInactiveInterval(-1);
                return new ModelAndView("home", "refData", map);
            } else {
                map.put("msg", "invalid");
                return new ModelAndView("login", "refData", map);
            }
        } else {
            map.put("msg", "empty");
            return new ModelAndView("login", "refData", map);
        }
    }

    @RequestMapping(path = "verifyLoginForMoibileDevices")
    public void verifyLoginForMoibileDevices(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if ((password != null) && (password.length() > 0)) {
            Encryption pswdSec = new Encryption();
            password = pswdSec.encrypt(password);
        }
        JSONObject obj = new JSONObject();

        if ((userName != null) && (userName.length() > 0) && (password != null) && (password.length() > 0)) {
            UserVO user = this.serviceFactory.getLoginService().verifyLogin(userName, password);
            if (user != null) {
                obj.put("msg", "Login");
                obj.put("userName", user.getUsername());
                obj.put("fullName", user.getFullName());
                obj.put("email", user.getEmail());
                obj.put("contactNo", user.getContactNo());
                obj.put("userType", user.getUserType());
                obj.put("profileImage", user.getProfileName());
                obj.put("coverImage", user.getCoverImage());
            } else {
                obj.put("msg", "Invalid");
                obj.put("userName", "");
            }
        } else {
            obj.put("msg", "Empty");
            obj.put("userName", "");
        }
        response.getWriter().write(obj.toString());
    }

    @RequestMapping(path = "process-signout")
    public ModelAndView processSignOut(HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        String ipAddress = "";
        ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        UserVO user = (UserVO) request.getSession().getAttribute("user");
        String userName = user.getUsername();
        this.serviceFactory.getLoginService().insertUserSession(userName, ipAddress, "LogOut", user.getSessionId());
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("moduleId", null);
        request.getSession().invalidate();
        map.put("msg", "logged Out");
        return new ModelAndView("home", "refData", map);
    }

    @PostMapping(path = "processChangePassword")
    @ResponseBody
    public String processChangePassword(@ModelAttribute UserVO vo) throws IOException {
        boolean flag = this.serviceFactory.getLoginService().changePassword(vo.getUserId(), vo.getNewPassword());
        JSONObject obj = new JSONObject();
        if (flag) {
            obj.put("msg", "saved");
        } else {
            obj.put("msg", "error");
        }
        return obj.toString();
    }
}
