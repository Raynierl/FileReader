package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {
	public static void main(String[] args) {
		  String filePath = "D:\\~Coding\\Eclipse\\FileReader\\RandomUserInfo.txt";
		  String filteredFilePath = "D:\\~Coding\\Eclipse\\FileReader\\FilteredData.txt";
		  Scanner scanner = new Scanner(System.in);
		  try { // Just in case we do not find the file;
			  File file = new File(filePath);
//			  BufferedReader reader = new BufferedReader(new FileReader(file));
			  Scanner sc = new Scanner(file);
			  String value;
			  ArrayList<FileValue> farrlis = new ArrayList<>();
			  ArrayList<FileValue> filtered = new ArrayList<>();
			  while (sc.hasNextLine()) {
	             // Process the character data
	             String line =  String.join("",sc.nextLine());
//	             System.out.println(line);
	             String[] larr = line.split("\\|");
	             String[] valueArray = new String[4];;
	              for (int i =0; i<larr.length;i++) {
	            	  valueArray[i] = larr[i];
//	            	  System.out.println(larr[i]);
	            	  
	              }
	               farrlis.add(new FileValue(valueArray[0],valueArray[1],valueArray[2],valueArray[3]));
	            }

			 System.out.print("Enter Filter Type::\n0:Name\n1:Age\n2:Color\n3:City\n4:Over 18\n5:Age Range\n");
			 String type = scanner.nextLine();

			 int from,to;
			 if(type.equals("5")) {
				 System.out.println("Age Range ");
				 System.out.print("from ");
				 from = scanner.nextInt();
				 System.out.print("to ");
				 to = scanner.nextInt();
				 for(FileValue fv : farrlis) {
					 if(ageRange(from,to,fv)) filtered.add(fv);
				 }
			 }
			 else if(type.equals("4"))  {
				 for(FileValue fv : farrlis) {
					 if(filter(fv)) filtered.add(fv);
				 }
			 }
			 else {
			 System.out.print("Enter Value:: ");
			 value = scanner.nextLine();
			 for(FileValue fv : farrlis) {
				 if(filter(value,type,fv)) filtered.add(fv);
			 }
			 }
			 System.out.println(filtered);
			 scanner.close();

		  try{
			  BufferedWriter writer = new BufferedWriter(new FileWriter(filteredFilePath));
			  for(FileValue fv : filtered)
			  writer.write(fv.toString()+"\n");
			  writer.close();
					  
		  }
		  catch(IOException e) {
			  e.printStackTrace();
			  }
		  
	}
		  catch(IOException e) {
			  e.printStackTrace();
			  }
	}
	
	public static  boolean filter(String value, String type, FileValue fv) {
		switch(type) {
			case "0":
				return value.equals(fv.getName());	
			case "1":
				return Integer.parseInt(value) == fv.getAge();
			case "2":
				return value.equals(fv.getColor());		
			case "3":
				return value.equals(fv.getCity());
			case "4":
				return fv.getAge() >= 18;
				default:
					return false;
		}
	}
	public static  boolean filter(FileValue fv) {
				return fv.getAge() >= 18;
		}
	
	public static boolean ageRange(int from, int to, FileValue fv) {
		int v =  fv.getAge();
		return v>= from && v<=to;
		
	}

}
