package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload {
public void fileUpload() throws AWTException {
	Robot robot = new Robot();

	StringSelection filePath = new StringSelection(
			"/Users/smathew/Desktop/Obsqura/notes/Types of s:w testing.docx");

	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null); 
	
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.delay(4);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
//	To pressing and releasing enter key
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.delay(4);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	System.out.println("File uploded successfully!");
}
}
