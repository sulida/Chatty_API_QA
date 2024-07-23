import static apiUtil.ApiRequests.getRequest;
import static apiUtil.ApiRequests.putRequest;
import static apiUtil.UrlUtil.GET_USER_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_USER_PATH;
import org.junit.jupiter.api.Test;
import user.User;
import static user.UserDataRegistry.getUpdatedUser;

public class UpdateUser extends AdminUserTest {


    //example update user test
    @Test
    public void updateUserTest() {
        User expectedUser = getUpdatedUser();
        putRequest(UPDATE_OR_DELETE_USER_PATH + userId, expectedUser, 200, accessToken);
        User returnedActualUser = getRequest(GET_USER_PATH, 200, accessToken).body().as(User.class);

//
//        assertEquals(updatedUser.getAvatarUrl(), getUserResponse.jsonPath().getString("avatarUrl"));
//        assertEquals(updatedUser.getName(), getUserResponse.jsonPath().getString("name"));
//        assertEquals(updatedUser.getSurname(), getUserResponse.jsonPath().getString("surname"));
//        assertThat(getUserResponse.jsonPath().getString("birthDate"), containsString(updatedUser.getBirthDate()));
//        assertEquals(updatedUser.getPhone(), getUserResponse.jsonPath().getString("phone"));
//        assertEquals(updatedUser.getGender(), getUserResponse.jsonPath().getString("gender"));
//        assertEquals(updatedUser.getBackgroundUrl(), getUserResponse.jsonPath().getString("backgroundUrl"));
//        assertEquals(updatedUser.getBlocked(), getUserResponse.jsonPath().getBoolean("blocked"));
//        assertEquals(authUser.getEmail(), getUserResponse.jsonPath().getString("email"));
//        assertEquals(userId, getUserResponse.jsonPath().getString("id"));

    }


//    @Test
//    public void updateUserNoAuthorizationTest() {putRequest(UPDATE_OR_DELETE_USER_PATH + userId,
//                getUpdatedUser(), 401, null);
//
//    }
//
//    @Test
//    public void updateUserBadRequestTest() {
////        this.invalidDataUser = new User(null, null, null, null, null, null, null, false);
//        Response badRequestResponse = putRequest(UPDATE_OR_DELETE_USER_PATH + userId,
//                getInvalidUser(), 400, accessAdminToken);
////        String errorMessage = badRequestResponse.getBody().jsonPath().getString("message");
////        assertEquals("Bad Request", errorMessage);
//    }

}
