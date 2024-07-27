import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import post.Post;
import user.User;

import static apiUtil.ApiRequests.*;
import static apiUtil.UrlUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static post.PostCreate.updatePostWithValidData;

public class UpdatePostTest extends CreatePostBaseTest {
    @Test
    public void updatePostTest() {
        Post expectedPost = updatePostWithValidData();
        putRequest(CREATE_POST_PATH + "/" + id, expectedPost, 200, accessToken);
        Post returnedPost = getRequest(CREATE_POST_PATH + "/" + id, 200, accessToken).body().as(Post.class);
        assertEquals(id, returnedPost.getId());
        assertEquals(expectedPost.getTitle(), returnedPost.getTitle());
        assertEquals(expectedPost.getDescription(), returnedPost.getDescription());
        assertEquals(expectedPost.getBody(), returnedPost.getBody());
        assertEquals(expectedPost.getImageUrl(), returnedPost.getImageUrl());
        assertFalse(returnedPost.getDraft());
        User returnedUser = returnedPost.getUser();
        assertEquals(userId, returnedUser.getId());
        assertNull(returnedUser.getName());
        assertNull(returnedUser.getSurname());
        assertNull(returnedUser.getPhone());
        assertNull(returnedUser.getName());
        assertFalse(returnedUser.getEmail().isEmpty());
        assertTrue(returnedUser.getRole().equals("USER"));
        assertNull(returnedUser.getGender());
        assertNull(returnedUser.getAvatarUrl());

    }

    @Test
    public void updatePostWithoutUpdatedData() {
        this.id = getPostIdAfterCreateNewPost();
        putRequest(CREATE_POST_PATH + "/" + id, "", 400, accessToken);
    }

    @Test
    public void updatePostWithNoAuthorisation() {
        this.id = getPostIdAfterCreateNewPost();
        putRequest(CREATE_POST_PATH + "/" + id, updatePostWithValidData(), 401, "");
    }
    public Response updatePost() {
        return putRequest(CREATE_POST_PATH + "/" + id, updatePostWithValidData(), 200, accessToken);
    }

}

