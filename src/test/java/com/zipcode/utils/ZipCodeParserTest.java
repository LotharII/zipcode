package com.zipcode.utils;

import com.zipcode.Utils;
import com.zipcode.entity.Range;
import org.junit.Test;

import javax.validation.ValidationException;

import static org.junit.Assert.assertEquals;
import java.util.TreeSet;

public class ZipCodeParserTest {

  @Test
  public void zipCodeParserSuccessTest() {
    String zipCodes = "[10000,10100] [10050,10150] [20000,20000]";
    TreeSet<Range> expected = Utils.buildSuccessZipCodeRanges();
    TreeSet<Range> ranges = ZipCodeParser.parseZipcodes(zipCodes);
    assertEquals(expected, ranges);
  }

  @Test(expected = ValidationException.class)
  public void zipCodeParserWrondDataTest() {
    String zipCodes = "[10000,10100][10050,10150] [20000,20000]";
    TreeSet<Range> ranges = ZipCodeParser.parseZipcodes(zipCodes);
  }

  @Test(expected = ValidationException.class)
  public void zipCodeParserWrondNumbersTest() {
    String zipCodes = "[10000,10100] [101050,10150] [20000,20000]";
    TreeSet<Range> ranges = ZipCodeParser.parseZipcodes(zipCodes);
  }
}
