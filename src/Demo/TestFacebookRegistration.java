package Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestFacebookRegistration {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty(
//				"webdriver.gecko.driver",
//				"D:\\Study\\CT243\\DBCL_KTPM_Nhom2\\Install Selenium\\geckodriver-v0.32.0-win32\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Study\\CT243\\DBCL_KTPM_Nhom2\\Install Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// driver.get("http://www.facebook.com");
		driver.get("https://vi-vn.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// tim nut "Tạo tài khoản mới"
		driver.findElement(By.linkText("Tạo tài khoản mới")).click();
		driver.findElement(By.name("lastname")).sendKeys("Le");
		driver.findElement(By.name("firstname")).sendKeys("Duong");
		
//		driver.findElement(By.name("reg_email__")).sendKeys("Duong@gmail.com");
//		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(
//				"Duong@gmail.com");
//		driver.findElement(By.id("password_step_input")).sendKeys(
//				"aBc012@_--!!89");

		List<WebElement> gender = driver.findElements(By.name("sex"));
		gender.get(1).click();
		// Select day
		Select sel1 = new Select(driver.findElement(By.id("day")));
		sel1.selectByIndex(30);
		// Select month
		Select sel2 = new Select(driver.findElement(By.id("month")));
		sel2.selectByIndex(0);
		// Select year
		Select sel3 = new Select(driver.findElement(By.id("year")));
		sel3.selectByValue("2001");
		driver.findElement(By.name("websubmit")).click();
		// click on a link to go to next page
		driver.findElement(By.linkText("Tìm hiểu thêm")).click();
		// back
		driver.navigate().back();
		// quit
		driver.quit();
	}
}