package com.zipcode.service;

/**
 * Input output interface.
 */
public interface IOService {
  /**
   * Reads the file with provided {@param fileName} and returns the file content.
   * If {@param fileName} is null or empty, the default fileName will be used.
   * @param fileName Name of a file to read.
   * @return File content.
   */
  String read(String fileName);

  /**
   * Writes provided content to a file with provided fileName.
   * If {@param fileName} is null or empty, the default fileName will be used.
   * @param fileName Name of a file to write.
   * @param content Content to write.
   */
  void write(String fileName, String content);
}
