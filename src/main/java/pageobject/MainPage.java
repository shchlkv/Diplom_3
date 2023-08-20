package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private static  WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // ГЛАВНАЯ СТРАНИЦА https://stellarburgers.nomoreparties.site/
    public static By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");
    public static By constructor = By.xpath("//p[text()='Конструктор']"); //кнопка Конструктор


    public static By headerMakeBurger = By.xpath("//h1[text()='Соберите бургер']");

    public static By selectBuns = By.xpath("//span[text()=\"Булки\"]");
    public static  By selectSauces = By.xpath("//span[text()=\"Соусы\"]");
    public static By selectFillings =  By.xpath("//span[text()=\"Начинки\"]");

    public static By menuBuns = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span[text()='Булки']");
    public static By menuSauces = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span[text()='Соусы']");
    public static By menuFillings = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span[text()='Начинки']");
    public static By buttonSignIn = By.xpath("//button[text()='Войти в аккаунт']");
    public static By buttonPersonalAccount = By.xpath("//a[@href='/account']"); //кнопка Личный кабинет



    // страница восстановления пароля https://stellarburgers.nomoreparties.site/forgot-password

    public static By linkLoginForgotPasswordPage = By.linkText("Войти"); //ссылка Войти

    public static By headerPasswordRecovery = By.xpath("//h2[text()='Восстановление пароля']");

    // Личный кабинет https://stellarburgers.nomoreparties.site/account/profile

    private final By buttonLogoutProfilePage = By.xpath("//button[text()='Выход']"); // кнопка Выход
    public static By linkProfileProfilePage = By.linkText("Профиль"); //ссылка Войти


//ожидание загрузки главной страницы
public void waitForLoadMainPage(){
    new WebDriverWait(driver, Duration.ofSeconds(10).toSeconds())
            .until(ExpectedConditions.visibilityOfElementLocated(headerMakeBurger));
}

    // Выбор элемента на странице и нажатие
    public static void selectElementAndClick(By selectElement) {
        driver.findElement(selectElement).click();
    }


    // Ожидание отображения элемента страницы
    public String waitForElement(By selectElement) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(selectElement));
        return driver.findElement(selectElement).getText();
    }

    // Заполнение поля
    public static void fillField(By selectElement, String field) {
        driver.findElement(selectElement).sendKeys(field);
    }

    public void goToLoginPageFromButtonSignIn() {
        //ожидание видимости элемента кнопки "Войти в аккаунт" на главной странице
        waitForElement(buttonSignIn);
        //жмем на кнопку "Войти в аккаунт" на главной странице
        selectElementAndClick(buttonSignIn);
        //ожидание загрузки страницы "Вход" с надписью Зарегистироваться (внизу)
        waitForElement(LoginPage.headerLogin); // страница Вход,
    }

    public void goToLoginPageFromButtonPersonalAccount() {
        //ожидание видимости элемента кнопки "Войти в аккаунт" на главной странице
        waitForElement(buttonPersonalAccount);
        //жмем на кнопку "Войти в аккаунт" на главной странице
        selectElementAndClick(buttonPersonalAccount);

    }

    public void logout() {
        selectElementAndClick(buttonLogoutProfilePage);
    }
    public void switchLogo() {
        selectElementAndClick(logo);
    }
    public void switchConstructor() {
        selectElementAndClick(constructor);
    }


}




