package com.acme.multimongo.repository.coffee;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Visweshwar Ganesh
 * @Created 11/22/2020 - 3:09 PM
 */

@Document
public class ShopEntity {
	@Id
	private String _id;
	private String name;
	private int typesOfCoffee;

	public ShopEntity(String name, int typesOfCoffee) {
		this.name = name;
		this.typesOfCoffee = typesOfCoffee;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypesOfCoffee() {
		return typesOfCoffee;
	}

	public void setTypesOfCoffee(int typesOfCoffee) {
		this.typesOfCoffee = typesOfCoffee;
	}
}
