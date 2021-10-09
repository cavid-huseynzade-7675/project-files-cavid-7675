package az.developia.bookshoopinfgor.model;

import javax.annotation.Generated;//adi sehvdi sadece
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class BookModel {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Bos qoymaq olmaz")
    @Size(min=2,message = "Minimum 2 simvol yazmaq lazimdir")
    @Size(max=30,message = "Maximum 30 simvol yazmaq lazimdir")
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;
 

    private String description;

    @Min(value = 0,message = "Minimum 0 yazmaq olar")
    @Max(value = 1000,message = "Maximum 1000 yazmaq olar")
    @NotNull(message = "Bos qoymaq olmaz")
    private Double price;

    private Integer pageCount;
    private String username;
    private String image;
    @Column(columnDefinition = "VARCHAR(30)")
    @Size(max=30,message = "Maximum 30 simvol yazmaq lazimdir")
    private String author;
    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getId() {
        return id;
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
}
