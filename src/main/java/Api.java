import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.Login;
import static io.restassured.RestAssured.given;

public class Api {


    //POST https://stellarburgers.nomoreparties.site/api/auth/login авторизация пользователя
    public static final String URI = "https://stellarburgers.nomoreparties.site";

    public static final String LOGIN = "/api/auth/login";

    //DELETE https://stellarburgers.nomoreparties.site/api/auth/user удалить пользователя
   // Для получения данных о пользователе необходимо передать серверу токен в поле authorization.
    public static final String AUTH_USER = "/api/auth/user";

    @Step("Аутентификация пользователя")
    public static Response loginUser(Login login) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(login)
                .when()
                .post(URI+LOGIN);

    }

    @Step("Получить токен доступа (accessToken)")
    public static String getAccessToken(Response response) {
        return response.jsonPath().get("accessToken");
    }

    @Step("Удалить пользователя")
    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(URI+AUTH_USER);
    }

}
