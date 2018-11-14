package page;

import driver.WebDriverSingleton;
import elements.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlanetPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void getPlanetPage() {
        driver.get(Elements.URL);
    }

    public void navigateToPlanets(){ driver.findElement(Elements.ELEMENTS).click();}

    public void checkNumberCount(){driver.findElement(Elements.NUMBER_COUNT).getText();}

    public void clickToNextPage(){driver.findElement(Elements.NEXT_BUTTON).click();}

    public By countNameTag(){driver.findElements(Elements.ELEMENT_NAME);
        return Elements.ELEMENT_NAME;
    }
}
