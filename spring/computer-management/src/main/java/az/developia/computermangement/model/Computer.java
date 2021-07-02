package az.developia.computermangement.model;

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
public class Computer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer price;
	private String name;
	private String description;

	private String neew;
	private String username;
	private String categoryname;
	private String phone;
	private String ram;
	private String cpu;
	private String gpu;
	private String wind;
	private String storage;
	private String storagetype;
}
