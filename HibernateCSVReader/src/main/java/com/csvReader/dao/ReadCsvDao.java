package com.csvReader.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.ArrayList;

import com.csvReader.CsvEmloyee;

public class ReadCsvDao {
	
	public static String seperator = ",";
	public static String csv_filePath = "C:\\Users\\LENOVO\\eclipse-workspace\\HibernateCSVReader\\emp_data.csv"; // "../../../../../../emp_data.csv";

	public static void main(String[] args)throws Exception {
		try {
			List<CsvEmloyee> employeeList = new ArrayList<CsvEmloyee>();
			FileReader fr = new FileReader(csv_filePath);
			BufferedReader br = new BufferedReader(fr);
			 String data = null;

			while((data = br.readLine()) != null){
				String[] dataArray = data.split(seperator);
				CsvEmloyee csvEmp = new CsvEmloyee();

				if(!dataArray[0].toString().equals("id")) {
					System.out.println(dataArray[0] + "-->" + dataArray[1] + "==>" + dataArray[2]);

					csvEmp.setId(Integer.parseInt(dataArray[0]));
					csvEmp.setName(dataArray[1]);
					csvEmp.setSalary(Float.parseFloat(dataArray[2]));
	
					employeeList.add(csvEmp);
				}
			}
			
			br.close();
			
			ReadCsvDto readDto = new ReadCsvDto();
			boolean isDataAvailable = readDto.insert(employeeList);
			
			if(isDataAvailable) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

//	FileInputStream fstream = null;
//    try {
//        File inFile = new File("textfile.txt");
//        fstream = new FileInputStream(inFile);
//        // Get the object of DataInputStream
//        DataInputStream in = new DataInputStream(fstream);
//        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        // Do something with the stream
//    } catch (FileNotFoundException ex) {
//        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//    }
}
