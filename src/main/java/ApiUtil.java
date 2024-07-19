import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtil {

    private ApiUtil() {
    }

    public static Response postRequest(String endpoint, Object body, int statusCode) {
        return given()
                .spec(UrlUtil.specification)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();

    }

    public static Response postRequestWithAccessToken(String endpoint, Object body, int statusCode, String accessToken) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public static Response getRequest(String endpoint, int statusCode, String accessToken) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();

    }

    public static Response putRequest(String endpoint, Object updatedBody, int statusCode, String accessToken) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .body(updatedBody)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();

    }

    public static Response deleteRequest(String endpoint, int statusCode, String accessToken, String idUser) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete(endpoint + idUser)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();

    }
}