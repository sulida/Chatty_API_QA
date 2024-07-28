package userTests;

import baseTests.AdminUserTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.*;
import static apiUtil.UrlUtil.*;
import static user.UserDataRegistry.*;

public class UpdatePassword extends AdminUserTest {

    @Test
    public void updatePasswordTest() {
        updatePassword();

    }

    @Test
    public void updatePasswordBadRequestUserTest() {
        putRequest(UPDATE_PASSWORD_PATH, getUpdatedInvalidPassword(), 400, accessAdminToken);

    }

    @Test
    public void updatePasswordNoAuthorizationedUserTest() {
        putRequest(UPDATE_PASSWORD_PATH, getUpdatedPassword(), 401, "");

    }

    public Response updatePassword() {
        return putRequest(UPDATE_PASSWORD_PATH, getUpdatedPassword(), 200, accessAdminToken);
    }

    @AfterEach
    public void deleteUser() {
        deleteRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH, 204, accessAdminToken, userId);
    }

}