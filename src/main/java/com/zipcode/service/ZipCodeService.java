package com.zipcode.service;

import com.zipcode.entity.Range;


import javax.validation.ValidationException;
import java.util.List;
import java.util.TreeSet;


public interface ZipCodeService {

  /**
   * Performs the zip codes merging logic. Takes the {@link TreeSet} of {@link Range} objects and returns the {@link List} of merged
   * {@link Range} objects.
   * @param zipRanges {@link TreeSet} with input data.
   * @return {@link List} of merged zip code ranges.
   * @throws ValidationException
   */
  List<Range> mergeZipCodes(TreeSet<Range> zipRanges) throws ValidationException;
}
