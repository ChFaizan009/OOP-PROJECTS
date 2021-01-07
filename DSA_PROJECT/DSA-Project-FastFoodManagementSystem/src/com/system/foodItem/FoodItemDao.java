package com.system.foodItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.system.connection.DBConnection;

public class FoodItemDao {

	private static DBConnection db = new DBConnection();

	public FoodItemDao() {}

	public static FoodItem addFoodItem(FoodItem foodItem) {
		String queryInsert = "insert into FoodItem value (?,?,?,?,?,?)";
		try {
			PreparedStatement st = db.con.prepareStatement(queryInsert);
			st.setInt(1, foodItem.getFoodItemId());
			st.setString(2, foodItem.getFoodItemName());
			st.setInt(3, foodItem.getFoodItemPrice());
			st.setString(4, foodItem.getFoodItemSize().name());
			st.setBoolean(5, foodItem.isAvailable());
			st.setString(6, foodItem.getFoodItemCategory().toString());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodItem;
	}

	public static FoodItem getFoodItem(int foodItemId) {
		FoodItem foodItem = new FoodItem();
		String queryGet = "select * from FoodItem WHERE foodItemId='"+foodItemId+"'";
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			if (rs.next()==true) {
				foodItem.setFoodItemId(rs.getInt(1));
				foodItem.setFoodItemName(rs.getString(2));
				foodItem.setFoodItemPrice(rs.getInt(3));
				foodItem.setFoodItemSize(Size.valueOf(rs.getString(4).toString()));
				foodItem.setAvailable(rs.getBoolean(5));
				foodItem.setFoodItemCategory(FoodItemCategory.valueOf(rs.getString(6).toString()));
			}else {
				foodItem = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodItem;
	}

	public static LinkedList<FoodItem> getAllFoodItems() {
		LinkedList<FoodItem> foodItems = new LinkedList<>();
		String queryGet = "select * from FoodItem";
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				FoodItem foodItem = new FoodItem();
				foodItem.setFoodItemId(rs.getInt(1));
				foodItem.setFoodItemName(rs.getString(2));
				foodItem.setFoodItemPrice(rs.getInt(3));
				foodItem.setFoodItemSize(Size.valueOf(rs.getString(4).toString()));
				foodItem.setAvailable(rs.getBoolean(5));
				foodItem.setFoodItemCategory(FoodItemCategory.valueOf(rs.getString(6).toString()));
				foodItems.add(foodItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodItems;
	}

	public static boolean updateFoodItem(FoodItem foodItem) {
		boolean success = false;
		String queryUpdate = "UPDATE FoodItem SET "
				+" foodItemName='"+foodItem.getFoodItemName()+"'"
				+", foodItemPrice='"+foodItem.getFoodItemPrice()+"'"
				+", foodItemSize='"+foodItem.getFoodItemSize().name()+"'"
				+", isAvailable='"+(foodItem.isAvailable()==true?1:0)+"'"
				+", foodItemCategory='"+(foodItem.getFoodItemCategory().name())+"'"
				+" where foodItemId='"+foodItem.getFoodItemId()+"'";
		try {
			Statement s = db.con.createStatement();
			int st = s.executeUpdate(queryUpdate);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public static boolean deleteFoodItem(Integer foodItemId) {
		boolean success = false;
		String queryDelete = "delete from FoodItem where foodItemId = '"+ foodItemId +"'";
		try {
			Statement s = db.con.createStatement();
			int st = s.executeUpdate(queryDelete);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

}
