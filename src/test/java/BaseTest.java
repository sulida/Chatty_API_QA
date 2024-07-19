import com.github.javafaker.Faker;
import com.google.gson.annotations.Expose;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import object.UserRole;

import java.util.HashMap;


public class BaseTest {
//    protected final static String BASE_URL = "http://chatty.telran-edu.de:8989/api";
//    //    protected String url = "http://chatty.telran-edu.de:8989/api/auth/register";
//    protected final static String REFRESH_PATH = "/auth/refresh";
////    protected String refreshUrl = "http://chatty.telran-edu.de:8989/api/auth/refresh";
//    protected final static String AUTH_PATH = "/auth/login";
//    //    protected String loginUrl = "http://chatty.telran-edu.de:8989/api/auth/login";
//    protected String getUserUrl = "http://chatty.telran-edu.de:8989/api/me";
    protected Faker faker = new Faker();
    protected String email = faker.internet().emailAddress();
    protected String password = "1234hjkl";
    protected String roleUser = UserRole.USER.toString().toLowerCase();
    protected String roleAdmin = UserRole.ADMIN.toString().toLowerCase();
    protected String accessToken;
    protected String refreshToken;
    protected String idUser;
//    protected String updateUrl = "http://chatty.telran-edu.de:8989/" + idUser;

    private String avatarUrl = "C:\\Users\\Mi\\IdeaProjects\\Chatty_project_QA\\src\\main\\resources\\photo\\Photo1.jpg";
    private String name = faker.name().firstName();
    private String surname = faker.name().lastName();
    private String birthDate = "2024-07-18T22:10:23.985Z";
    private String phone = "+55591098360";
    private String gender = "MALE";
    private String backgroundUrl = "string";
    private String blocked = "true";


    public Response registerValidUser(String role) {
        UserRegistration userRegistration = new UserRegistration(email, password, password, role);
        return ApiUtil.postRequest(UrlUtil.BASE_URL, userRegistration, 201);

    }

    public HashMap<String, String> getTokens(String role) {
        HashMap<String, String> tokens = new HashMap<>();
        JsonPath response = registerValidUser(role).jsonPath();
        tokens.put("accessToken", response.getString("accessToken"));
        tokens.put("refreshToken", response.getString("refreshToken"));
        return tokens;
    }

    public void setTokensAfterUserRegistration(UserRole role) {
        JsonPath response;
        
        if(UserRole.ADMIN == role){
            response = registerValidUser(roleAdmin).jsonPath();
        } else if(UserRole.USER == role){
            response = registerValidUser(roleUser).jsonPath();
        } else {
            throw new IllegalArgumentException("User with inknown role");
        }

        this.accessToken = response.getString("accessToken");
        this.refreshToken = response.getString("refreshToken");
    }






    public Response refreshTokens() {
        return ApiUtil.postRequestWithAccessToken(UrlUtil.REFRESH_PATH, refreshToken, 200, accessToken);
    }

    public Response loginValidUser() {
        UserRegistration userRegistration = new UserRegistration(email, password);
        return ApiUtil.postRequestWithAccessToken(UrlUtil.AUTH_PATH, userRegistration, 200, accessToken);

    }

    public void setUserIdAfterGetUser() {
        Response response = ApiUtil.getRequest(UrlUtil.GETUSER_PATH, 200, accessToken);
        this.idUser = response.jsonPath().getString("id");

    }

    public Response updateUser() {
        User updatedUser = new User(avatarUrl, name, surname, birthDate, phone, gender, backgroundUrl, blocked);
        setUserIdAfterGetUser();
        return ApiUtil.putRequest(UrlUtil.UPDATE_OR_EDELETE_USER_PATH + idUser, updatedUser, 200, accessToken);

    }

//    public void updateUserDetails() {
//        updates = new HashMap<>();
//        updates.put("avatarUrl", "string");
//        updates.put("name", faker.name().firstName());
//        updates.put("surname", faker.name().lastName());
//        updates.put("birthDate", "2024-07-18T22:10:23.985Z");
//        updates.put("gender", "MALE");
//        updates.put("backgroundUrl", "string");
//        updates.put("blocked", true);
//        Response updatedResponse = updateUser(updates);
//
//    }
}
