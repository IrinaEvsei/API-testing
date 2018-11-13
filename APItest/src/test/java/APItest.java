import java.util.List;
import java.util.concurrent.TimeUnit;

import driver.WebDriverSingleton;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class APItest {
    private static WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        baseUrl = "https://swapi.co/api/";
    }

    @Test
    public void apiTesting() {
            driver.get(baseUrl);
            driver.navigate().to(baseUrl+"?format=json");
            WebElement element = driver.findElement(By.xpath("//pre"));
            JSONObject jsonObject = new JSONObject(element.getText());
            String valueToCheck = jsonObject.toString();
            Assert.assertTrue(valueToCheck.contains("planets"));
    }

    @Test
    public void planetsTest() {
        driver.get(baseUrl);
        WebElement elm = driver.findElement(By.xpath("//a[contains(., 'planets')]"));
        elm.click();
        driver.navigate().to(baseUrl+"?format=json");
        WebElement elem = driver.findElement(By.xpath("//pre[contains(., '/planets/')]"));
        JSONObject jsonObject = new JSONObject(elem.getText());
        String valueToCheck = jsonObject.toString();
        Assert.assertTrue(valueToCheck.contains("planets"));
    }

    @Test
    public void countTest() {
        driver.get(baseUrl);
        WebElement elm = driver.findElement(By.xpath("//a[contains(., 'planets')]"));
        elm.click();
        WebElement tagCount = driver.findElement(By.xpath("//span[@class='str' and contains(., 'count')]"));
        WebElement numberCount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/span[7]"));
        WebElement tagName = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/span[30]")); // //span[contains(., 'name')]


        WebElement next = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/a[1]/span"));

        List<WebElement> elementNameA = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_1: " + elementNameA.size());
        next.click();

        List<WebElement> elementNameB = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_2: " + elementNameB.size());

        String elementCheck = driver.findElement(By.xpath("//div[@class='request-info']//pre[@class='prettyprint']")).getText();
        Assert.assertTrue(elementCheck.contains("page=2"));

        System.out.println("Total: " + (elementNameA.size() + elementNameB.size()));
    }

//    @After
//    public void tearDown() {
//        WebDriverSingleton.destroyInstance();
//    }
}
