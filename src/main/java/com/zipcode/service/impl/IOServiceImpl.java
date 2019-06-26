package com.zipcode.service.impl;

import org.apache.commons.io.IOUtils;
import com.zipcode.service.IOService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Input output com.zipcode.service. Provides the implementation for read and write methods.
 */
public class IOServiceImpl implements IOService{

  private static final String DEFAULT_INPUT_FILE = "input.txt";
  private static final String DEFAULT_OUTPUT_FILE = "result.txt";

  /**
   * Reads the file with provided {@param fileName} and returns the file content.
   * If {@param fileName} is null or empty, the default fileName will be used.
   * @param fileName Name of a file to read.
   * @return File content.
   */
  public String read(String fileName) {
    String result = "";
    try (InputStream input = (fileName == null || fileName.isEmpty())
            ? getClass().getClassLoader().getResourceAsStream(DEFAULT_INPUT_FILE)
            : new FileInputStream(fileName)) {
      result = IOUtils.toString(input, "UTF-8");
    } catch (FileNotFoundException e){
      System.out.println("Input file not found:" + fileName);
    } catch (IOException e){
      System.out.println("Cannot close the input stream.");
    }
    return result;
  }

  /**
   * Writes provided content to a file with provided fileName.
   * If {@param fileName} is null or empty, the default fileName will be used.
   * @param fileName Name of a file to write.
   * @param content Content to write.
   */
  public void write(String fileName, String content){
    fileName = (fileName == null || fileName.isEmpty()) ? DEFAULT_OUTPUT_FILE : fileName;
    try (
            OutputStream output = new FileOutputStream(fileName);
            PrintWriter writer = new PrintWriter(output)
    ) {
      writer.write(content.toString());
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Cannot write to the file:" + fileName);
    } catch (IOException e) {
      System.out.println("Failed to close output stream.");
    }
  }

}
