package com.example.pharmassist.requestdtos;

import java.time.LocalDate;

import com.example.pharmassist.enums.Form;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MedicineRequest 
{
	@NotNull(message ="Name cannot be null")
	@NotBlank(message ="Name cannot be blank")
	@Pattern(regexp ="^[A-Za-z0-9\\s\\-\\(\\)]{1,50}$",message = "Invalid name")
	private String name;

	@NotNull(message ="Category cannot be null")
	@NotBlank(message ="Category cannot be blank")
	@Pattern(regexp ="^[A-Za-z0-9\\s\\-\\(\\)]{1,50}$",message = "Invalid category")
	private String category;

	@NotNull(message ="Ingredients cannot be null")
	@NotBlank(message ="Ingredients cannot be blank")
	@Pattern(regexp ="^[A-Za-z0-9\\s\\-,]{1,200}$",message = "Invalid ingredients")
	private String ingredients;

	@NotNull(message ="Manufacturer cannot be null")
	@NotBlank(message ="Manufacturer cannot be blank")
	@Pattern(regexp ="^[A-Za-z\\s\\.,]{1,100}$",message = "Invalid manufacturer")
	private String manufacturer;

	@Min(value = 1, message = "Dosage must be at least 1 mg")
	private int dosageInMg;

	@DecimalMin(value = "0.01", message = "Price must be at least Rs.0.01")
	private double price;

	@NotNull (message = "ExpiryDate cannot be null")
	private LocalDate expiryDate;

	@NotNull (message = "Form cannot be null")
	private Form form;

	@Min(value = 1, message = "Quantity must be at least Rs.1")
	private int stockQuantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public int getDosageInMg() {
		return dosageInMg;
	}

	public void setDosageInMg(int dosageInMg) {
		this.dosageInMg = dosageInMg;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
