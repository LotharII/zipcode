package com.zipcode;

import com.zipcode.entity.Range;

import java.util.TreeSet;

public class Utils {

  private Utils(){
  }

  public static TreeSet<Range> buildSuccessZipCodeRanges(){
    TreeSet<Range> zipRanges = new TreeSet<>();
    zipRanges.add(new Range(10000, 10100));
    zipRanges.add(new Range(10050, 10150));
    zipRanges.add(new Range(20000, 30100));
    return zipRanges;
  }
}
