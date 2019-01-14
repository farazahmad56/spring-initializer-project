/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.mobile;

import com.fabsol.fb.model.UserVO;
import com.fabsol.fb.service.ServiceFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Faraz Ahmad
 */
@RestController
@RequestMapping(path = "mobile")
public class MobileController {

    @Autowired
    private ServiceFactory serviceFactory;

    @CrossOrigin()
    @GetMapping(path = "getCountries")
    @ResponseBody
    public String getCountries()
            throws IOException {
        JSONObject obj = null;
        List list = this.serviceFactory.getHomeService().getCountries();
        List<JSONObject> objList = new ArrayList();
        if ((list != null) && (list.size() > 0)) {
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                obj = new JSONObject();
                Iterator<Map.Entry<String, Object>> itr = map.entrySet().iterator();
                while (itr.hasNext()) {
                    String key = (String) ((Map.Entry) itr.next()).getKey();
                    obj.put(key, map.get(key) != null ? map.get(key).toString() : "");
                }
                objList.add(obj);
            }
        }
        return objList.toString();
    }

   

    @CrossOrigin()
    @ResponseBody
    @PostMapping(path = "save-user-signup")
    public String saveUser(@ModelAttribute UserVO user) throws IOException {
        boolean flag =false;// this.serviceFactory.getHomeService().saveUser(user);
        JSONObject obj = new JSONObject();
        if (flag) {
            obj.put("result", "Success");
        } else {
            obj.put("result", "Failed");
        }
        return obj.toString();
    }

}
