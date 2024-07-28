package postTests;

import baseTests.AdminUserTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.deleteRequest;
import static apiUtil.ApiRequests.postRequest;
import static apiUtil.UrlUtil.CREATE_POST_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_OR_GET_USER_PATH;
import static post.PostData.createNewPost;
import static post.PostData.createNewPostWithInvalidData;

public class CreatePostTest extends AdminUserTest {

    public void createNewPostWithValidDataTest() {
        createPostByUserWithValidData();
    }

    @Test
    public void createNewPostWithInvalidDataTest() {
        postRequest(CREATE_POST_PATH, createNewPostWithInvalidData(), 400, accessToken);
    }

    @Test
    public void createNewPostWithNoAtuthorisationTest() {
        postRequest(CREATE_POST_PATH, createNewPostWithInvalidData(), 401, "");
    }


    public Response createPostByUserWithValidData() {
        return postRequest(CREATE_POST_PATH, createNewPost(), 201, accessToken);
    }

    @AfterEach
    public void deleteUser() {
        deleteRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH, 204, accessAdminToken, userId);
    }

}

