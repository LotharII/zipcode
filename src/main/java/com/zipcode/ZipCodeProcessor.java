package com.zipcode;

import com.zipcode.entity.Range;
import com.zipcode.service.IOService;
import com.zipcode.service.ZipCodeService;
import com.zipcode.utils.ZipCodeParser;

import javax.validation.ValidationException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * Performs the overall application workflow.
 */
public class ZipCodeProcessor {

  private static final String CONFIG_FILE = "config.cfg";
  private IOService ioService;
  private ZipCodeService zipCodeService;

  public ZipCodeProcessor(IOService ioService, ZipCodeService zipCodeService) {
    this.ioService = ioService;
    this.zipCodeService = zipCodeService;
  }

  /**
   * Executes the read, mergeZipCodes and write steps. Could be configured with "config.cfg" file.
   *
   * @throws ValidationException
   */
  public void execute() throws ValidationException {
    Properties prop = new Properties();
    try {
      prop.load(getClass().getClassLoader().getResourceAsStream(CONFIG_FILE));
      TreeSet<Range> ranges = ZipCodeParser.parseZipcodes(getInputData(prop));
      Set<Range> mergedRanges = zipCodeService.mergeZipCodes(ranges);
      writeOutputData(prop, prepareOutputData(mergedRanges));
    } catch (IOException e) {
      System.out.println("Failed to load a config file");
    }
  }

  public String prepareOutputData(Set<Range> mergedRanges) {
    StringBuffer buffer = new StringBuffer();
    for (Range range : mergedRanges) {
      buffer.append(range.toString());
      buffer.append(" ");
    }
    return buffer.toString().trim();
  }

  private void writeOutputData(Properties prop, String content) {
    String fileName = prop.getProperty("outputFile");
    ioService.write(fileName, content);
  }

  private String getInputData(Properties prop) {
    String fileName = prop.getProperty("inputFilePath");
    return ioService.read(fileName);
  }
}
