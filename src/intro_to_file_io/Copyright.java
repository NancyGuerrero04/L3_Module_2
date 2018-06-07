package intro_to_file_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copyright {
	public static void main(String[] args) {
		File f = new File("src");
		CheckDirectory(f);

	}

	public static void CheckDirectory(File directory) { // Recursive Function: a function that calls itself
		File[] arrayFile = directory.listFiles();

		for (int i = 0; i < arrayFile.length; i++) {
			// System.out.println(arrayFile[i].getAbsolutePath());

			if (arrayFile[i].isDirectory()) { // Checks if there are directories/folders
				System.out.println(arrayFile[i].getAbsolutePath());
				CheckDirectory(arrayFile[i]);

				if (arrayFile[i].isFile()) { // Checks if there are files *inside* the directories/folders
					System.out.println(arrayFile[i].getAbsolutePath());
				}

			}

			if (arrayFile[i].getAbsolutePath().contains(".java")) { // Checks if it is a .java file
				// System.out.println(".java");
				
				String s = "";
				try {
					BufferedReader br = new BufferedReader(new FileReader(arrayFile[i]));
					
					String line = br.readLine();
					while(line != null){
						line = br.readLine();
						s = s+line;
						System.out.println(line);
					}
					
					br.close();
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				try {
					FileWriter fw = new FileWriter(arrayFile[i], true);

					fw.write("//Copyright © 2018 by Nancy G"); // Copyright

					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
// Copyright © 2018 by Nancy G//Copyright © 2018 by Nancy G