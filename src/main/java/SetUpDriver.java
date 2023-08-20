

public class SetUpDriver {

    public static void setYandexDriver() {
        String path = "src/main/resources/yandexdriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

    }

}
