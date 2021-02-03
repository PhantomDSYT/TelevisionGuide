//Comedy.Java
//library file needed for screen output
package Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

class Comedy extends Programme{

	public Comedy(){}

	// Implementation to abstract method to send the array holding the titles of the programme
	public String[] getContentArray() {
		File myFile = new File(Directory + "Comedy.txt");
		int lines = numOfLines(myFile);
		String[] cArray = new String[lines];
		try {
			Scanner sInFile = new Scanner(myFile);
			sInFile.useDelimiter(",");
			// Take the first string from each line of the file and copies it to the array
			while (sInFile.hasNextLine()) {
				for(int i = 0; i < lines; i++){
					String title = sInFile.next();
					cArray[i] = title;
					if(sInFile.hasNextLine() ) {
						sInFile.nextLine();
					}else{
						break;
					}
				}
			}
			sInFile.close();
		}catch (FileNotFoundException e){
			System.out.println("ERROR:- FILE NOT FOUND!");
		}
		return cArray;
	}

	// Implementation of abstract method to receive a title then display the programme
	public void Retriever(String Codename){
		File myFile = new File(Directory + "Comedy.txt");
		int lines = numOfLines(myFile);
		try {
			Scanner sInFile = new Scanner(myFile);
			sInFile.useDelimiter(",");
			// Reads the file then assigns the strings to attributes then sends it to be displayed on screen
			while (sInFile.hasNextLine()){
				for(int i = 0; i < lines; i++) {
					if(sInFile.hasNext()) {
						String title = sInFile.next();
						if (Codename.equals(title)) {
							if (sInFile.hasNext()) {
								Misc = sInFile.next();
							}
							if (sInFile.hasNext()) {
								time = sInFile.next();
							}
							// Calls the ViewNow class to display the program
							new ViewNow(0, title, Misc, time);
						}
					}
					if (sInFile.hasNextLine()) {
						sInFile.nextLine();
					} else
						break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR:- FILE NOT FOUND!");
		}
	}

	//Implementation of abstract method to send file path
	public String FilePath(){
		return Directory + "Comedy.txt";
	}

} // Closing Comedy Class