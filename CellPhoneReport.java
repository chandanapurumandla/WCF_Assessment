package com.cellphone.usage.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVWriter;

public class CellPhoneReport {

	public static void main(String args[]) {
		List<CellPhone> cellPhones = getCellPhoneModel();
		List<CellPhoneUsage> cellPhoneUsage = getCellPhoneUsageModel();	
		writeReportHeader(cellPhones, cellPhoneUsage);
	}

	/* To retrieve Cell Phone data from CSV file.
	 * 
	 */
	private static List<CellPhone> getCellPhoneModel() {
		List<CellPhone> cellPhones = new ArrayList<CellPhone>();
		try {

			BufferedReader br = new BufferedReader(new FileReader(new File("CellPhone.csv")));
			String line;
			Boolean ignoreFirstLine = true;
			while ((line = br.readLine()) != null) {

				String[] entries = line.split(",");

				if (!ignoreFirstLine) {
					CellPhone cellPhone = new CellPhone(entries[0].replace("\"",""), entries[1], entries[2], entries[3].replace("\"",""));

					cellPhones.add(cellPhone);
				}
				ignoreFirstLine = false;
			}
		} catch (Exception e) {
			// Write exception to logger or database.
			e.printStackTrace();
		}
		return cellPhones;
	}
	/* retrieves Cell phone usage data from CSV file
	 * 
	 * */
	private static List<CellPhoneUsage> getCellPhoneUsageModel() {
		List<CellPhoneUsage> cellPhoneUsage = new ArrayList<CellPhoneUsage>();
		try {

			BufferedReader br = new BufferedReader(new FileReader(new File("CellPhoneUsageByMonth.csv")));
			String line;
			Boolean ignoreFirstLine = true;
			while ((line = br.readLine()) != null) {

				String[] entries = line.split(",");

				if (!ignoreFirstLine) {
					CellPhoneUsage usage = new CellPhoneUsage(entries[0].replace("\"",""), entries[1], Integer.valueOf(entries[2]), Float.valueOf(entries[3].replace("\"","")));

					cellPhoneUsage.add(usage);
				}
				ignoreFirstLine = false;
			}
		} catch (Exception e) {
			// Write exception to logger or database.
			e.printStackTrace();
		}
		return cellPhoneUsage;
	}
	
	public static void writeReportHeader(List<CellPhone> cellPhones, List<CellPhoneUsage> cellPhoneUsage)
	{
	    try { 
	    	 File file = new File("Report.csv"); 
	    	 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter("Report.csv"); 
	  
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer = new CSVWriter(outputfile); 
	  
	        // adding header to csv 
	        String[] header = { "Report Run Date", "Number of Phones", "Total Minutes","Total Data","Average Minutes","Average Data" }; 
	        writer.writeNext(header); 
	  
	        // add data to csv 
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    	Date reportDate = new Date();
	    	
	    	int numberOfPhones = cellPhoneUsage.size();
	    	int totalMinutes = cellPhoneUsage.stream().mapToInt(o -> o.getTotalMinutes()).sum();
	    	double totalData = cellPhoneUsage.stream().mapToDouble(o -> o.getTotalData()).sum();
	    	double averageMinutes = totalMinutes / numberOfPhones;
	    	double averageData = totalData / numberOfPhones;
	    	
	        String[] reportHeaderData = { dateFormat.format(reportDate), Integer.toString(numberOfPhones), Integer.toString(totalMinutes), 
	        				   Double.toString(totalData), Double.toString(averageMinutes), Double.toString(averageData) }; 
	        writer.writeNext(reportHeaderData);
	        
	     // adding header to csv 
	        String[] reportDetail = { "Employee Id", "Employee Name", "Model","Purchase Date" }; 
	        writer.writeNext(reportDetail);
	        
	        for(CellPhone cellPhone : cellPhones) {
	        	String[] reportDetailData = { cellPhone.getEmployeeId(), cellPhone.getEmployeeName(), cellPhone.getModel(), cellPhone.getPurchaseDate()};
	        	writer.writeNext(reportDetailData);
	        }
	  
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
	}
}