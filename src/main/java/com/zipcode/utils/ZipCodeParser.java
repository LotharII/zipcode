package com.zipcode.utils;

import com.zipcode.entity.Range;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Util class which provides parsing of the input data.
 */
public class ZipCodeParser {

  /**
   * Parses the input data and creates the {@link TreeSet} with parsed ranges.
   * @param zipCodeRanges Input string to parse.
   * @return {@link TreeSet} with parsed ranges.
   */
  public static TreeSet<Range> parseZipcodes(String zipCodeRanges){
    TreeSet<Range> result = new TreeSet<>();
    Arrays.stream(zipCodeRanges.split(" ")).forEach(item -> {
      ZipcodeRangeValidator.validate(item);
      result.add(parseRange(item));
    });
    return result;
  }

  /**
   * Pases the particular range.
   * @param rangeStr Range to parse.
   * @return parsed {@link Range} object.
   */
  private static Range parseRange(String rangeStr){
    String[] values = rangeStr.replaceAll("\\[|\\]", "").split(",");
    Range range = new Range(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    ZipcodeRangeValidator.validate(range);
    return range;
  }
}
