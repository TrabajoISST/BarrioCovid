package src.test.resources;

//Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class BarrioCovidSeleniumTest {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty( "webdriver.chrome.driver", "C:/Users/was7d/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void barrioCovid() {
		driver.get("http://localhost:8080/BarrioCovid-WEBAPP/");
		driver.manage().window().setSize(new Dimension(1552, 840));
		driver.findElement(By.cssSelector("form:nth-child(10) > button")).click();
		driver.findElement(By.cssSelector("form:nth-child(8) #email")).click();
		driver.findElement(By.cssSelector("form:nth-child(8) #email")).sendKeys("mercadona@gmail.com");
		driver.findElement(By.cssSelector("form:nth-child(8) #password")).click();
		driver.findElement(By.cssSelector("form:nth-child(8) #password")).sendKeys("abc");
		driver.findElement(By.cssSelector("form:nth-child(8) #zona")).click();
		{
			WebElement dropdown = driver.findElement(By.cssSelector("form:nth-child(8) #zona"));
			dropdown.findElement(By.xpath("//option[. = 'Centro']")).click();
		}
		driver.findElement(By.cssSelector("form:nth-child(8) #zona")).click();
		driver.findElement(By.cssSelector("form:nth-child(8) #direccion")).click();
		driver.findElement(By.cssSelector("form:nth-child(8) #direccion")).sendKeys("centro");
		driver.findElement(By.cssSelector("form:nth-child(8) > p")).click();
		driver.findElement(By.cssSelector("form:nth-child(8) button")).click();
		driver.findElement(By.cssSelector("form:nth-child(6) > button")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("mercadona@gmail.com");
		driver.findElement(By.id("contrasena")).click();
		driver.findElement(By.id("contrasena")).sendKeys("abc");
		driver.findElement(By.cssSelector("button:nth-child(3)")).click();
		driver.findElement(By.name("file")).click();
		driver.findElement(By.name("file")).sendKeys("C:\\Users\\was7d\\Documents\\Pruebas\\productosMercadona.pdf");
		driver.findElement(By.cssSelector("p:nth-child(8) > button")).click();
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.cssSelector("form:nth-child(10) > button")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("claudia@gmail.com");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("zona")).click();
		{
			WebElement dropdown = driver.findElement(By.id("zona"));
			dropdown.findElement(By.xpath("//option[. = 'Centro']")).click();
		}
		driver.findElement(By.id("zona")).click();
		driver.findElement(By.id("direccion")).click();
		driver.findElement(By.id("direccion")).sendKeys("centro");
		driver.findElement(By.cssSelector("form:nth-child(4) button")).click();
		driver.findElement(By.cssSelector("form:nth-child(4) > button")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("claudia@gmail.com");
		driver.findElement(By.id("contrasena")).click();
		driver.findElement(By.id("contrasena")).sendKeys("1234");
		driver.findElement(By.cssSelector("button:nth-child(3)")).click();
		driver.findElement(By.name("email_v")).click();
		driver.findElement(By.name("email_v")).sendKeys("mercadona@gmail.com");
		driver.findElement(By.cssSelector("p:nth-child(5)")).click();
		driver.findElement(By.cssSelector("p:nth-child(5) > button")).click();
		driver.findElement(By.name("item-vendedor")).click();
		driver.findElement(By.name("item-vendedor")).click();
		driver.findElement(By.name("file")).click();
		driver.findElement(By.name("file")).sendKeys("C:\\Users\\was7d\\Documents\\\\Pruebas\\pedido.pdf");
		driver.findElement(By.id("email_c")).click();
		driver.findElement(By.id("email_c")).sendKeys("claudia@gmail.com");
		driver.findElement(By.id("zona")).click();
		driver.findElement(By.id("zona")).sendKeys("Centro");
		driver.findElement(By.cssSelector("p:nth-child(19)")).click();
		driver.findElement(By.cssSelector("p:nth-child(19) > button")).click();
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.cssSelector("form:nth-child(6) > button")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("mercadona@gmail.com");
		driver.findElement(By.id("contrasena")).click();
		driver.findElement(By.id("contrasena")).sendKeys("abc");
		driver.findElement(By.cssSelector("button:nth-child(3)")).click();
		driver.findElement(By.name("email_c")).click();
		driver.findElement(By.name("email_c")).sendKeys("claudia@gmail.com");
		driver.findElement(By.cssSelector("p:nth-child(5)")).click();
		driver.findElement(By.cssSelector("p:nth-child(5) > button")).click();
		driver.findElement(By.cssSelector("form > button")).click();
		driver.findElement(By.cssSelector("form:nth-child(10) > button")).click();
		driver.findElement(By.cssSelector("form:nth-child(6) #email")).click();
		driver.findElement(By.cssSelector("form:nth-child(6) #email")).sendKeys("clara@gmail.com");
		driver.findElement(By.cssSelector("form:nth-child(6) #password")).click();
		driver.findElement(By.cssSelector("form:nth-child(6) #password")).sendKeys("5678");
		driver.findElement(By.cssSelector("form:nth-child(6) #zona")).click();
		{
			WebElement dropdown = driver.findElement(By.cssSelector("form:nth-child(6) #zona"));
			dropdown.findElement(By.xpath("//option[. = 'Centro']")).click();
		}
		driver.findElement(By.cssSelector("form:nth-child(6) #zona")).click();
		driver.findElement(By.cssSelector("form:nth-child(6) #direccion")).click();
		driver.findElement(By.cssSelector("form:nth-child(6) #direccion")).sendKeys("centro");
		driver.findElement(By.cssSelector("form:nth-child(6) > p")).click();
		driver.findElement(By.cssSelector("form:nth-child(6) button")).click();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("root");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("root");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.id("email_c")).click();
		driver.findElement(By.id("email_c")).sendKeys("claudia@gmail.com");
		driver.findElement(By.cssSelector("p:nth-child(10)")).click();
		driver.findElement(By.cssSelector("p > button")).click();
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.cssSelector("form:nth-child(8) > button")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("clara@gmail.com");
		driver.findElement(By.id("contrasena")).click();
		driver.findElement(By.id("contrasena")).sendKeys("5678");
		driver.findElement(By.cssSelector("button:nth-child(3)")).click();
		driver.findElement(By.cssSelector("p > button")).click();
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("root");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("root");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.cssSelector("div:nth-child(6)")).click();
		driver.findElement(By.cssSelector("div:nth-child(6)")).click();
		driver.findElement(By.cssSelector("form > button")).click();
	}
}