package az.developia.compshopcavidhuseynzade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Computer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;

    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 30, message = "30 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String marka;
    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 60, message = " 60 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String model;

    @NotNull(message = "Bos qoymaq olmaz")
    @Max(value = 10000,message = "Maksimum 10000 qoymaq olar")
    @Min(value = 0,message = "Minimum 0 qoymaq olar")
    private Integer price;
    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 60, message = " 60 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String description;
   
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String newOrOld;
   
    private String image;
    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 60, message = " 60 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String ram;
    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 60, message = " 60 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String cpu;
    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 60, message = " 60 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String yaddas;
    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 60, message = " 60 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String yaddastipi;
    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 60, message = " 60 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String emeliyyatsistemi;
    @Size(min = 1, message = "1 simvol yazmaq lazimdir")
    @Size(max = 60, message = " 60 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String gpu;

}
