package com.zipcode.service.impl;

import com.zipcode.entity.Range;
import com.zipcode.service.ZipCodeService;
import com.zipcode.utils.ZipcodeRangeValidator;

import javax.validation.ValidationException;
import java.util.Set;
import java.util.TreeSet;

public class ZipCodeServiceImpl implements ZipCodeService{

  /**
   * Performs the zip codes merging logic. Takes the {@link TreeSet} of {@link Range} objects and returns the {@link List} of merged
   * {@link Range} objects.
   * @param zipRanges {@link TreeSet} with input data.
   * @return {@link Set} of merged zip code ranges.
   * @throws ValidationException
   */
  public Set<Range> mergeZipCodes(TreeSet<Range> zipRanges) throws ValidationException{
    ZipcodeRangeValidator.validate(zipRanges);
    TreeSet<Range> mergedRanges = new TreeSet<>();
    mergedRanges.add(zipRanges.first());
    Range current = mergedRanges.last();
    while(!zipRanges.isEmpty()) {
      Range next = zipRanges.pollFirst();
      if (next.getRangeFrom() > current.getRangeTo()) {
        mergedRanges.add(next);
        current = mergedRanges.last();
      } else if (next.getRangeFrom() <= current.getRangeTo() && next.getRangeTo() > current.getRangeTo()) {
        extendRange(current, next);
      }
    }
    return mergedRanges;
  }

  /**
   * Extends the range.
   * @param range Range to extend.
   * @param nextRange Range to extend to.
   */
  private void extendRange(Range range, Range nextRange) {
    range.setRangeTo(nextRange.getRangeTo());
  }

}
