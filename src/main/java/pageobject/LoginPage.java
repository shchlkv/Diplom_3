package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static By headerLogin = By.xpath("//h2[text()='Вход']");
    private final By fieldLoginEmail = By.xpath("//input[@type='text']");
    public static By fieldLoginPassword = By.xpath("//input[@type='password']");
    public static By buttonLogin = By.xpath("//button[text()='Войти']"); //кнопка Войти
    public static By linkRegister = By.xpath("//a[@class='Auth_link__1fOlj']"); //кнопка Зарегистрироваться
    public static By linkPasswordRecovery = By.linkText("Восстановить пароль"); // ссылка восстановления пароля

    public void waitForLoadLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10).toSeconds())
                .until(ExpectedConditions.visibilityOfElementLocated(headerLogin));
    }
    public void login(String email,String password) {
        MainPage.fillField(fieldLoginEmail, email);
        MainPage.fillField(fieldLoginPassword, password);
        MainPage.selectElementAndClick(buttonLogin); // жмем кнопку Войти
    }

    public void goToRegistrationPage() {
                    driver.findElement(linkRegister).click();

    }
}
