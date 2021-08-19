package az.developia.shopmanagement.model;

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
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String category;
	

}
