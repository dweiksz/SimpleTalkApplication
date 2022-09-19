package com.simpletalk.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleTalkController {

    // Handles root or (/) endpoint and returns start page
    @RequestMapping("/")
    public String index() {
        return "startPage";
    }

}
