/*
Регистрация
Проверь:
Успешную регистрацию.
Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
 с главной страницы:
+ ожидание кнопки Войти в аккаунт
 нажать кнопку Войти в аккаунт
  нажать Зарегистрироваться
   на стр.Регистрации ожидаем текст Регистрация
  вводим в поля имя, почту, пароль (5 символов и 6 символов)
  нажать кнопку Зарегистрироваться
*/

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import pojo.Login;
import static org.hamcrest.Matchers.*;

public class RegistrationTest {

    WebDriver driver;
    MainPage page;
    RegistrationPage pageReg;
    LoginPage pageLogin;
    String name = TestData.name;
    String email = TestData.email;
    String password = TestData.password;
    String passwordIncorrect = TestData.passwordIncorrect ;
    Login loginData;
    Response response;

    @Before
    public void setUp() {

        SetUpDriver.setYandexDriver();

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        page = new MainPage(driver);
        pageLogin = new LoginPage(driver);
        pageReg = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("registrationTest")
    @Description("Тест: регистрация с паролем 6 символов")
    public void registrationTest() {
        page.waitForLoadMainPage();
        page.goToLoginPageFromButtonSignIn();
        pageLogin.waitForLoadLoginPage();
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        Assert.assertEquals("Зарегистрироваться", page.waitForElement(LoginPage.linkRegister));
        pageLogin.goToRegistrationPage();
        pageReg.waitForLoadRegistrationPage();
        Assert.assertEquals("Регистрация", page.waitForElement(RegistrationPage.headerRegistration));
        pageReg.registration(name,email, password);
        page.waitForElement(LoginPage.headerLogin); // перешли на страницу Вход,
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
       }

    @Test
    @DisplayName("registrationWithNotCorrectPasswordTest")
    @Description("Тест: регистрация с паролем 5 символов")
    public void registrationWithNotCorrectPasswordTest() {
        page.waitForLoadMainPage();
        page.goToLoginPageFromButtonSignIn();
        pageLogin.waitForLoadLoginPage();
        Assert.assertEquals("Вход", page.waitForElement(LoginPage.headerLogin));
        pageLogin.goToRegistrationPage();
        Assert.assertEquals("Регистрация", page.waitForElement(RegistrationPage.headerRegistration));
        pageReg.registration(name,passwordIncorrect+email, passwordIncorrect);
        page.waitForElement(RegistrationPage.textIncorrectPassword); //остались на странице регистрации.
        Assert.assertEquals("Некорректный пароль", page.waitForElement(RegistrationPage.textIncorrectPassword));
    }


    @After
    public void powerOff() {

        driver.quit();
        loginData = new Login(email, password);
        response = Api.loginUser(loginData);
        String accessToken = Api.getAccessToken(response);
        if (accessToken != null) {
            Response responseDelData = Api.deleteUser(accessToken);
            responseDelData.then()
                    .assertThat()
                    .statusCode(202)
                    .body("success", is(true))
                    .body("message", equalTo("User successfully removed"));

        }

    }

}
