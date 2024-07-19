import com.google.gson.annotations.Expose;

public class User {
    private String avatarUrl;
    private String name;
    private String surname;
    private String birthDate;
    private String phone;
    private String gender;
    private String backgroundUrl;
    private String blocked;
    @Expose
    private String id;
    @Expose
    private String role;

    public User() {
    }

    public User(String avatarUrl, String name, String surname, String birthDate, String phone, String gender, String backgroundUrl, String blocked) {
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.backgroundUrl = backgroundUrl;
        this.blocked = blocked;
    }

    public User(String avatarUrl, String name, String surname, String birthDate, String phone, String gender, String backgroundUrl, String blocked, String id, String role) {
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.backgroundUrl = backgroundUrl;
        this.blocked = blocked;
        this.id = id;
        this.role = role;
    }
}
