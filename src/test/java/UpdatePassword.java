import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import user.UserRole;

import static apiUtil.ApiRequests.getRequest;
import static apiUtil.ApiRequests.putRequest;
import static apiUtil.UrlUtil.*;
import static user.UserDataRegistry.getUpdatedPassword;
import static user.UserDataRegistry.getUpdatedUser;

public class UpdatePassword extends AdminTest {

    @Test
    public void updatePasswordTest() {
        loginRegisteredUser(UserRole.ADMIN);
        updatePassword();

    }

    public Response updatePassword() {
        return putRequest(UPDATE_PASSWORD_PATH, getUpdatedPassword(), 200, accessToken);
    }
}
