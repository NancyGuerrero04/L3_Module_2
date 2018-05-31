package intro_to_file_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copyright {
	public static void main(String[] args) {
		File f = new File("src");
		File[] arrayFile = f.listFiles();

		for (int i = 0; i < arrayFile.length; i++) {
			System.out.println(arrayFile[i].getAbsolutePath());
			
			if(arrayFile[i].isFile()) {
				System.out.println(arrayFile);
			}
			

			if (arrayFile[i].getAbsolutePath().contains(".java")) {
				System.out.println(".java");
				try {
					FileWriter fw = new FileWriter(arrayFile[i], true);

					fw.write("//Copyright © 2018 by Nancy G");

					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
