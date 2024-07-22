import static apiUtil.ApiRequests.deleteRequest;
import static apiUtil.ApiRequests.getRequest;
import apiUtil.UrlUtil;
import static apiUtil.UrlUtil.GET_USER_PATH;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import user.UserRole;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUserTest() {
        setTokensAfterUserRegistration(UserRole.USER);
        setTokensAfterUserRegistration(UserRole.ADMIN);
        String userId = getUserIdAfterRequest();

        deleteRequest(UrlUtil.UPDATE_OR_DELETE_USER_PATH, 204,  accessAdminToken, userId);

        Response getUserResponse = getRequest(GET_USER_PATH, 200, accessAdminToken);
        assertEquals(404, getUserResponse.getStatusCode());


       // ne yverena chto budet takoj message/ mojet ne budet ili drugoj
        String errorMessage = getUserResponse.getBody().jsonPath().getString("message");
        assertEquals("User not found!", errorMessage);
    }


    @Test
    public void deleteUserNoAuthorizationTest() {
        setTokensAfterUserRegistration(UserRole.USER);
        setTokensAfterUserRegistration(UserRole.ADMIN);
        String userId = getUserIdAfterRequest();

        Response deleteUserResponse = deleteRequest(UrlUtil.UPDATE_OR_DELETE_USER_PATH, 401,
                null, userId);

        // ne yverena chto tak message budet mojet drugoj ili ne budet message
        String errorMessage = deleteUserResponse.getBody().jsonPath().getString("message");
        assertEquals("Unauthorized", errorMessage);
    }


    @Test
    public void deleteUserBadRequestTest(){
        setTokensAfterUserRegistration(UserRole.ADMIN);
        deleteRequest(UrlUtil.UPDATE_OR_DELETE_USER_PATH, 405, accessAdminToken, "");
    }
}
