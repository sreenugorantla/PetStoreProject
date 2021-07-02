package com.mystore.petstore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PetStoreLog {
	
	public void createFile() {
	try {
	      File myObj = new File("petstorelog.txt");
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
}
	public static void mylog(String text) {
		try {
		      FileWriter myWriter = new FileWriter("petstorelog.txt");
		      myWriter.write(java.time.LocalDateTime.now()+" "+text);
		      System.out.println("file write");
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("Error in file write");
		      e.printStackTrace();
		    }
		  
}

}
