package az.developia.shopmanagement.model;

import  lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Basket {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private Integer count;
    private Integer shopid;

}
