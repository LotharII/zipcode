package com.zipcode.utils;

import com.zipcode.entity.Range;

import javax.validation.ValidationException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Data validator. Provides multiple validate methods.
 */
public class ZipcodeRangeValidator {
  private static final String pattern = "^\\[\\d{5},\\d{5}\\]$";

  /**
   * Validates a range.
   * @param zipRange
   * @throws ValidationException
   */
  public static void validate(String zipRange) throws ValidationException{
    if (zipRange.isEmpty()) {
      throw new ValidationException("Validation error: Zip code is empty.");
    }
    Pattern regex = Pattern.compile(pattern);
    Matcher matcher = regex.matcher(zipRange);
    if (!matcher.find()) {
      throw new ValidationException("Incorrect input format. Zip code ranges should be provided in the following" +
              " format: [<zipcode>, <zipcode>] [<zipcode>, <zipcode>] ...");
    }
  }

  /**
   * Validates a {@link Range} set.
   * @param zipRanges
   * @throws ValidationException
   */
  public static void validate(Set<Range> zipRanges) throws ValidationException{
    if (zipRanges.isEmpty()) {
      throw new ValidationException("Validation error: Zip code list is empty.");
    }
  }

  /**
   * Validates a {@link Range} object.
   * @param range
   * @throws ValidationException
   */
  public static void validate(Range range) throws ValidationException{
    if (range.getRangeFrom() > range.getRangeTo()) {
      throw new ValidationException("Validation error: rangeFrom should be less than rangeTo:" + range.toString());
    }
  }
}
