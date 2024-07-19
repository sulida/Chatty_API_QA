import com.github.javafaker.Faker;
import com.google.gson.annotations.Expose;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.HashMap;

public class BaseTest {
    protected String url = "http://chatty.telran-edu.de:8989/api/auth/register";
    protected String refreshUrl = "http://chatty.telran-edu.de:8989/api/auth/refresh";
    protected String loginUrl = "http://chatty.telran-edu.de:8989/api/auth/login";
    protected String getUserUrl = "http://chatty.telran-edu.de:8989/api/me";
    protected Faker faker = new Faker();
    protected String email = faker.internet().emailAddress();
    protected String password = "1234hjkl";
    protected String role = "admin";
    protected String accessToken;
    protected String refreshToken;
    protected String idUser;
    protected String updateUrl = "http://chatty.telran-edu.de:8989/" + idUser;

    private  String avatarUrl = "C:\\Users\\Mi\\IdeaProjects\\Chatty_project_QA\\src\\main\\resources\\photo\\Photo1.jpg";
    private  String name = faker.name().firstName();
    private String surname = faker.name().lastName();
    private  String birthDate = "2024-07-18T22:10:23.985Z" ;
    private String phone = "+55591098360";
    private String gender = "MALE";
    private  String backgroundUrl = "string";
    private String blocked = "true";


    public Response registerValidUser() {
        UserRegistration userRegistration = new UserRegistration(email, password, password, role);
        return ApiUtil.postRequest(url, userRegistration, 201);

    }

    public HashMap<String, String> getTokens() {
        HashMap<String, String> tokens = new HashMap<>();
        JsonPath response = registerValidUser().jsonPath();
        tokens.put("accessToken", response.getString("accessToken"));
        tokens.put("refreshToken", response.getString("refreshToken"));
        return tokens;
    }

    public void setTokensAfterUserRegistration() {
        JsonPath response = registerValidUser().jsonPath();
        this.accessToken = response.getString("accessToken");
        this.refreshToken = response.getString("refreshToken");

    }
    public Response refreshTokens() {
        return ApiUtil.postRequestWithAccessToken(refreshUrl, refreshToken, 200, accessToken);
    }

    public Response loginValidUser() {
        UserRegistration userRegistration = new UserRegistration(email, password);
        return ApiUtil.postRequestWithAccessToken(loginUrl, userRegistration, 200,accessToken);

    }

    public String getUserId() {
        Response response = ApiUtil.getRequest(getUserUrl, 200,accessToken);
        this.idUser = response.jsonPath().getString("id");
        return this.idUser;
    }

    public Response updateUser() {
        User updatedUser = new User(avatarUrl,name, surname, birthDate, phone,gender,backgroundUrl,blocked);
        getUserId();
        return ApiUtil.putRequest(updateUrl, updatedUser, 200,accessToken);

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
