package az.developia.taskmanagementaprel11.model;

import  lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String name;
	private String description;
	private Date expireDate;
	private Date beginDate;
	private Date endDate;
	private String status;
	private String username;
	private Integer categoryid;
}
