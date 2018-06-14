package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
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

	public static void main(String[] args) {
		To_Do_List list = new To_Do_List();
		list.setup();
	}

	public void setup() {
		p.setSize(700, 700);

		f.add(p);

		f.setVisible(true);

		f.setTitle("To-Do List:");

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

	public void addTask() {
		String newTask = JOptionPane.showInputDialog("Enter a task into your To-Do List!");
		tasksList.add(newTask);
	}

	public void removeTask() {
		String removeTask = JOptionPane.showInputDialog("Which task have you completed?");

		for (int i = 0; i < tasksList.size(); i++) {
			if (newTask.get(i).contains(removeTask)) {
				tasksList.remove(i);
			}

		}
	}

	public void saveTasks() {

		//Write to a file
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/Tasks_File", true);
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt", true);)
			*/
			System.out.println(tasksList);
			
			
			//for(int i = 0; i< tasksList.size()) Where I left off: I want to read the lists line by line so that I can print it out without the [] ya know
			fw.write("" + tasksList);
			
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void loadTasks() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(tasksList);
		
		if (e.getSource().equals(addButton)) {
			addTask(); // this.addTask();
		}
		
		if (e.getSource().equals(removeButton)) {
			removeTask();
		}
		
		if (e.getSource().equals(saveButton)) {
			saveTasks();
			
		}

		}

	}

