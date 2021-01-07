package com.system.employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.system.connection.DBConnection;

public class EmployeeDao {

	private static DBConnection db = new DBConnection();

	public static Employee addEmployee(Employee employee) {
		String queryInsert = "insert into employee value (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = db.con.prepareStatement(queryInsert);
			st.setInt(1, employee.getEmployeeCode());
			st.setString(2, employee.getEmployeeName());
			st.setInt(3, employee.getEmployeeAge());
			st.setLong(4, employee.getEmployeeContactNumber());
			st.setInt(5, employee.getEmployeeWorkHours());
			st.setString(6, employee.getEmployeeStatus().name());
			st.setString(7, employee.getEmployeeAddress());
			st.setLong(8, employee.getEmployeeSalary());
			st.setBoolean(9, employee.isWorking());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public static LinkedList<Employee> getAllEmployees(){
		LinkedList<Employee> employees = new LinkedList<>();

		String queryGet = "select * from employee";
		try {
			Statement s = db.con.createStatement();
			ResultSet st = s.executeQuery(queryGet);

			while(st.next()) {
				Employee employee = new Employee();
				employee.setEmployeeCode(st.getInt(1));
				employee.setEmployeeName(st.getString(2));
				employee.setEmployeeAge(st.getInt(3));
				employee.setEmployeeContactNumber(st.getLong(4));
				employee.setEmployeeWorkHours(st.getInt(5));
				employee.setEmployeeStatus(EmployeeStatus.valueOf(st.getString(6)));
				employee.setEmployeeAddress(st.getString(7));
				employee.setEmployeeSalary(st.getLong(8));
				employee.setWorking(st.getBoolean(9));

				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static Employee getEmployee(int employeeCode) {
		Employee employee = new Employee();
		String queryGet = "select * from employee WHERE employeeCode='"+employeeCode+"'";
		try {
			Statement s = db.con.createStatement();
			ResultSet st = s.executeQuery(queryGet);

			if(st.next()) {
				employee.setEmployeeCode(st.getInt(1));
				employee.setEmployeeName(st.getString(2));
				employee.setEmployeeAge(st.getInt(3));
				employee.setEmployeeContactNumber(st.getLong(4));
				employee.setEmployeeWorkHours(st.getInt(5));
				employee.setEmployeeStatus(EmployeeStatus.valueOf(st.getString(6)));
				employee.setEmployeeAddress(st.getString(7));
				employee.setEmployeeSalary(st.getLong(8));
				employee.setWorking(st.getBoolean(9));
			} else {
				employee = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public static LinkedList<Employee> getWorkingEmployee(){
		LinkedList<Employee> employees = new LinkedList<>();

		String queryGet = "select * from employee where isWorking = '1'";
		try {
			Statement s = db.con.createStatement();
			ResultSet st = s.executeQuery(queryGet);

			while(st.next()) {
				Employee employee = new Employee();
				employee.setEmployeeCode(st.getInt(1));
				employee.setEmployeeName(st.getString(2));
				employee.setEmployeeAge(st.getInt(3));
				employee.setEmployeeContactNumber(st.getLong(4));
				employee.setEmployeeWorkHours(st.getInt(5));
				employee.setEmployeeStatus(EmployeeStatus.valueOf(st.getString(6)));
				employee.setEmployeeAddress(st.getString(7));
				employee.setEmployeeSalary(st.getLong(8));
				employee.setWorking(st.getBoolean(9));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static boolean updateEmployee(Employee employee){
		boolean success = false;
		String queryUpdate = "UPDATE EMPLOYEE SET "
				+" employeeName='"+employee.getEmployeeName()+"'"
				+", employeeAge='"+employee.getEmployeeAge()+"'"
				+", employeeContactNumber='"+employee.getEmployeeContactNumber()+"'"
				+", employeeWorkHours='"+employee.getEmployeeWorkHours()+"'"
				+", employeeStatus='"+employee.getEmployeeStatus().name()+"'"
				+", employeeAddress='"+employee.getEmployeeAddress()+"'"
				+", isWorking='"+(employee.isWorking()==true?1:0)+"'"
				+", employeeSalary='"+employee.getEmployeeSalary()+"'"
				+" WHERE employeeCode='"+employee.getEmployeeCode()+"'";

		try {
			Statement s = db.con.createStatement();
			int st = s.executeUpdate(queryUpdate);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public static boolean deleteEmployee(Integer employeeCode){
		boolean success = false;
		String queryDelete = "delete from employee where employeeCode = '"+ employeeCode +"'";
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