import java.util.Objects;

public class UserRegistration {
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private String id;
    private String updatedPassword;
    private  String avatarUrl;
    private  String name;
    private String surname;
    private  String birthDate;
    private String gender;
    private  String backgroundUrl;
    private String blocked;


     public UserRegistration() {
    }

    public UserRegistration(String id) {
        this.id = id;
    }

    public UserRegistration(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserRegistration(String email, String password, String confirmPassword, String role) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public UserRegistration(String email, String updatedPassword, String avatarUrl, String name, String surname, String birthDate, String gender, String backgroundUrl, String blocked) {
        this.email = email;
        this.updatedPassword = updatedPassword;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.backgroundUrl = backgroundUrl;
        this.blocked = blocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegistration userRegistration = (UserRegistration) o;
        return email.equals(userRegistration.email) && password.equals(userRegistration.password) && confirmPassword.equals(userRegistration.confirmPassword) && role.equals(userRegistration.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, confirmPassword, role);
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
