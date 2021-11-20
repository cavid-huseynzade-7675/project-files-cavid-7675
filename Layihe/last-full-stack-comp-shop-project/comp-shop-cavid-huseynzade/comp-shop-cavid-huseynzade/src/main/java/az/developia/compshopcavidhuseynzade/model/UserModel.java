package az.developia.compshopcavidhuseynzade.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 1, message = "Istifadeci adi minimum 1 simvol yazmaq lazimdir")
    @Size(max = 30, message = " Istifadeci adi Maximum 30 simvol yazmaq lazimdir")
    private String username;
    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 1, message = "Sifre 1 simvol yazmaq lazimdir")
    @Size(max = 30, message = "Sifre 30 simvol yazmaq lazimdir")
    private String password;
    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 1, message = "Email 1 simvol yazmaq lazimdir")
    @Size(max = 60, message = "Email 60 simvol yazmaq lazimdir")
    @Email(regexp ="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Emaili Duzgun formada yaz")
 
    private String email;
    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 1, message = "Phone 1 simvol yazmaq lazimdir")
    @Size(max = 60, message = "Phone 60 simvol yazmaq lazimdir")
    @Pattern(regexp  ="((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "Telefonu duzgun formada yaz.Meselen: 000-000-0000")
  
    private String phone;
    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 1, message = "nameandsurname 1 simvol yazmaq lazimdir")
    @Size(max = 60, message = "nameandsurname 60 simvol yazmaq lazimdir")
    private String nameandsurname;

}
