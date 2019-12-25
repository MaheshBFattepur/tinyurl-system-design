package com.tinyurl.services;

import com.tinyurl.model.TinyUrlModel;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public interface UserService {

  TinyUrlModel generateTinyUrl(String longUrl);

  TinyUrlModel getLongUrl(String tinyUrl);
}
