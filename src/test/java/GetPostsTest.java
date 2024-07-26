import apiUtil.ApiRequests;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.getRequestPosts;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_OR_GET_USER_PATH;

public class GetPostsTest extends AdminUserTest{

    @Test
    public void getPostsTest() {
        getPosts();

    }

    private void getPosts() {
        getRequestPosts(UPDATE_OR_DELETE_OR_GET_USER_PATH, 200, userId, accessToken);
    }
}
