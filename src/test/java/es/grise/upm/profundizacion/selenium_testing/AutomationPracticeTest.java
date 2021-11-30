package es.grise.upm.profundizacion.selenium_testing;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.time.Duration;

@RunWith(JUnit4.class)
public class AutomationPracticeTest {
  
  private static final String driverPath = "D:\\Program Files\\SeleniumIDE\\chromedriver.exe";

  private WebDriver driver;
  
  @BeforeClass
  public static void propertySetup() {
    System.setProperty("webdriver.chrome.driver", driverPath);
  }

  @Before
  public void setUp() {
    driver = new ChromeDriver();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void IncorrectEmailSignIn() {
    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    driver.manage().window().setSize(new Dimension(974, 1032));
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).sendKeys("adjfblaskjdfb");
    {
      List<WebElement> elements = driver.findElements(By.id("create_account_error"));
      assert(elements.size() > 0);
    }
  }

  @Test
  public void CorrectEmailSignIn() {
    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    driver.manage().window().setSize(new Dimension(974, 1032));
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).sendKeys("jaime.fompe@gmail.com");
    driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitAccount")));
    }
    {
      List<WebElement> elements = driver.findElements(By.id("account-creation_form"));
      assert(elements.size() > 0);
    }
  }

  @Test
  public void SearchBlouseOneProduct() {
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().setSize(new Dimension(974, 1032));
    driver.findElement(By.id("search_query_top")).click();
    driver.findElement(By.id("search_query_top")).sendKeys("blouse");
    driver.findElement(By.name("submit_search")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-count")));
    }
    assertThat(driver.findElement(By.cssSelector(".product-count")).getText(), is("Showing 1 - 1 of 1 item"));
  }

  @Test
  public void SearchCarNoProducts() {
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().setSize(new Dimension(974, 1032));
    driver.findElement(By.id("search_query_top")).click();
    driver.findElement(By.id("search_query_top")).sendKeys("car");
    driver.findElement(By.name("submit_search")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".heading-counter")));
    }
    assertThat(driver.findElement(By.cssSelector(".heading-counter")).getText(), is("0 results have been found."));
  }

  @Test
  public void BeigeWomanClothesOneProduct() {
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().setSize(new Dimension(978, 816));
    driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")).click();
    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[4]/div/div[1]/div")).click();
    assertThat(driver.findElement(By.cssSelector(".editable:nth-child(2)")).getText(), is("demo_4"));
  }
}
