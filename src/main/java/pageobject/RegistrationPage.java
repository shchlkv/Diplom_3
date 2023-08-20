package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public static By headerRegistration = By.xpath("//h2[text()='Регистрация']");
    public static By fieldRegistrationName = By.xpath("//input[@name='name']");
    public static By fieldRegistrationEmail = By.xpath("(//input[@name='name'])[2]");
    public static By fieldRegistrationPassword = By.xpath("//input[@type='password']");
    public static By buttonRegister = By.xpath("//button[text()='Зарегистрироваться']");
    public static By textIncorrectPassword = By.xpath("//p[text()='Некорректный пароль']");
    public static By linkLoginRegistrationPage = By.linkText("Войти"); //ссылка Войти
    public static By textSuchUserAlreadyExists = By.xpath("//p[text()='Такой пользователь уже существует']");

    public void waitForLoadRegistrationPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10).toSeconds())
                .until(ExpectedConditions.visibilityOfElementLocated(headerRegistration));
    }
    public void registration(String name, String email,String password) {
        MainPage.fillField(fieldRegistrationName, name);
        MainPage.fillField(fieldRegistrationEmail, email);
        MainPage.fillField(fieldRegistrationPassword, password);
        MainPage.selectElementAndClick(buttonRegister); // жмем кнопку регистрации

    }

}
