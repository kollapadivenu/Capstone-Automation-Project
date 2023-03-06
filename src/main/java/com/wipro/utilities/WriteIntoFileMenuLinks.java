package com.wipro.utilities;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebElement;

public class WriteIntoFileMenuLinks {

	public static void writeData(String count,WebElement menuLink) {

		FileWriter fw;

		try {
			fw = new FileWriter("src\\test\\resources\\output_data\\Menu.txt");

			fw.write(count);
			fw.write("\t" + menuLink);
			fw.close();
		} catch (IOException ioe) {
			System.out.println("some issue in writing into file");
		}

		
	}
}
