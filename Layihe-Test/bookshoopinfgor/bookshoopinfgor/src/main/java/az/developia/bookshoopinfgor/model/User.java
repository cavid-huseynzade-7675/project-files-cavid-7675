package az.developia.bookshoopinfgor.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 1, message = "Istifadeci adi minimum 1 simvol yazmaq lazimdir")
    @Size(max = 30, message = " Istifadeci adi Maximum 30 simvol yazmaq lazimdir")
    private String username;
    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 1, message = "Sifre 1 simvol yazmaq lazimdir")
    @Size(max = 30, message = "Sifre 30 simvol yazmaq lazimdir")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ",password=" + password + "]";

    }
}
