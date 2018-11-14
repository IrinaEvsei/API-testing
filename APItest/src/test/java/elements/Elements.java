package elements;

import org.openqa.selenium.By;

public class Elements {

    public static String URL = "https://swapi.co/api/";
    public static By ELEMENTS = By.xpath("//a[contains(., 'planets')]");
    public static By NUMBER_COUNT = By.xpath("//*[@id=\"content\"]/div/div[3]/pre/span[7]");
    public static By NEXT_BUTTON = By.xpath("//*[@id=\"content\"]/div/div[3]/pre/a[1]/span");
    public static By ELEMENT_NAME = By.xpath("//span[contains(., 'name')]");
}
