package az.developia.shopmanagement.model;

import  lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Shop {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min= 3,max=30,message ="Mehsulun adi Minimum 3, Mehsulun adi Maksimum 30 simvol" )
	@NotNull(message =" Mehsulun adini Bos qoymaq olmaz" )
	@NotEmpty(message = "Mehsulun adini Bos qoymaq olmaz")
	private String name;
	@NotNull(message =" Melumati  Bos qoymaq olmaz" )
	@NotEmpty(message = "Melumati  Bos qoymaq olmaz")
	private String description;
	private Date beginDate;
	@Size(min= 3,max=30,message ="Mehsulun Statusu Minimum 3, Mehsulun adi Maksimum 30 simvol" )
	@NotNull(message =" Statusu  Bos qoymaq olmaz" )
	@NotEmpty(message = " Statusu  Bos qoymaq olmaz")
	private String status;
	private Integer price;
	private String username;
	private Integer categoryid;
	private String image;

}
