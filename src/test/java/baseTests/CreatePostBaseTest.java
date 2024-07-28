package baseTests;

import baseTests.AdminUserTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static apiUtil.ApiRequests.deleteRequest;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_OR_GET_USER_PATH;

public class CreatePostBaseTest extends AdminUserTest {
    protected String id;

    @BeforeEach
    public void createNewPostWithValidDataTest() {
        this.id = getPostIdAfterCreateNewPost();

    }

    @AfterEach
    public void deleteUser() {
        deleteRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH, 204, accessAdminToken, userId);
    }

}
