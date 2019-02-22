package DemoMaven.FacebookTest;

import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookTestCases {
	
	WebDriver driver;
	@BeforeMethod
	public void SetUp () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "c:/Program Files/chromedriver.exe");
		Thread.sleep(10000);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		
	}
	@Test (priority=1)
	public void Facebook_Logo_Visible_Test() {
		WebElement signbtn = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
		System.out.println("befor mouse over button color is " + signbtn.getCssValue("background-color"));
		Actions act = new Actions(driver);
		act.moveToElement(signbtn).build().perform();
		System.out.println("after mouse over button color "	+ signbtn.getCssValue("color"));
		System.out.println();
	}
	
	@Test (priority=2)
	public void verifyPageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page Title is :" + title);
		assertEquals(title,	"Facebook – log in or sign up");
	}
	
	@Test (priority=3)
	public void verify_title () {
		String stitle = driver.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div/div/div[1]/h1/a/i")).getText();
		String expected = "Facebook";
		Assert.assertEquals(stitle, expected);
		System.out.println("verify title :"+ stitle);
		System.out.println();
	}
	
	@Test (priority=4 , groups="Regression")
	public void Username_Test() {
		String actual=driver.findElement(By.xpath("//input[@type='email']")).getAttribute("name");
		String expected="email";
		Assert.assertEquals(actual, expected);		
		System.out.println("Email verified :");
		System.out.println();
	}
	
	@Test (priority=5, groups="Regression")
	public void Password_Test() {
		String actual = driver.findElement(By.xpath("//input[@type='password']")).getAttribute("name");
		String expected= "pass";
		Assert.assertEquals(actual, expected);
		System.out.println("Password Verified :");
		System.out.println();	
	}
	
	@Test(priority=6, groups="Regression")
	public void check_LoginButton_Color_Test() {		
		WebElement signbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		System.out.println("befor mouse over button color is " + signbtn.getCssValue("background-color"));
		Actions act = new Actions(driver);
		act.moveToElement(signbtn).build().perform();
		System.out.println("after mouse over button color "	+ signbtn.getCssValue("color"));
		System.out.println();
	}
	
	@Test (priority=7 , groups="Regression")				//by tagName  "a"
		public void check_Links_Test() {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println(links.size());
			System.out.println();
			for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
	}
	
	@Test (priority=8 , groups="Regression")				//by tagName "input"
	public void check_Links() {
		List<WebElement> links = driver.findElements(By.tagName("input"));
		System.out.println(links.size());
		System.out.println();
		for (int i = 0; i < links.size(); i++) {
		System.out.println(links.get(i).getText());
		}
	}
	
	@Test (priority=9, groups="Regression")
	public void Blank_Username_Password_Test() {
		WebElement actualUsername = driver.findElement(By.xpath("//input[@type='email']"));
		actualUsername.sendKeys("");
		String expectedUsername ="swpnl";
		Assert.assertNotEquals(actualUsername, expectedUsername);
		
		WebElement actualPassword = driver.findElement(By.xpath("//input[@type='password']"));
		actualPassword.sendKeys("");
		String expectedPassword = "swpnl1234";
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertNotEquals(actualPassword, expectedPassword);	
	}
	
	@Test(priority=10, groups="Regression")
	public void Invalid_Username_Password_Test () {
		
		WebElement stringactual = driver.findElement(By.xpath("//input[@type ='email']"));
		stringactual.sendKeys("swapnil");
		String stringexpected = "swpnl";
		Assert.assertNotEquals(stringactual, stringexpected);
		stringactual.clear();
		
		WebElement passwordactual = driver.findElement(By.xpath("//input[@type ='password']"));
		passwordactual.sendKeys("swapnil08");
		String passwordexpected = "swpnl5141";
		Assert.assertNotEquals(passwordactual, passwordexpected);
		passwordactual.clear();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Please enter usename as swpnl");
		System.out.println("Please enter password swpnl5141");
		System.out.println();
	}
	
	@Test (priority=11, groups="Regression")
	public void valid_Username_Password_Logout_Test() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("swpnl");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("swpnl5141");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Online");
		System.out.println();
	}
	
	@Test (priority=12, groups="Regression")
	public void Create_New_Account_Visible_Test() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div[2]/div[1]/div[1]/span"));   //xpath taken from firefoxdriver
		Thread.sleep(5000);
		System.out.println("Create a new account')]");
		System.out.println();
	}
	
	@Test (priority=13, groups="Regression")
	public void Firstname_Test() {
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Gaurav");
		System.out.println();
	}
	
	@Test (priority=14, groups="Regression")
	public void Surname_Test() {
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mehra");
		System.out.println();
	}
	
	@Test (priority=15, groups="Regression")
	public void MobileNo_OR_Email_Test() {
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9876543210");
		System.out.println();
	}
	
	@Test (priority=16, groups="Regression")
	public void New_Passwod_Test() {
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("abcdefgh");
		System.out.println();
	}
	
	@Test (priority=17, groups="Regression")
	public void Birthday_Input_Test() {
		Select sel1 = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		sel1.selectByIndex(8);
		
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		sel2.selectByIndex(10);
		
		Select sel3 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		sel3.selectByValue("1994");
	}
	
	@Test (priority=18, groups="Regression")
	public void Click_On_GenderOption_Test() {
		driver.findElement(By.xpath("//input[@value='2']")).click();
		System.out.println();	
	}
	
	@Test (priority=19, groups="Regression")
	public void SignUp_Submit_Button_Test() {
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	}
	
	@Test (priority=20)  
	public void Create_a_Page_Test() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/pages/create/?ref_type=registration_form']")).click();	
		System.out.println();
	}
	
	@Test (priority=21)
	public void Create_a_Page_Visible_Test() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/pages/create/?ref_type=registration_form']")).click();
		Thread.sleep(2000);
		
		WebElement signbtn = driver.findElement(By.xpath("//div[@class='_203y']"));
		System.out.println("befor mouse over button color is " + signbtn.getCssValue("background-color"));
		Actions act = new Actions(driver);
		act.moveToElement(signbtn).build().perform();
		System.out.println("after mouse over button color "	+ signbtn.getCssValue("color"));
		System.out.println();		
	}
	@Test (priority=22)
	public void BusinessOrBrand_Page_Test() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/pages/create/?ref_type=registration_form']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Business or brand') and @class='_63d-']"));
		System.out.println("Business or brand logo visible");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div/div[1]/div[2]/button/div/div")).click();    //relative xpath from firepath
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
  }
