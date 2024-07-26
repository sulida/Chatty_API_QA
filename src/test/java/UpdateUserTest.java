import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import user.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static user.UserDataRegistry.getInvalidUser;
import static user.UserDataRegistry.getUpdatedUser;
import static apiUtil.ApiRequests.deleteRequest;
import static apiUtil.ApiRequests.getRequest;
import static apiUtil.ApiRequests.putRequest;
import static apiUtil.UrlUtil.GET_USER_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_OR_GET_USER_PATH;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateUserTest extends AdminUserTest {

    @Test
    public void updateUserTest() {
        User expectedUser = getUpdatedUser(authRegisteredUser.getEmail());
        putRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH + userId, expectedUser, 200, accessToken);
        User returnedUser = getRequest(GET_USER_PATH, 200, accessToken).body().as(User.class);

        assertEquals(expectedUser.getAvatarUrl(), returnedUser.getAvatarUrl());
        assertEquals(expectedUser.getName(), returnedUser.getName());
        assertEquals(expectedUser.getSurname(), returnedUser.getSurname());
        assertEquals(userId, returnedUser.getId());
        assertEquals(expectedUser.getGender(), returnedUser.getGender());
        assertEquals(expectedUser.getPhone(), returnedUser.getPhone());
        assertTrue(returnedUser.getBirthDate().contains(expectedUser.getBirthDate().substring(0, 10)));
        assertFalse(returnedUser.getEmail().isEmpty());
        assertFalse(returnedUser.getRole().isEmpty());
        assertFalse(returnedUser.getBlocked());
        assertNull(returnedUser.getBackgroundUrl());
    }


    @Test
    public void updateUserNoAuthorizationTest() {
        putRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH + userId, getUpdatedUser(authRegisteredUser.getEmail()),
                401, null);
    }

    @Test
    public void updateUserBadRequestTest() {
        putRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH + userId, getInvalidUser(), 400, accessAdminToken);
    }


    @AfterEach
    public void deleteUser() {
        deleteRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH, 204, accessAdminToken, userId);
    }

}


//    @Test
//    public void updateUserTest() {
//        updateUser();
//        Response getUserResponse = getRequest(GET_USER_PATH, 200, accessToken);
//        User updatedUser = getUpdatedUser();
//        assertEquals(updatedUser.getAvatarUrl(), getUserResponse.jsonPath().getString("avatarUrl"));
//        assertEquals(updatedUser.getName(), getUserResponse.jsonPath().getString("name"));
//        assertEquals(updatedUser.getSurname(), getUserResponse.jsonPath().getString("surname"));
//        assertThat(getUserResponse.jsonPath().getString("birthDate"), containsString("2000-07-18"));
////        assertEquals(updatedUser.getBirthDate(), getUserResponse.jsonPath().getString("birthDate"));
////        assertThat(getUserResponse.jsonPath().getString("birthDate"), containsString(updatedUser.getBirthDate()));
//        assertEquals(updatedUser.getPhone(), getUserResponse.jsonPath().getString("phone"));
//        assertEquals(updatedUser.getGender(), getUserResponse.jsonPath().getString("gender"));
//        assertEquals(updatedUser.getBackgroundUrl(), getUserResponse.jsonPath().getString("backgroundUrl"));
//        assertEquals(updatedUser.getBlocked(), getUserResponse.jsonPath().getBoolean("blocked"));
//        assertEquals(authUser.getEmail(), getUserResponse.jsonPath().getString("email"));
//        assertEquals(userId, getUserResponse.jsonPath().getString("id"));
//
//    }
//
//    @Test
//    public void updateUserNoAuthorizationTest() {
//        Response updateUserResponse = putRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH + userId,
//                getUpdatedUser(), 401, null);
//
//    }
//
//    @Test
//    public void updateUserBadRequestTest() {
//        Response badRequestResponse = putRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH + userId,
//                getInvalidUser(), 400, accessAdminToken);
//
//    }
//
//    public Response updateUser() {
//        return putRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH + userId, getUpdatedUser(), 200, accessToken);
//    }
//


