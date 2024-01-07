package com.mycompany.VirtualSpace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/virtual-space")
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
