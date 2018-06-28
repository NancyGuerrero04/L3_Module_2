package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class To_Do_List implements ActionListener {
	// Member variables
	ArrayList<String> tasksList = new ArrayList<String>();

	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton addButton = new JButton();
	JButton removeButton = new JButton();
	JButton saveButton = new JButton();
	JButton loadButton = new JButton();
	JLabel l = new JLabel();

	public static void main(String[] args) { 
		To_Do_List list = new To_Do_List();
		list.setup();
	}

	public void setup() {
		p.setSize(700, 700);

		f.add(p);

		f.setVisible(true);

		f.setTitle("To-Do List:");
		
		p.add(l);
		
		l.setText("");

		p.add(addButton);
		addButton.setText("Add Task");
		addButton.addActionListener(this);

		p.add(removeButton);
		removeButton.setText("Remove Task");
		removeButton.addActionListener(this);

		p.add(saveButton);
		saveButton.setText("Save");
		saveButton.addActionListener(this);

		p.add(loadButton);
		loadButton.setText("Load");
		loadButton.addActionListener(this);
		

		f.pack();

	}

	public void updateTaskLabel() {
		for (int i = 0; i < tasksList.size(); i++) {
			l.setText(tasksList.get(i)+ "\n");

		}
	}
	
	public void addTask() {
		String newTask = JOptionPane.showInputDialog("Enter a task into your To-Do List!");
		tasksList.add(newTask);
		
		updateTaskLabel();
		
	}

	public void removeTask() {
		String removeTask = JOptionPane.showInputDialog("Which task have you completed?");

		for (int i = 0; i < tasksList.size(); i++) {
			if (removeTask.contains(tasksList.get(i))) {
				tasksList.remove(i);
			}

		}
	}

	public void saveTasks() {

		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);


			try {
			
				FileWriter fw = new FileWriter(fileName, false);
				for (int i = 0; i < tasksList.size(); i++) {
					fw.write(tasksList.get(i)+ "\n");

				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void loadTasks() { //The load button will clear the task list and display it 
		JFileChooser jfc2 = new JFileChooser();
		int returnVal = jfc2.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName2 = jfc2.getSelectedFile().getAbsolutePath();
			System.out.println(fileName2);
	
			
			try {
				
				FileWriter fw = new FileWriter(fileName2, false);
				
				fw.write("");
				fw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		tasksList.clear();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(tasksList);

		if (e.getSource().equals(addButton)) {
			addTask(); // this.addTask();
		}

		if (e.getSource().equals(removeButton)) {
			removeTask();
		}

		if (e.getSource().equals(saveButton)) {
			saveTasks();

		}
		if (e.getSource().equals(loadButton)) {
			loadTasks();

		}

	}

}
