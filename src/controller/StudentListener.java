package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.StudentDAO;
import model.Student;
import view.StudentView;

public class StudentListener implements ActionListener {
	private StudentView studentView;
	
	public StudentListener(StudentView studentView) {
		this.studentView = studentView;
	}

	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Save")) {
			Student st = new Student();
			st.setName(studentView.textName.getText());
			st.setAge(Integer.parseInt(studentView.textAge.getText()));
			st.setGender(studentView.comboBoxGender.getSelectedIndex());
			st.setMajor(studentView.textMajor.getText());
			st.setScore(Float.parseFloat(studentView.textScore.getText()));
			StudentDAO.getInstance().insert(st);
			JOptionPane.showMessageDialog(null, "Save Success!");
			studentView.showData(StudentDAO.getInstance().selectAll());
		} else if(button.equals("Find")) {
			Student st = new Student();
			st.setName(studentView.textName.getText());
			studentView.showData(StudentDAO.getInstance().selectByName(st));
		} else if(button.equals("Delete")) {
			Student st = new Student();
			st.setName(studentView.textName.getText());
			StudentDAO.getInstance().delete(st);
			studentView.showData(StudentDAO.getInstance().selectAll());
		} else if(button.equals("Update")) {
			Student st = new Student();
			st.setName(studentView.textName.getText());
			st.setAge(Integer.parseInt(studentView.textAge.getText()));
			st.setGender(studentView.comboBoxGender.getSelectedIndex());
			st.setMajor(studentView.textMajor.getText());
			st.setScore(Float.parseFloat(studentView.textScore.getText()));
			StudentDAO.getInstance().update(st);
			JOptionPane.showMessageDialog(null, "Save Success!");
			studentView.showData(StudentDAO.getInstance().selectAll());
		} else if(button.equals("Refresh")) {
			studentView.textName.setText("");
			studentView.textAge.setText("");
			studentView.textMajor.setText("");
			studentView.textScore.setText("");
		}
	}
	
}
