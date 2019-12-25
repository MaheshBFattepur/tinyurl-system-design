package com.tinyurl.services.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.tinyurl.model.TinyUrlModel;
import com.tinyurl.services.UserService;
import com.tinyurl.utils.Constants;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
@Service
public class UserServiceimpl implements UserService {
  public static BigInteger counter = new BigInteger("0");

  @Override
  public TinyUrlModel generateTinyUrl(String longUrl) {
    counter = counter.add(new BigInteger("1"));

    TinyUrlModel tinyUrl = null;

    if (counter.compareTo(Constants.numberOfCombinations) < 0) {
      tinyUrl = new TinyUrlModel(counter, longUrl,
          longUrl.split("/")[0] + "//" + longUrl.split("/")[1] + longUrl.split("/")[2] + "/" + encodeToBase62());
      Constants.tinyUrlDb.put(counter, tinyUrl);
    } else {
      counter.subtract(new BigInteger("1"));
    }
    return tinyUrl;
  }

  @Override
  public TinyUrlModel getLongUrl(String tinyUrl) {
    BigInteger decodeCounter = getLongUrlFromTinyUrl(tinyUrl.split("/")[3]);

    TinyUrlModel tinyObj = Constants.tinyUrlDb.get(decodeCounter);
    if (tinyObj == null) {
      return new TinyUrlModel(null, "Invalid tinyURL", tinyUrl);
    }
    return tinyObj;
  }

  public String encodeToBase62() {

    StringBuffer tinyUrlSb = new StringBuffer();

    BigInteger loop = counter;

    while (!BigInteger.ZERO.equals(loop)) {
      BigInteger digit = loop.mod(Constants.baseLength);
      loop = loop.divide(Constants.baseLength);
      tinyUrlSb.append(Constants.charArray[digit.intValue()]);
    }

    return tinyUrlSb.reverse().toString();

  }

  public BigInteger getLongUrlFromTinyUrl(String tinyUrl) {
    tinyUrl = new StringBuffer(tinyUrl).reverse().toString();
    char[] tinyUrlChar = tinyUrl.toCharArray();
    BigInteger sum = BigInteger.ZERO;
    Integer exp = 0;

    for (int i = 0; i < tinyUrlChar.length; i++) {
      Integer charIndex = new String(Constants.charArray).indexOf(tinyUrlChar[i]);
      sum = sum.add(Constants.baseLength.pow(exp).multiply(new BigInteger(Integer.toString(charIndex))));
      exp++;
    }
    return sum;
  }

  public static void main(String[] args) {
    String url = "https://www.youtube.com/watch?v=JQDHz72OA3c&t=382s";

    String[] arr = url.split("/");
    System.out.println(arr[0] + "//" + arr[1] + arr[2] + "/");
  }
}
