package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotClass {

	public void takeScreenshot(WebDriver driver, String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;   // TakesScreenshot is the interface to take screenshot
		File screenshot = ts.getScreenshotAs(OutputType.FILE);   // converted into FILE

		String dest = System.getProperty("user.dir") + "//Test_Evidence"; // create a folder inside the project names
																			// 'TestEvidence   -- user.dir --> taking path from user directory
		File f1 = new File(dest);
		if (!f1.exists()) { // checking if folder is already created
			f1.mkdirs(); // to create file folder,, executed only 1st time
		}

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); // when importing the package
																							// for Date() select
																							// util.Date.

		String destinationPath = System.getProperty("user.dir") + "//Test_Evidence//" + name + timeStamp + ".png";  // name will be the testCase name, to store the path of screenshot with xtension
		File finalDestination = new File(destinationPath);   // converted into a File
		FileHandler.copy(screenshot, finalDestination);   // FileHandler is a class, using copy() method screenshot is stored.
	}

}
