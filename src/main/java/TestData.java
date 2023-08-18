import org.apache.commons.lang3.RandomStringUtils;


public class TestData {
    static String name = "Василий_" + RandomStringUtils.randomNumeric(6);
    static String email = ("email" + RandomStringUtils.randomAlphanumeric(5) + "@ya.ru").toLowerCase();
    static String password = RandomStringUtils.randomAlphanumeric(6);
    static String passwordIncorrect = RandomStringUtils.randomAlphanumeric(5);

}