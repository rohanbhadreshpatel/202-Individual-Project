package model;
import type.Category;

public class CategoryFactory {
	public Category create(String categoryName) {
		Category newCategory = null;
		switch(categoryName) {
			case "ECONOMY":
				newCategory = new Economy();
				break;
			case "BUSINESS":
				newCategory = new Business();
				break;
			case "PREMIUM ECONOMY":
				newCategory = new PremiumEconomy();
				break;
		}
		return newCategory;
	}
}