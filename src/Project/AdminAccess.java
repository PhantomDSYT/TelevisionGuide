package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class AdminAccess extends JDialog{
    private JLabel Line1;
    private JLabel Line2;
    private JTextArea FileDisplay;
    private JButton saveButton;
    private JScrollPane ScrollFile;
    private JPanel AdminPanel;
    private JLabel Format;

    AdminAccess(String Category){
        // Setting made to properly display frame
        setVisible(true);
        setSize(1000, 600);
        setContentPane(AdminPanel);
        setTitle("Programme Search");
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        FileDisplay.setSize(500,400);
        Line1.setText("Currently viewing " + Category + " file");
        Line2.setText("Please separate each type of information using comma (',')");

        Programme[] ProgrammeArray = new Programme[7];
        ProgrammeArray[0] = new Comedy();
        ProgrammeArray[1] = new General();
        ProgrammeArray[2] = new Gospel();
        ProgrammeArray[3] = new Kids();
        ProgrammeArray[4] = new Movies();
        ProgrammeArray[5] = new News();
        ProgrammeArray[6] = new Weather();

        int whichArray = 10;
        ArrayList<String> ContentList = new ArrayList<>();

        // Case statement to display proper format texts depending on category
        switch(Category){
            case "Comedy":
                whichArray = 0;
                Format.setText("FORMAT: Title, Actor1/Actor2/etc, Length");
                break;

            case "General":
                whichArray = 1;
                Format.setText("FORMAT: Title, Length");
                break;

            case "Gospel":
                whichArray = 2;
                Format.setText("FORMAT: Title, Denomination, Length");
                break;

            case "Kids":
                whichArray = 3;
                Format.setText("FORMAT: Title, Age Range, Length");
                break;

            case "Movies":
                whichArray = 4;
                Format.setText("FORMAT: Title, Actor1/Actor2/etc, Rating, Length, Release Date");
                break;

            case "News":
                whichArray = 5;
                Format.setText("FORMAT: Title, Length");
                break;

            case "Weather":
                whichArray = 6;
                Format.setText("FORMAT: Title, Severity Rating, Length");
                break;
        }

        // Read for text file then writes it all into an editable JTextArea for Admin changes
        String file = ProgrammeArray[whichArray].FilePath();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                ContentList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR:- FILE NOT FOUND");
        } catch (IOException i){
            System.out.println("ERROR:- CANNOT READ FILE");
        }
        for(String text : ContentList){
            FileDisplay.append(text + "\n");
        }

        // Save button, writes the changes in the JTextArea into the original files then displays a message when complete
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] lines = FileDisplay.getText().split("\\n");
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                    for(String line : lines){
                        writer.write(line + "\n");
                    }
                } catch (IOException ioException) {
                    System.out.println("ERROR:- CANNOT WRITE TO FILE");;
                }
                JOptionPane.showMessageDialog(AdminPanel,"File Saved", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }
}
