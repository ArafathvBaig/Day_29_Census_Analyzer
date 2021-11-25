package com.Day_29_Census_Analyzer;

import org.junit.Test;

import com.opencsv.exceptions.CsvException;

import junit.framework.Assert;

public class StateCensusAnalyserTest 
{
    String filePath = "C:\\Users\\Arafath Baig\\eclipse-workspace\\Day_29_Census_Analyzer\\src\\main\\resources\\IndiaStateCensusData.csv";
    
    @Test
    public void givenStateCensusRecordShouldReturnNumberOfRecords() throws CsvException{
    StateCensusAnalyser obj = new StateCensusAnalyser();
    try {
        int countRecords = obj.readCensusFile(filePath);
        Assert.assertEquals(29, countRecords);
    }
    catch (StateCensusException e){
        System.out.println(e.getMessage());
    }
    }
    
    @Test
    public void givenIncorrectFileFormatShouldReturnCustomException() throws CsvException{
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile("C:\\\\Users\\\\Arafath Baig\\\\eclipse-workspace\\\\Day_29_Census_Analyzer\\\\src\\\\main\\\\resources\\IndiaStateCensusData");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format",countRecords);
        }
        catch (StateCensusException e){
        }
    }
    
    @Test
    public void givenIncorrectFileTypeShouldReturnCustomException() throws CsvException{
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile("C:\\\\Users\\\\Arafath Baig\\\\eclipse-workspace\\\\Day_29_Census_Analyzer\\\\src\\\\main\\\\resources\\IndiaStateCensusData.pdf");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format",countRecords);
        }
        catch (StateCensusException e){
        }
    }
    
    @Test
    public void givenCorrectFileTypeButIncorrectDelimterShouldReturnCustomException() throws CsvException{
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile("C:\\\\Users\\\\Arafath Baig\\\\eclipse-workspace\\\\Day_29_Census_Analyzer\\\\src\\\\main\\\\resources\\IndiaStateCensusData,pdf");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format",countRecords);
        }
        catch (StateCensusException e){
        }
    }
    
    @Test
    public void givenCorrectFileTypeButIncorrectHeaderrShouldReturnCustomException(){
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            String []header = {"State","Population","AreaInSqKm","DensityPerSqKm"} ;
            boolean checkHeader = obj.readHeader("C:\\\\Users\\\\Arafath Baig\\\\eclipse-workspace\\\\Day_29_Census_Analyzer\\\\src\\\\main\\\\resources\\IndiaStateCensusData.csv",header);
           Assert.assertTrue(checkHeader);

        }
        catch (StateCensusException e){
        }
    }
}
