package tju.scs.jys;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestUrl {
	public TestUrl() {
		 // TODO Auto-generated constructor stub
	}
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private Excel excel=new Excel();
	 
	@Before
	public void setUp() throws Exception {
	    String driverPath ="E:\\docs\\ST\\selenium\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		// find the position of firefox.exe in case of failure
		System.setProperty("webdriver.firefox.bin","C:\\Users\\28032\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://121.193.130.195:8800/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUrl() throws Exception {
	    driver.get(baseUrl + "/");
	    List<List<String>> res = excel.ObtainExcel("E:\\docs\\ST\\Lab2\\»Ìº˛≤‚ ‘√˚µ•.xlsx");
	    
	    //judge whether the results live up to the expectations 
	    for(int i=0;i<res.size();i++){
	    	List<String> rowinfo = res.get(i);
			driver.findElement(By.name("id")).clear();
			
			//enter the id and password
			driver.findElement(By.name("id")).sendKeys(rowinfo.get(0));
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(rowinfo.get(0).substring(4, 10));
			driver.findElement(By.id("btn_login")).click();
			
			//check the id, name, and githubURL
			assertEquals(rowinfo.get(0), driver.findElement(By.id("student-id")).getText());
			assertEquals(rowinfo.get(1), driver.findElement(By.id("student-name")).getText());
			assertEquals(rowinfo.get(2), driver.findElement(By.id("student-git")).getText());
			
			//after checking, back to the login interface
			driver.findElement(By.id("btn_logout")).click();
			driver.findElement(By.id("btn_return")).click();	
	    }
    }
}
