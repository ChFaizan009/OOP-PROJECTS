package com.system.foodItem;

public class FoodItem {

	private Integer foodItemId;
	private String foodItemName;
	private Integer foodItemPrice;
	private Size foodItemSize;
	private boolean isAvailable;
	private FoodItemCategory foodItemCategory;

	public FoodItem() {}

	public FoodItem(Integer foodItemId, String foodItemName, Integer foodItemPrice, Size foodItemSize,
			boolean isAvailable, FoodItemCategory foodItemCategory) {
		super();
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.foodItemPrice = foodItemPrice;
		this.foodItemSize = foodItemSize;
		this.isAvailable = isAvailable;
		this.foodItemCategory = foodItemCategory;
	}

	@Override
	public String toString() {
		return "FoodItem [Id:" + foodItemId + ", Item Name:" + foodItemName + ", Item Price:"
				+ foodItemPrice + ", Item Size:" + foodItemSize + ", is Item Available?:" + isAvailable
				+ ", Item Category:" + foodItemCategory + "]";
	}

	public Integer getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(Integer foodItemId) {
		this.foodItemId = foodItemId;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public Integer getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(Integer foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}

	public Size getFoodItemSize() {
		return foodItemSize;
	}

	public void setFoodItemSize(Size foodItemSize) {
		this.foodItemSize = foodItemSize;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public FoodItemCategory getFoodItemCategory() {
		return foodItemCategory;
	}

	public void setFoodItemCategory(FoodItemCategory foodItemCategory) {
		this.foodItemCategory = foodItemCategory;
	}
	
}
