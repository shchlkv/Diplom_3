/*
Вход: Проверь
+вход по кнопке «Войти в аккаунт» на главной,
+вход через кнопку «Личный кабинет»,
+вход через кнопку в форме регистрации,
+вход через кнопку в форме восстановления пароля.
Выход из аккаунта: Проверь выход по кнопке «Выйти» в личном кабинете.
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
import pageobject.RegistrationPage;


public class LoginLogoutTest {

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

    }

    @Test
    @DisplayName("loginFromButtonSignInTest")
    @Description("Тест: логин через кнопку Войти в аккаунт")
    public void loginFromButtonSignInTest() {
        page.waitForLoadMainPage();
        page.goToLoginPageFromButtonSignIn(); //страница логина
        pageLogin.waitForLoadLoginPage();
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        pageLogin.login(email, password);
        Assert.assertEquals("Соберите бургер", page.waitForElement(MainPage.headerMakeBurger));

    }

    @Test
    @DisplayName("loginFromButtonSignInTest")
    @Description("Тест: логин через кнопку Личный кабинет ")
    public void loginFromButtonPersonalAccountTest() {  //из кнопки Личный кабинет
        page.waitForLoadMainPage();
        page.goToLoginPageFromButtonPersonalAccount(); //страница логина
        pageLogin.waitForLoadLoginPage();
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        pageLogin.login(email, password);
        Assert.assertEquals("Соберите бургер", page.waitForElement(MainPage.headerMakeBurger));

    }

    @Test
    @DisplayName("loginFromAuthorisationPageTest")
    @Description("Тест: логин со страницы регистрации ")
    public void loginFromAuthorisationPageTest() {  //со страницы регистрации
        page.waitForLoadMainPage();
        page.goToLoginPageFromButtonSignIn();
        pageLogin.waitForLoadLoginPage();
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        pageLogin.goToRegistrationPage();
        Assert.assertEquals("Регистрация", page.waitForElement(RegistrationPage.headerRegistration));
        page.selectElementAndClick(RegistrationPage.linkLoginRegistrationPage);
        pageLogin.login(email, password);
        Assert.assertEquals("Соберите бургер", page.waitForElement(MainPage.headerMakeBurger));

    }

    @Test
    @DisplayName("loginFromAuthorisationPageTest")
    @Description("Тест: логин со страницы восстановления пароля ")
    public void loginFromLinkResetPasswordTest() {  //со страницы восстановления пароля
        page.waitForLoadMainPage();
        page.goToLoginPageFromButtonSignIn();
        pageLogin.waitForLoadLoginPage();
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        // ссылка восстановить пароль
        page.selectElementAndClick(LoginPage.linkPasswordRecovery);
        Assert.assertEquals("Восстановление пароля", page.waitForElement(MainPage.headerPasswordRecovery));
        page.selectElementAndClick(MainPage.linkLoginForgotPasswordPage);
        pageLogin.login(email, password);
        Assert.assertEquals("Соберите бургер", page.waitForElement(MainPage.headerMakeBurger));

    }
    @Test
    @DisplayName("logoutTest")
    @Description("Тест: выход из аккаунта ")
    public void logoutTest() {
        /*главная страница -> кнопка Личный кабинет -> Страница Вход/ login -> ввод логина, пароля ->
        главная страница -> кнопка Личный кабинет -> страница /account/profile -> кнопка Выход -> Страница Вход/ login */
        page.waitForLoadMainPage();
        page.goToLoginPageFromButtonPersonalAccount(); //страница логина
        pageLogin.waitForLoadLoginPage();
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        pageLogin.login(email, password);
        Assert.assertEquals("Соберите бургер", page.waitForElement(MainPage.headerMakeBurger));
        page.goToLoginPageFromButtonPersonalAccount(); //страница логина
        Assert.assertEquals("Профиль", page.waitForElement(MainPage.linkProfileProfilePage));
        page.logout();
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));

    }
    @After
    public void powerOff() {
        driver.quit();
    }

}


