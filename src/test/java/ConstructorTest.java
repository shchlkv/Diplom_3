//Раздел «Конструктор»: Проверь, что работают переходы к разделам: «Булки», «Соусы», «Начинки».

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

public class ConstructorTest {

    WebDriver driver;
    MainPage page;

    @Before
    public void setUp() {

        // SetUpDriver.setYandexDriver();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        page = new MainPage(driver);

    }

    @Test
    @DisplayName("switchBunTest")
    @Description("Тест: переключение на меню \"Булки\"")
    public void switchBunTest() {
        MainPage.selectElementAndClick(MainPage.selectFillings);
        MainPage.selectElementAndClick(MainPage.selectBuns);
        Assert.assertTrue( driver.findElement(MainPage.menuBuns).isDisplayed());


    }

    @Test
    @DisplayName("switchFillingsTest")
    @Description("Тест: переключение на меню \"Начинки\"")
    public void switchFillingsTest() {
        MainPage.selectElementAndClick(MainPage.selectFillings);
        Assert.assertTrue(driver.findElement(MainPage.menuFillings).isDisplayed());
    }



    @Test
    @DisplayName("switchSouseTest")
    @Description("Тест: переключение на элемент \"Соусы\"")
    public void switchSouseTest() {
        MainPage.selectElementAndClick(MainPage.selectSauces);
        Assert.assertTrue(driver.findElement(MainPage.menuSauces).isDisplayed());
    }

    @After
    public void powerOff() {
        driver.quit();
    }

}
