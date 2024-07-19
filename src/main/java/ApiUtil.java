import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtil {

    private ApiUtil(){}

    public static Response postRequest(String url, Object body, int statusCode) {
        return given()
                .when()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .post(url)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();

    }

    public static Response postRequestWithAccessToken(String url, Object body, int statusCode, String accessToken){
        return given()
                .when()
                .log().all()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(body)
                .post(url)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public static Response getRequest(String url, int statusCode, String accessToken) {
        return given()
                .when()
                .log().all()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .get(url)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();

    }

    public static Response putRequest(String url,Object updatedBody, int statusCode, String accessToken){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(updatedBody)
                .when()
                .put(url)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();

    }
}
