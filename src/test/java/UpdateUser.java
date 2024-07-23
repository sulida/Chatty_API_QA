import static apiUtil.ApiRequests.deleteRequest;
import static apiUtil.ApiRequests.getRequest;
import static apiUtil.ApiRequests.putRequest;
import static apiUtil.UrlUtil.GET_USER_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_USER_PATH;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import user.User;
import static user.UserDataRegistry.getInvalidUser;
import static user.UserDataRegistry.getUpdatedUser;

public class UpdateUser extends AdminUserTest {


    @Test
    public void updateUserTest() {
        User expectedUser = getUpdatedUser();
        putRequest(UPDATE_OR_DELETE_USER_PATH + userId, expectedUser, 200, accessToken);
        User returnedUser = getRequest(GET_USER_PATH, 200, accessToken).body().as(User.class);

        assertEquals(expectedUser.getAvatarUrl(), returnedUser.getAvatarUrl());
        assertEquals(expectedUser.getName(), returnedUser.getName());
        assertEquals(expectedUser.getSurname(), returnedUser.getSurname());
        assertEquals(userId, returnedUser.getId());
        assertEquals(expectedUser.getEmail(), returnedUser.getEmail());
        assertEquals(expectedUser.getBlocked(), returnedUser.getBlocked());
        assertEquals(expectedUser.getGender(), returnedUser.getGender());
        assertEquals(expectedUser.getPhone(), returnedUser.getPhone());
        assertEquals(expectedUser.getBackgroundUrl(), returnedUser.getBackgroundUrl());
        assertEquals(expectedUser.getBirthDate(), returnedUser.getBirthDate());

    }


    @Test
    public void updateUserNoAuthorizationTest() {
        putRequest(UPDATE_OR_DELETE_USER_PATH + userId, getUpdatedUser(), 401, null);
    }

    @Test
    public void updateUserBadRequestTest() {
        Response badRequestResponse = putRequest(UPDATE_OR_DELETE_USER_PATH + userId,
                getInvalidUser(), 400, accessAdminToken);
        String errorMessage = badRequestResponse.getBody().jsonPath().getString("message");
        assertEquals("Bad Request", errorMessage);
    }


    @AfterEach
    public void deleteUser(){
        deleteRequest(UPDATE_OR_DELETE_USER_PATH, 204,  accessAdminToken, userId);
    }

}
