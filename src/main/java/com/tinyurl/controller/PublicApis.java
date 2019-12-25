package com.tinyurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinyurl.model.TinyUrlModel;
import com.tinyurl.services.UserService;
import com.tinyurl.utils.Constants;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
@RequestMapping("/api/")
@RestController
public class PublicApis {
  @Autowired
  UserService userService;

  @RequestMapping(method = RequestMethod.POST, value = Constants.GENERATE_TINY_URL)
  public TinyUrlModel generateTinyUrl(@RequestParam String longUrl) {
    return userService.generateTinyUrl(longUrl);
  }

  @RequestMapping(method = RequestMethod.GET, value = Constants.GET_LONG_URL)
  public TinyUrlModel getLongUrl(@RequestParam String tinyUrl) {
    return userService.getLongUrl(tinyUrl);
  }
}
