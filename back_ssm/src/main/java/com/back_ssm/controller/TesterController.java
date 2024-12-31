package com.back_ssm.controller;

import com.back_ssm.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TesterController {
    @Autowired
    private TesterService testerService;
    @RequestMapping(value = "/find_tester", method = RequestMethod.GET)
    public String findTester(Model model){
        System.out.println("成功");
        model.addAttribute("testers",testerService.findTesters());
        return  "tester/test_list";
    }
}
