package az.developia.bookmangement.model;

import  lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer price;
	private String username;
	private String name;
	private String description;
	private String sekil;
	private String phone;
}
