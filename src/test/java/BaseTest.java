import static apiUtil.ApiRequests.getRequest;
import static apiUtil.ApiRequests.postRequest;
import static apiUtil.ApiRequests.postRequestNoToken;
import static apiUtil.ApiRequests.putRequest;
import apiUtil.UrlUtil;
import static apiUtil.UrlUtil.GET_USER_PATH;
import static apiUtil.UrlUtil.REFRESH_PATH;
import static apiUtil.UrlUtil.REGISTER_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_USER_PATH;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import user.AuthorizationUser;
import static user.UserDataRegistry.getAdminRegistration;
import static user.UserDataRegistry.getUpdatedUser;
import static user.UserDataRegistry.getUserForLogin;
import static user.UserDataRegistry.getUserRegistration;
import user.UserRole;

import java.util.HashMap;


public class BaseTest {
    protected String accessToken;
    protected String refreshToken;
    protected AuthorizationUser authUser;


    public Response registerValidUser(UserRole role) {
        Response response;

        if(UserRole.ADMIN == role){
            this.authUser = getAdminRegistration();
            response = postRequestNoToken(REGISTER_PATH, authUser, 201);
        } else if(UserRole.USER == role){
            this.authUser = getUserRegistration();
            response = postRequestNoToken(REGISTER_PATH, authUser, 201);
        } else {
            throw new IllegalArgumentException("User with unknown role");
        }

        return response;
    }

    public void setTokensAfterUserRegistration(UserRole role) {
        JsonPath jsonPath = registerValidUser(role).jsonPath();
        this.accessToken = jsonPath.getString("accessToken");
        this.refreshToken = jsonPath.getString("refreshToken");
    }

    public Response refreshTokens() {
        return postRequest(REFRESH_PATH, refreshToken, 200, accessToken);
    }

    public Response loginRegisteredUser() {
        return postRequest(UrlUtil.AUTH_PATH, getUserForLogin(authUser), 200, accessToken);
    }

    public String getUserIdAfterRequest() {
        return getRequest(GET_USER_PATH, 200, accessToken)
                .jsonPath()
                .getString("id");
    }

    public HashMap<String, String> getTokens(UserRole role) {
        HashMap<String, String> tokens = new HashMap<>();
        JsonPath response = registerValidUser(role).jsonPath();
        tokens.put("accessToken", response.getString("accessToken"));
        tokens.put("refreshToken", response.getString("refreshToken"));
        return tokens;
    }


     //!!!recomedyy vinesti v test update user etot method
    public Response updateUser() {
        String idUser = getUserIdAfterRequest();
        return putRequest(UPDATE_OR_DELETE_USER_PATH + idUser, getUpdatedUser(), 200, accessToken);
    }

}
