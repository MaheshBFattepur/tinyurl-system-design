package com.tinyurl.utils;

import java.math.BigInteger;
import java.util.HashMap;

import com.tinyurl.model.TinyUrlModel;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public interface Constants {

  static final String GENERATE_TINY_URL = "/generateTinyUrl";
  static final String GET_LONG_URL = "/getLongUrl";
  static final Integer tinyUrlLength = 7;

  static final char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
  static final BigInteger baseLength = new BigInteger(Integer.toString(charArray.length));
  static final BigInteger numberOfCombinations = baseLength.pow(tinyUrlLength);

  static HashMap<BigInteger, TinyUrlModel> tinyUrlDb = new HashMap<>();

}
