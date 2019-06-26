package com.zipcode.entity;

import java.util.Objects;

/**
 * Object that describes a zip code range.
 */
public class Range implements Comparable<Range>{
  private Integer rangeFrom;
  private Integer rangeTo;

  public Range(Integer rangeFrom, Integer rangeTo) {
    this.rangeFrom = rangeFrom;
    this.rangeTo = rangeTo;
  }

  public Integer getRangeFrom() {
    return rangeFrom;
  }

  public void setRangeFrom(Integer rangeFrom) {
    this.rangeFrom = rangeFrom;
  }

  public Integer getRangeTo() {
    return rangeTo;
  }

  public void setRangeTo(Integer rangeTo) {
    this.rangeTo = rangeTo;
  }

  @Override
  public String toString() {
    return "["+rangeFrom+","+rangeTo+"]";
  }

  @Override
  public int compareTo(Range o) {
    return rangeFrom - o.rangeFrom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Range range = (Range) o;
    return Objects.equals(rangeFrom, range.rangeFrom) &&
            Objects.equals(rangeTo, range.rangeTo);
  }

  @Override
  public int hashCode() {

    return Objects.hash(rangeFrom, rangeTo);
  }
}
