package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ManagementService;

import java.util.List;


@Controller
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    // Serve the management details in a table
    @GetMapping("/details")
    public String getManagementDetails(Model model) {
        List<Object[]> results = managementService.getManagementDetails();
        model.addAttribute("managementDetails", results);
        return "managementDetails"; // This refers to the Thymeleaf HTML file
    }
}
