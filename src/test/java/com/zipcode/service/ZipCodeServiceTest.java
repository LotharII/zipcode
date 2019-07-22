package com.zipcode.service;

import com.zipcode.entity.Range;
import org.junit.Test;
import com.zipcode.service.impl.ZipCodeServiceImpl;
import com.zipcode.Utils;


import javax.validation.ValidationException;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ZipCodeServiceTest {

  private ZipCodeService service = new ZipCodeServiceImpl();

  @Test
  public void mergeZipCodeSuccessTest(){
    Set<Range> expected = new TreeSet<>();
    expected.add(new Range(10000, 10150));
    expected.add(new Range(20000, 30100));
    Set<Range> mergedRanges = service.mergeZipCodes(Utils.buildSuccessZipCodeRanges());
    assertEquals(expected, mergedRanges);
  }

  @Test(expected = ValidationException.class)
  public void mergeZipCodeEmptyTest(){
    service.mergeZipCodes(new TreeSet<>());
  }

}
