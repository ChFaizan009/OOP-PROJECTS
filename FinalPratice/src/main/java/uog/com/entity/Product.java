package uog.com.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "PRODUCT_TBL")
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int QUANTITY;
	private double PRICE;
	
}
