package com.wipro.utilities;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebElement;

public class WriteIntoFileProduct {

	public static void writeData(String prodName, String prize) {

		FileWriter fw;

		try {
			fw = new FileWriter("src\\test\\resources\\output_data\\Prize.txt");

			fw.write(prodName);
			fw.write("\t" + prize);
			fw.close();
		} catch (IOException ioe) {
			System.out.println("some issue in writing into file");
		}

		
	}
}
