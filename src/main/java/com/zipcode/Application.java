package com.zipcode;

import com.zipcode.service.IOService;
import com.zipcode.service.ZipCodeService;
import com.zipcode.service.impl.IOServiceImpl;
import com.zipcode.service.impl.ZipCodeServiceImpl;

import javax.validation.ValidationException;


/**
 * Entry point to the application. Calls the com.zipcode.ZipCodeProcessor to provide a
 * minimum number of ranges required to represent the same restrictions as the input.
 */
public class Application {

  public static void main(String args[]){
    ZipCodeService zipCodeService = new ZipCodeServiceImpl();
    IOService ioService = new IOServiceImpl();
    ZipCodeProcessor processor = new ZipCodeProcessor(ioService, zipCodeService);
    try {
      processor.execute();
    } catch (ValidationException e){
      System.out.println(e.getMessage());
    }
  }
}
