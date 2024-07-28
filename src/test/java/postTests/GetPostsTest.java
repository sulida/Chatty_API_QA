package postTests;

import baseTests.AdminUserTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.*;
import static apiUtil.UrlUtil.CREATE_POST_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_OR_GET_USER_PATH;
import static post.PostData.createNewPost;

public class GetPostsTest extends AdminUserTest {

    @Test
    public void getPostsTest() {
        postRequest(CREATE_POST_PATH, createNewPost(), 201, accessToken);
        getPosts();

    }

    @Test
    public void getPostsWithMissingDataTest() {
        postRequest(CREATE_POST_PATH, createNewPost(), 201, accessToken);
        getRequestPosts(UPDATE_OR_DELETE_OR_GET_USER_PATH, 400, "", accessAdminToken);
    }

    @Test
    public void getPostsWithNoAuthorisationTest() {
        postRequest(CREATE_POST_PATH, createNewPost(), 201, accessToken);
        getRequestPosts(UPDATE_OR_DELETE_OR_GET_USER_PATH, 401, userId, "");
    }

    private void getPosts() {
        getRequestPosts(UPDATE_OR_DELETE_OR_GET_USER_PATH, 200, userId, accessAdminToken);
    }

    @AfterEach
    public void deleteUser() {
        deleteRequest(UPDATE_OR_DELETE_OR_GET_USER_PATH, 204, accessAdminToken, userId);
    }

}
