package com.tinyurl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
@Controller
public class Home {
  @RequestMapping("/")
  public String home() {
    return "index";
  }
}
