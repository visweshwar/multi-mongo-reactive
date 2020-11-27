package com.acme.multimongo.repository.burger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Visweshwar Ganesh
 * @Created 11/22/2020 - 3:08 PM
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreEntity {
	@Id
	private String _id;
	private String name;
	private int burgerTypes;

	public StoreEntity(String name, int burgerTypes) {
		this.name = name;
		this.burgerTypes = burgerTypes;
	}
}
