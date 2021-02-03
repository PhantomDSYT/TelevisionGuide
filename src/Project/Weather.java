//Weather.Java

//library file needed for screen output
package Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.Scanner;

class Weather extends Programme{

	public Weather(){}

	// Implementation to abstract method to send the array holding the titles of the programme
	public String[] getContentArray() {
		String[] wArray = new String[10];
		try {
			Scanner sInFile = new Scanner(new File(Directory + "Weather.txt"));
			sInFile.useDelimiter(",");
			// Take the first string from each line of the file and copies it to the array
			while (sInFile.hasNextLine()) {
				for(int i = 0; i < 10; i++){
					String title = sInFile.next();
					wArray[i] = title;
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
		return wArray;
	}

	// Implementation of abstract method to receive a title then display the programme
	public void Retriever(String Codename){
		try {
			Scanner sInFile = new Scanner(new File(Directory + "Weather.txt"));
			sInFile.useDelimiter(",");
			// Reads the file then assigns the strings to attributes then sends it to be displayed on screen
			while (sInFile.hasNextLine()){
				for(int i = 0; i < 10; i++) {
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
							new ViewNow(6, title, Misc, time);
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
		return Directory + "Weather.txt";
	}
} // Closing Weather Class