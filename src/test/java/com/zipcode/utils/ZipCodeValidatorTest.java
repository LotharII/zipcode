package com.zipcode.utils;

import com.zipcode.entity.Range;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.validation.ValidationException;
import java.util.TreeSet;

public class ZipCodeValidatorTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void zipCodeValidatorEmptyTest(){
    String range = "";
    thrown.expect(ValidationException.class);
    thrown.expectMessage("Validation error: Zip code is empty.");
    ZipcodeRangeValidator.validate(range);
  }

  @Test
  public void zipCodeValidatorWrongStringFormatTest(){
    String range = "[11111]";
    thrown.expect(ValidationException.class);
    thrown.expectMessage("Incorrect input format. Zip code ranges should be provided in the following " +
            "format: [<zipcode>, <zipcode>] [<zipcode>, <zipcode>] ...");
    ZipcodeRangeValidator.validate(range);
  }

  @Test
  public void zipCodeValidatorEmptySetTest(){
    TreeSet<Range> set = new TreeSet();
    thrown.expect(ValidationException.class);
    thrown.expectMessage("Validation error: Zip code list is empty.");
    ZipcodeRangeValidator.validate(set);
  }

  @Test
  public void zipCodeValidatorIncorrectRangeTest(){
    Range range = new Range(10001,10000);
    thrown.expect(ValidationException.class);
    thrown.expectMessage("Validation error: rangeFrom should be less than rangeTo:" + range);
    ZipcodeRangeValidator.validate(range);
  }

}
