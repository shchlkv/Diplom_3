/*
Переход в личный кабинет - Проверь переход по клику на «Личный кабинет».
Переход из личного кабинета в конструктор: Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.

        */


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPage;
import pageobject.MainPage;



public class SwitchPagesTest {

    WebDriver driver;
    MainPage page;
    LoginPage pageLogin;
    String email = "emailzx747708@ya.ru";
    String password = "zX3457";

    @Before
    public void setUp() {

       // SetUpDriver.setYandexDriver();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        page = new MainPage(driver);
        pageLogin = new LoginPage(driver);
        page.waitForLoadMainPage();

    }

    @Test
    @DisplayName("switchToProfileTest")
    @Description("Тест: переход в личный кабинет ")
    public void switchToProfileTest() {
        /*главная страница -> кнопка Войти в аккаунт -> Страница Вход/ login -> ввод логина, пароля ->
        главная страница -> кнопка Личный кабинет -> страница /account/profile */

        page.goToLoginPageFromButtonSignIn(); //страница логина
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        pageLogin.login(email, password);
        Assert.assertEquals("Соберите бургер", page.waitForElement(MainPage.headerMakeBurger));
        page.goToLoginPageFromButtonPersonalAccount(); //страница логина
        Assert.assertEquals("Профиль", page.waitForElement(MainPage.linkProfileProfilePage));
    }

    @Test
    @DisplayName("switchProfileToConstructorTest")
    @Description("Тест: Переход из личного кабинета в конструктор ")
    public void switchProfileToConstructorTest() {
        //главная страница -> кнопка Личный кабинет -> кнопка Конструктор -> главная страница

        page.goToLoginPageFromButtonPersonalAccount(); //страница логина
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        page.switchConstructor(); // по кнопке констуктор
        Assert.assertEquals("Соберите бургер", page.waitForElement(MainPage.headerMakeBurger));

    }

    @Test
    @DisplayName("switchProfileToLogoTest")
    @Description("Тест: Переход из личного кабинета по клику на логотип Stellar Burgers.")
    public void switchProfileToLogoTest() {
        //главная страница -> кнопка Личный кабинет -> Логотип -> главная страница

        page.goToLoginPageFromButtonPersonalAccount(); //страница логина
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        page.switchLogo(); // через логотип
        Assert.assertEquals("Соберите бургер", page.waitForElement(MainPage.headerMakeBurger));

    }

    @After
    public void powerOff() {
        driver.quit();
    }

}
