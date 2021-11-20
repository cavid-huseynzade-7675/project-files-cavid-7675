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

    @Size(min = 1, message = "Markani 1 simvol yazmaq lazimdir")
    @Size(max = 30, message = "Markani 30 simvol yazmaq lazimdir")
    @NotEmpty(message = "Bos qoymaq olmaz")
    private String marka;

    private String model;

    @NotNull(message = "Bos qoymaq olmaz")
    @Max(value = 10000,message = "Maksimum 10000 qoymaq olar")
    @Min(value = 0,message = "Minimum 0 qoymaq olar")
    private Integer price;

    private String description;

    private String newOrOld;

    private String image;

    private String ram;

    private String cpu;

    private String yaddas;

    private String yaddastipi;

    private String emeliyyatsistemi;

    private String gpu;

}
