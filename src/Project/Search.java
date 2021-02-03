package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search extends JDialog {
    private JPanel searchPanel;
    private JLabel Cat;
    private JLabel Category;
    private JButton outputButton;
    private JList showList;

    Search(String Cate){

        Category.setText(Cate);
        setVisible(true);
        setSize(600, 600);
        setContentPane(searchPanel);
        setTitle("Programme Search");
        setAlwaysOnTop(true);
        setResizable(false);


        String[] arrayOutput = new String[10];
        int whichArray = 9;

        Programme[] ProgrammeArray = new Programme[7];
        ProgrammeArray[0] = new Comedy();
        ProgrammeArray[1] = new General();
        ProgrammeArray[2] = new Gospel();
        ProgrammeArray[3] = new Kids();
        ProgrammeArray[4] = new Movies();
        ProgrammeArray[5] = new News();
        ProgrammeArray[6] = new Weather();

        switch(Cate){
            case "Comedy":
                whichArray = 0;
                arrayOutput = ProgrammeArray[whichArray].getContentArray();
                break;

            case "General":
                whichArray = 1;
                arrayOutput = ProgrammeArray[whichArray].getContentArray();
                break;

            case "Gospel":
                whichArray = 2;
                arrayOutput = ProgrammeArray[whichArray].getContentArray();
                break;

            case "Kids":
                whichArray = 3;
                arrayOutput = ProgrammeArray[whichArray].getContentArray();
                break;

            case "Movies":
                whichArray = 4;
                arrayOutput = ProgrammeArray[whichArray].getContentArray();
                break;

            case "News":
                whichArray = 5;
                arrayOutput = ProgrammeArray[whichArray].getContentArray();
                break;

            case "Weather":
                whichArray = 6;
                arrayOutput = ProgrammeArray[whichArray].getContentArray();
                break;
        }

        showList.setListData(arrayOutput);
        showList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        showList.setLayoutOrientation(JList.VERTICAL_WRAP);
        showList.setVisibleRowCount(-1);

        int finalWhichArray = whichArray;
        outputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showList.getSelectedValue() == null){
                    JOptionPane.showMessageDialog(searchPanel,"Please select a title or close the window", "INVALID SELECTION", JOptionPane.ERROR_MESSAGE);
                }else {
                    String selected = showList.getSelectedValue().toString();
                    ProgrammeArray[finalWhichArray].Retriever(selected);
                    dispose();
                }
            }
        });
    }

}
