/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.home;

import com.fabsol.fb.service.ServiceFactory;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Faraz
 */
@Controller
@RequestMapping({"/"})
public class HomeController {

    @Autowired
    ServiceFactory serviceFactory;

    @RequestMapping({""})
    public ModelAndView viewIndex() {
        Map map = new HashMap();
//        map.put("cities", this.serviceFactory.getHomeService().getCitiesForPakistan());
//        map.put("specilities", this.serviceFactory.getHomeService().getAllSpecilities());
        //map.put("featuredDoctors", this.serviceFactory.getHomeService().getFeaturedDoctors());

        return new ModelAndView("index", "refData", map);
    }
}
