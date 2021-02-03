package Project;

import java.io.*;
import java.time.LocalTime;
import java.util.Scanner;

public class ListingMake {
	// Random number generator for the listing
	public ListingMake(int n){}

	public String RNGMachine(String[] sample){
		double rand = Math.random() * (sample.length-1);
		int select = (int)Math.round(rand);
		return sample[select];

	}
	//Generation of the Programme listing file
	public ListingMake(){
		String[][] Listing = new String[29][25];

		// Making a array of classes utilizing polymorphism
		Programme[] ProgrammeArray = new Programme[7];
		ProgrammeArray[0] = new Comedy();
		ProgrammeArray[1] = new General();
		ProgrammeArray[2] = new Gospel();
		ProgrammeArray[3] = new Kids();
		ProgrammeArray[4] = new Movies();
		ProgrammeArray[5] = new News();
		ProgrammeArray[6] = new Weather();


		BufferedWriter sOutFile;
		//Formatting the file to have a table like look
		try {
			File list = new File("src\\resources\\Programme_listing.txt");
			boolean exists = list.exists();
			if (!exists) {
				sOutFile = new BufferedWriter(new FileWriter("src\\resources\\Programme_listing.txt"));
				for(int i = 0; i < Listing.length; i++) {
					for (int y = 0; y < Listing[i].length; y++) {
						if(y == 0){
							Listing[1][y] = "101 - BBC";
							Listing[2][y] = "102 - RCT";
							Listing[3][y] = "103 - TVJ";
							Listing[4][y] = "104 - CNN";
							Listing[5][y] = "105 - CBS";
							Listing[6][y] = "106 - WWS";
							Listing[7][y] = "107 - BOOM";
							Listing[8][y] = "108 - WWIS";
							Listing[9][y] = "109 - BET";
							Listing[10][y] = "110 - MTV";
							Listing[11][y] = "111 - CVM";
							Listing[12][y] = "112 - GTV";
							Listing[13][y] = "113 - CN";
							Listing[14][y] = "114 - NICK";
							Listing[15][y] = "115 - LMN";
							Listing[16][y] = "116 - HALL";
							Listing[17][y] = "117 - SKY";
							Listing[18][y] = "118 - GMIX";
							Listing[19][y] = "119 - PWS";
							Listing[20][y] = "120 - NBC";
							Listing[21][y] = "121 - PBS";
							Listing[22][y] = "122 - SYFY";
							Listing[23][y] = "123 - MCGL";
							Listing[24][y] = "124 - FOX";
							Listing[25][y] = "125 - GFT";
							Listing[26][y] = "126 - GWS";
							Listing[27][y] = "127 - DISN";
							Listing[28][y] = "128 - NCU";
						}
						if (i == 0) {
							Listing[i][0] = "Channel";
							Listing[i][1] = "00:00";
							Listing[i][2] = "01:00";
							Listing[i][3] = "02:00";
							Listing[i][4] = "03:00";
							Listing[i][5] = "04:00";
							Listing[i][6] = "05:00";
							Listing[i][7] = "06:00";
							Listing[i][8] = "07:00";
							Listing[i][9] = "08:00";
							Listing[i][10] = "09:00";
							Listing[i][11] = "10:00";
							Listing[i][12] = "11:00";
							Listing[i][13] = "12:00";
							Listing[i][14] = "13:00";
							Listing[i][15] = "14:00";
							Listing[i][16] = "15:00";
							Listing[i][17] = "16:00";
							Listing[i][18] = "17:00";
							Listing[i][19] = "18:00";
							Listing[i][20] = "19:00";
							Listing[i][21] = "20:00";
							Listing[i][22] = "21:00";
							Listing[i][23] = "22:00";
							Listing[i][24] = "23:00";
						}
						// Depending on the, and entry will be entered from its respecting array
						if(y != 0 && i != 0) {
							if (i == 2 || i == 9 || i == 10 || i == 21)
								Listing[i][y] = this.RNGMachine(ProgrammeArray[0].getContentArray());
							else if (i == 3 || i == 11 || i == 20 || i == 25)
								Listing[i][y] = this.RNGMachine(ProgrammeArray[1].getContentArray());
							else if (i == 18 || i == 23 || i == 12 || i == 28)
								Listing[i][y] = this.RNGMachine(ProgrammeArray[2].getContentArray());
							else if (i == 7 || i == 13 || i == 14 || i == 27)
								Listing[i][y] = this.RNGMachine(ProgrammeArray[3].getContentArray());
							else if (i == 22 || i == 15 || i == 16 || i == 24)
								Listing[i][y] = this.RNGMachine(ProgrammeArray[4].getContentArray());
							else if (i == 1 || i == 4 || i == 5 || i == 17)
								Listing[i][y] = this.RNGMachine(ProgrammeArray[5].getContentArray());
							else Listing[i][y] = this.RNGMachine(ProgrammeArray[6].getContentArray());
						}
					}
				}
				// Writes the completed array to a file
				for (String[] strings : Listing) {
					for (int j = 0; j < strings.length; j++) {
						sOutFile.write(strings[j] + ((j == strings.length - 1) ? "," : ","));
					}
					sOutFile.newLine();

				}

			} else {

				Scanner sc = new Scanner(new File("src\\resources\\Programme_listing.txt"));
				sc.useDelimiter(",");
				for (int x = 0; x < Listing.length; x++) {
					for (int y = 0; y < Listing[x].length; y++) {
						if (sc.hasNext()) {
							String input = sc.next();
							Listing[x][y] = input;
						}
					}
					if (sc.hasNextLine()) {
						sc.nextLine();
					} else {
						break;
					}
				}
				sc.close();
				String compareTime = Listing[0][2];
				LocalTime now = LocalTime.now();
				LocalTime check = LocalTime.parse(compareTime);
				boolean change = now.isAfter(check);
				while(change){
					String tempTime = Listing[0][1];
					for(int x = 0; x < Listing.length; x++){
						for(int i = 1; i < Listing[x].length-1; i++){
							Listing[x][i] = Listing[x][i+1];
						}
						Listing[0][24] = tempTime;
						for(int j = 1; j < 29; j++){
							if (j == 2 || j == 9 || j == 10 || j == 21)
								Listing[j][24] = this.RNGMachine(ProgrammeArray[0].getContentArray());
							else if (j == 3 || j == 11 || j == 20 || j == 25)
								Listing[j][24] = this.RNGMachine(ProgrammeArray[1].getContentArray());
							else if (j == 18 || j == 23 || j == 12 || j == 28)
								Listing[j][24] = this.RNGMachine(ProgrammeArray[2].getContentArray());
							else if (j == 7 || j == 13 || j == 14 || j == 27)
								Listing[j][24] = this.RNGMachine(ProgrammeArray[3].getContentArray());
							else if (j == 22 || j == 15 || j == 16 || j == 24)
								Listing[j][24] = this.RNGMachine(ProgrammeArray[4].getContentArray());
							else if (j == 1 || j == 4 || j == 5 || j == 17)
								Listing[j][24] = this.RNGMachine(ProgrammeArray[5].getContentArray());
							else Listing[j][24] = this.RNGMachine(ProgrammeArray[6].getContentArray());
						}
					}
					now = LocalTime.now();
					check = LocalTime.parse(Listing[0][2]);
					change = now.isAfter(check);
				}
				sOutFile = new BufferedWriter(new FileWriter("src\\resources\\Programme_listing.txt"));
				for (String[] strings : Listing) {
					for (int j = 0; j < strings.length; j++) {
						sOutFile.write(strings[j] + ((j == strings.length - 1) ? "," : ","));
					}
					sOutFile.newLine();
				}
			}
			sOutFile.flush();
			sOutFile.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
