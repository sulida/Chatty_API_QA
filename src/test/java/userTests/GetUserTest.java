package userTests;

import baseTests.AdminUserTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.deleteRequest;
import static apiUtil.ApiRequests.getRequest;
import static apiUtil.UrlUtil.GET_USER_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_OR_GET_USER_PATH;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetUserTest extends AdminUserTest {

    @Test
    public void getUserTest() {
        Response response = getUser();
        String userId = response.jsonPath().getString("id");
        assertNotNull(userId);
    }

    @Test
    public void getUserWithNoAuthorisationTest() {
        getRequest(GET_USER_PATH, 401, "");
    }


    public Response getUser() {
        return getRequest(GET_USER_PATH, 200, accessToken);
    }

    @AfterEach
    public void deleteUser() {
        deleteRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH, 204, accessAdminToken, userId);
    }

}
