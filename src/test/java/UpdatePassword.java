import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import user.UserRole;

import static apiUtil.ApiRequests.getRequest;
import static apiUtil.ApiRequests.putRequest;
import static apiUtil.UrlUtil.*;
import static user.UserDataRegistry.*;

public class UpdatePassword extends AdminUserTest {

    @Test
    public void updatePasswordTest() {
        updatePassword();

    }

    @Test
    public void updatePasswordBadRequestUserTest() {
        putRequest(UPDATE_PASSWORD_PATH, getUpdatedInvalidPassword(), 400,accessAdminToken);

    }

    @Test
    public void updatePasswordNoAuthorizationedUserTest() {
        putRequest(UPDATE_PASSWORD_PATH, getUpdatedPassword(), 401,"");

    }

    public Response updatePassword() {
        return putRequest(UPDATE_PASSWORD_PATH, getUpdatedPassword(), 200, accessAdminToken);
    }
}
