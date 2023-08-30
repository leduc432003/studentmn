package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connData.ConnJDBC;
import controller.StudentListener;
import dao.StudentDAO;
import model.Student;

public class StudentView extends JFrame {

	private JPanel contentPane;
	public JTextField textName;
	public JTextField textAge;
	public JTextField textMajor;
	public JTextField textScore;
	public JComboBox comboBoxGender;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public StudentView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ActionListener actionListener = new StudentListener(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(342, 26, 346, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(27, 112, 118, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(27, 172, 118, 50);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gender");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(27, 239, 118, 50);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Major");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(27, 292, 118, 50);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Score");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(27, 352, 118, 50);
		contentPane.add(lblNewLabel_1_4);
		
		textName = new JTextField();
		textName.setBounds(140, 124, 180, 31);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(140, 184, 180, 31);
		contentPane.add(textAge);
		
		textMajor = new JTextField();
		textMajor.setColumns(10);
		textMajor.setBounds(140, 304, 180, 31);
		contentPane.add(textMajor);
		
		textScore = new JTextField();
		textScore.setColumns(10);
		textScore.setBounds(140, 364, 180, 31);
		contentPane.add(textScore);
		
		comboBoxGender = new JComboBox();
		comboBoxGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBoxGender.setBounds(140, 249, 180, 31);
		contentPane.add(comboBoxGender);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.addActionListener(actionListener);
		btnSave.setBounds(27, 472, 118, 41);
		contentPane.add(btnSave);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(actionListener);
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(202, 472, 118, 41);
		contentPane.add(btnFind);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(actionListener);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(388, 472, 118, 41);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(actionListener);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(570, 472, 118, 41);
		contentPane.add(btnUpdate);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(actionListener);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(388, 412, 118, 41);
		contentPane.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 116, 596, 226);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Age", "Gender", "Major", "Score"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		showData(StudentDAO.getInstance().selectAll());
		this.setVisible(true);
	}
	public void showData(List<Student> studentl) {
		List<Student> listStudent = new ArrayList<Student>();
		listStudent = studentl;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel= (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for (Student student : listStudent) {
			String gender;
			if(student.getGender() == 0) {
				gender = "Male";
			} else {
				gender = "Famale";
			}
			tableModel.addRow(new Object [] {
					student.getId(), student.getName(), student.getAge(), gender, student.getMajor(), student.getScore()
			});
		}
	}
}
