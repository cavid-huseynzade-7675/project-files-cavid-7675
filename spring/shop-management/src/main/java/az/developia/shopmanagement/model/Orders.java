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
public class Orders {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String name;
    private String adress;
    private String phone;
    private String email;
    private String note;
    private String basketIds;
    private Date date;
}
