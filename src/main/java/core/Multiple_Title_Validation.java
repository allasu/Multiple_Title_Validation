package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Multiple_Title_Validation {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("No arguments!");
			System.exit(1);
		}
		
		WebDriver dr = new HtmlUnitDriver();
		
		for (int i = 0; i < args.length; i++) {
			String tc_id = "TC-001.0" + (i + 1);
			String param[] = args[i].split("\\|");
			String url =  param[0];
			String expected_title = param[1];
			
			dr.get(url);
			dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String actual_title = dr.getTitle();
			System.out.println("");
			
			System.out.println("File name:\t\t\"Multiple_Title_Validation.java\"");
			System.out.println("Test CaseID: \t\t" + tc_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Expected Title: \t" + expected_title);
			System.out.println("Actual Title: \t\t" + actual_title);
			
			if (expected_title.equals(actual_title)) {
				System.out.println("Test Case Result: \t" + "PASSED");
			}else {
				System.out.println("Test Case Result: \t" + "FAILED");
			}
				
		}
		dr.quit();
	}
}
