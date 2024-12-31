package com.back_ssm.controller;

import com.back_ssm.pojo.Tester;
import com.back_ssm.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Tester")
public class TesterController {
    @Autowired
    private TesterService testerService;
    @RequestMapping("/find_tester")
    public String findTester(Model model){
        model.addAttribute("Testers",testerService.findTesters());
        return  "tester/test_list";
    }
}
