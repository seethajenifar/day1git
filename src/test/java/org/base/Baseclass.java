package org.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Baseclass {
public static WebDriver driver;
public static WebDriver browserLaunch() {
	
WebDriverManager.chromedriver().setup();
driver =new ChromeDriver();
return driver;
}
public static WebDriver browserLaunch(String bname) {
if(bname.equalsIgnoreCase("chrome")) {
WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
}
else if(bname.equalsIgnoreCase("Edge")) {	
WebDriverManager.edgedriver().setup();	
	driver = new EdgeDriver();
}
//else if(bname.equalsIgnoreCase("opera")) {	
//	WebDriverManager.operadriver().setup();
//driver = new OperaDriver();
//}
return driver;	
}
public static WebDriver browserLaunch2(String bname) {	
	switch(bname) {
//	case "opera":
//	WebDriverManager.operadriver().setup();
//	driver = new OperaDriver();
//	break;
	case"edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
	case"chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		default:
System.out.println("Invalid browse name");
	}
return driver;
}
public static void urlLaunch(String url) {
driver.get(url);
driver.manage().window().maximize();
}
public static void implicitlywait(int a) {
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
}
public static void scroll(String script,WebElement e) {
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)");
	js.executeScript("arguments[0].scrollIntoView(false)");
}
public static Object getAttributes(WebElement a) {
	JavascriptExecutor js =(JavascriptExecutor)driver;
	Object script = js.executeScript("return argument[0].getAttribute('value')",a);
return script;
}
public static void sendkeys(WebElement e, String value) {
e.sendKeys(value);
}
public static WebDriver getDriver() {
	return driver;
}
public static void click (WebElement e) {
e.click();
}
public static String getcurrenturl() {
	String currentUrl=driver.getCurrentUrl();
	return getcurrenturl();
}
	public static void windowsHandling(String windowsId) {
driver.switchTo().window(windowsId);
	}
public static String gettitle() {
	String title = driver.getTitle();
			return title;
}
public static void quit() {
driver.quit();}
public static void clear(WebElement e) {
e.clear();
}

public static String getText(WebElement e) {
String text = e.getText();
return text;
}
public static String getAttribute(WebElement e) {
	String attribute = e.getAttribute("value");
return attribute;
}
public static void movetoElement(WebElement e) {
Actions a = new Actions(driver);
a.moveToElement(e).perform();
}
public static void DragAndDrop(WebElement src,WebElement dest) {
	Actions a = new Actions(driver);
a.dragAndDrop(src, dest).perform();
}
public static void SelectByIndex(WebElement e,int index) {
Select s = new Select(e);
s.selectByIndex(index);
}
public static void moveToElement(WebElement e) {
	Actions a = new Actions(driver);
a.moveToElement(e).perform();
}
public static WebElement findElement(String loc,String value){
	WebElement t = null;
	if(loc.equals("id")) {		
t = driver.findElement(By.id("value"));
}
	else if (loc.equals("name")) {
t = driver.findElement(By.name("value"));
	}
	else if(loc.equals("xpath")) {
t = driver.findElement(By.xpath("value"));
	}
return t;
}
public static void imlicitlyWait(int i) {
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
}
public static void sendKeys(WebElement i,String value) {
i.sendKeys(value);
}
public static void Click(WebElement i) {
i.click();
}
public static void main(String[]args) {
String s = ("");
String replace =s.replace("seetha","%");
}
public static String excelRead(String filename,String sheetname,int row,int Cell)throws IOException{
File f = new File("C:\\Users\\GOWRI\\eclipse-workspace\\MVN\\src\\"+filename+".xlsx");
FileInputStream fi = new FileInputStream(f);
Workbook w = new XSSFWorkbook(fi);
Sheet s = w.getSheet(sheetname);
Row r = s.getRow(row);
Cell c = r.getCell(Cell);
int type = c.getCellType();
String value = null;
if(type ==1) {
value = c.getStringCellValue();
}
else {
if(DateUtil.isCellDateFormatted(c)) {
Date d = c.getDateCellValue();
SimpleDateFormat st = new SimpleDateFormat("dd-mm-yyyy");
value = st.format(d);
}
else {
double num = c.getNumericCellValue();
long l = (long)num;
value = String.valueOf(l);
}}
return value;
}}