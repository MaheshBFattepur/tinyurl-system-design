package com.tinyurl.model;

import java.math.BigInteger;

public class TinyUrlModel {
  public BigInteger applicationCounter;
  public String longUrl;
  public String tinyUrl;

  public TinyUrlModel(BigInteger applicationCounter, String longUrl, String tinyUrl) {
    this.applicationCounter = applicationCounter;
    this.longUrl = longUrl;
    this.tinyUrl = tinyUrl;
  }

}
