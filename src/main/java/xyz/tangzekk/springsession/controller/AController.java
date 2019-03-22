package xyz.tangzekk.springsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class AController {


    @GetMapping(value = "/get1")
    public Map<String, Object> getSession(HttpServletRequest request) {
        request.getSession().setAttribute("username", "kk");
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        return map;
    }


    @GetMapping(value = "/get2")
    public String get(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("username");

        return userName;
    }

}