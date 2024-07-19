import object.UserRole;
import org.junit.jupiter.api.Test;

public class DeleteUserTest extends BaseTest {
    @Test
    public void deleteUserTest() {

        setTokensAfterUserRegistration(UserRole.USER);
        setUserIdAfterGetUser();
        setTokensAfterUserRegistration(UserRole.ADMIN);
        ApiUtil.deleteRequest(UrlUtil.UPDATE_OR_EDELETE_USER_PATH, 204, idUser, accessToken );



    }


}
