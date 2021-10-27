package az.developia.bookshoopinfgor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 2, message = "Minimum 2 simvol yazmaq lazimdir")
    @Size(max = 30, message = "Maximum 30 simvol yazmaq lazimdir")
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min = 2, message = "Minimum 2 simvol yazmaq lazimdir")
    @Size(max = 200, message = "Maximum 200 simvol yazmaq lazimdir")
    @Column(columnDefinition = "VARCHAR(200)")   
    private String adress;


    @NotEmpty(message = "Bos qoymaq olmaz")
    @Pattern(regexp  ="((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "Telefonu duzgun formada yaz.Meselen: 000-000-0000")
    @Column(columnDefinition = "VARCHAR(20)") 
    @Size(max = 20, message = "Maximum 20 simvol yazmaq lazimdir")
      private String phone;

    @NotEmpty(message = "Bos qoymaq olmaz")
  @Email(regexp ="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Emaili Duzgun formada yaz")
    @Size(max = 100, message = "Maximum 100 yazmaq lazimdir")
    @Column(columnDefinition = "VARCHAR(100)") 
    private String email;

 

    @Size(max = 100, message = "Maximum 100 simvol yazmaq lazimdir")
    @Column(columnDefinition = "VARCHAR(100)") 
    private String note;
    public Integer getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getadress() {
        return adress;
    }

    public void setadress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer [adress=" + adress + ", email=" + email + ", id=" + id + ", name=" + name + ", note=" + note
                + ", phone=" + phone + "]";
    }

    
}
