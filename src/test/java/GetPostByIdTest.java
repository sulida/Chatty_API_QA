import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.*;
import static apiUtil.UrlUtil.CREATE_POST_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_OR_GET_USER_PATH;
import static post.PostCreate.createNewPost;

public class GetPostByIdTest extends AdminUserTest {
    protected String id;

    @Test
    public void getPostByIdTest() {
        this.id = getPostIdAfterCreateNewPost();
        getPostById();

    }

    public Response getPostById() {
        return getRequest(CREATE_POST_PATH + "/" + id, 200, accessToken);
    }

    public String getPostIdAfterCreateNewPost() {
        return postRequest(CREATE_POST_PATH, createNewPost(), 201, accessToken)
                .jsonPath()
                .getString("id");
    }

    @AfterEach
    public void deleteUser() {
        deleteRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH, 204, accessAdminToken, userId);
    }

}
