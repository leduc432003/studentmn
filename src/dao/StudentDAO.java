package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connData.ConnJDBC;
import model.Student;

public class StudentDAO implements DAOInterface<Student> {
	public static StudentDAO getInstance() {
		return new StudentDAO();
	} 
	public void insert(Student t) {
		String sql = "insert into student(name, age, gender, major, score) values(?, ?, ?, ?, ?)";
		try {
			Connection connection = ConnJDBC.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setInt(2, t.getAge());
			pst.setInt(3, t.getGender());
			pst.setString(4, t.getMajor());
			pst.setFloat(5, t.getScore());
			pst.execute();
			ConnJDBC.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Student t) {
		String sql = "update student set name = ?, age = ?, gender = ?, major = ?, score = ? where name = '" + t.getName() + "'";
		try {
			Connection connection = ConnJDBC.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setInt(2, t.getAge());
			pst.setInt(3, t.getGender());
			pst.setString(4, t.getMajor());
			pst.setFloat(5, t.getScore());
			pst.executeUpdate();
			ConnJDBC.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Student t) {
		String sql = "delete from student where name = '" + t.getName() + "'";
		try {
			Connection connection = ConnJDBC.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.executeUpdate();
			ConnJDBC.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> selectAll() {
		List<Student> studentList = new ArrayList<Student>();
		String sql = "select * from student";
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getInt("gender"), rs.getString("major"), rs.getFloat("score"));
				studentList.add(student);
			}
			ConnJDBC.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public List<Student> selectByName(Student t) {
		List<Student> studentList = new ArrayList<Student>();
		String sql = "select * from student where name = '" + t.getName() + "'";
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getInt("gender"), rs.getString("major"), rs.getFloat("score"));
				studentList.add(student);
			}
			ConnJDBC.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public List<Student> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
