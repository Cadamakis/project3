package com.myservlet.product;

import javax.persistence.*;

@Entity
@Table(name = "product")
@SqlResultSetMapping(//map the entity in order to get the contents when creating a query
		name = "ProdMap",
		entities =@EntityResult(
					entityClass = Productc.class,
					fields = {
							@FieldResult(name = "name", column = "name"),
							@FieldResult(name = "barcode", column = "barcode"),
							@FieldResult(name = "color", column = "color"),
							@FieldResult(name = "description", column = "description")}))
public class Productc {//productc class created by the persistence model
	
	@Column(name= "name")
	private String name;
	
	@Id
	@Column(name= "barcode")
	private Long Barcode;
	
	@Column(name= "color")
	private String color;
	
	@Column(name= "description")
	private String description;

	public Productc(){
	}
	
	public Productc(String name, Long Barcode, String color, String description) {
		super();
		this.name = name;
		this.Barcode = Barcode;
		this.color = color;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBarcode() {
		return Barcode;
	}
	public void setBarcode(Long barcode) {
		Barcode = barcode;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
