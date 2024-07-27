import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.deletePostRequest;
import static apiUtil.UrlUtil.CREATE_POST_PATH;

public class DeletePost extends CreatePostBaseTest {

    @Test
    public void deletePostWithValidData() {
        deletePost();
    }

    public Response deletePost() {
        return deletePostRequest(CREATE_POST_PATH + "/" + id, 204, accessToken);
    }
}
