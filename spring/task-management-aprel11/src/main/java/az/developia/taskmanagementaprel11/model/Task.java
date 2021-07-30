package az.developia.taskmanagementaprel11.model;

import  lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min= 3,max=30,message ="Tapsirigin adi Minimum 3, Tapsirigin adi Maksimum 30 simvol" )
@NotNull(message =" Tapsirigin adini Bos qoymaq olmaz" )
@NotEmpty(message = "")
	private String name;
	@Size(min= 3,max=30,message ="Describtion Minimum 3, Describtion Maksimum 30 simvol" )
	@NotNull(message =" Describtionni Bos qoymaq olmaz" )
	@NotEmpty(message = "")
	private String description;

	private Date expireDate;
	//@Past(message = "baslama tarixi gelecek zaman ola bilmez")
	private Date beginDate;
	private Date endDate;
	@Size(min= 3,max=30,message ="Status Minimum 3, Status Maksimum 30 simvol" )
	@NotNull(message =" Statusi Bos qoymaq olmaz" )
	@NotEmpty(message = "")
	private String status;
	@Size(min= 3,max=30,message ="Username Minimum 3, Username Maksimum 30 simvol" )
	@NotNull(message =" Usernamei Bos qoymaq olmaz" )
	@NotEmpty(message = "")
	private String username;
	private Integer categoryid;
}
