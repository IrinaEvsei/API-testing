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
        String numberCount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/span[7]")).getText();

        WebElement nextA = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/a[1]/span"));

        List<WebElement> elementNameA = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_1: " + elementNameA.size());
        nextA.click();
//**********************************************************************************************************************************************************************
        List<WebElement> elementNameB = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_2: " + elementNameB.size());

        String elementCheckB = driver.findElement(By.xpath("//div[@class='request-info']//pre[@class='prettyprint']")).getText();
        Assert.assertTrue(elementCheckB.contains("page=2"));

        WebElement nextB = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/a[1]/span"));
        nextB.click();
//**********************************************************************************************************************************************************************
        List<WebElement> elementNameC = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_3: " + elementNameC.size());

        String elementCheckC = driver.findElement(By.xpath("//div[@class='request-info']//pre[@class='prettyprint']")).getText();
        Assert.assertTrue(elementCheckC.contains("page=3"));

        WebElement nextC = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/a[1]/span"));
        nextC.click();
//**********************************************************************************************************************************************************************
        List<WebElement> elementNameD = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_4: " + elementNameD.size());

        String elementCheckD = driver.findElement(By.xpath("//div[@class='request-info']//pre[@class='prettyprint']")).getText();
        Assert.assertTrue(elementCheckD.contains("page=4"));

        WebElement nextD = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/a[1]/span"));
        nextD.click();
//**********************************************************************************************************************************************************************
        List<WebElement> elementNameE = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_5: " + elementNameE.size());

        String elementCheckE = driver.findElement(By.xpath("//div[@class='request-info']//pre[@class='prettyprint']")).getText();
        Assert.assertTrue(elementCheckE.contains("page=5"));

        WebElement nextE = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/a[1]/span"));
        nextE.click();
//**********************************************************************************************************************************************************************
        List<WebElement> elementNameF = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_6: " + elementNameF.size());

        String elementCheckF = driver.findElement(By.xpath("//div[@class='request-info']//pre[@class='prettyprint']")).getText();
        Assert.assertTrue(elementCheckF.contains("page=6"));

        WebElement nextF = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/pre/a[1]/span"));
        nextF.click();
//**********************************************************************************************************************************************************************
        List<WebElement> elementNameG = driver.findElements(By.xpath("//span[contains(., 'name')]"));
        System.out.println("Number of elements on the page_7: " + elementNameG.size());

        String elementCheckG = driver.findElement(By.xpath("//div[@class='request-info']//pre[@class='prettyprint']")).getText();
        Assert.assertTrue(elementCheckG.contains("page=7"));
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------
        int totalCount = elementNameA.size() + elementNameB.size() + elementNameC.size() + elementNameD.size() + elementNameE.size() + elementNameF.size() + elementNameG.size();

        System.out.println("Total: " + totalCount);

        Assert.assertEquals(String.valueOf(totalCount), numberCount);
    }

    @After
    public void tearDown() {
        WebDriverSingleton.destroyInstance();
    }
}
