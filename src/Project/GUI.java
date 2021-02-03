package Project;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI extends JFrame {
    protected JPanel MainPanel;
    private JLabel Time;
    private JButton search;
    private JLabel Title;
    private JLabel Date;
    private JTable programmeListing;
    private JScrollPane MainTable;


    public GUI() {
        setSize(1000, 600);
        setTitle("JCTCL Cable TV Programme Listing");

        // Creates the file so that it is ready for JTable
        new ListingMake();

        // Allows the Search button to ask for category then directs to a class
        search.addActionListener(e -> {
            String[] values = {"Comedy", "General", "Gospel", "Kids", "Movies", "News", "Weather"};
            Object selected = JOptionPane.showInputDialog(null, "What category are you searching?", "Search", JOptionPane.DEFAULT_OPTION, null, values, 0);
            if (selected != null) {//null if the user cancels.
                String selectedString = selected.toString();
                //do something
                System.out.println(selectedString);
                if(!selectedString.equals("")) {
                    new Search(selectedString);
                }
            }
        });

        //Time and Date Function
        Timer timer;
        ActionListener DaT = e -> {
            //Shows current time
            Date date = new Date();
            DateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
            String time = timeFormat.format(date);
            Time.setText(time);

            //Shows today's date
            Date date1 = new Date();
            DateFormat timeFormat1 = new SimpleDateFormat("EEEE, dd MMMM, yyyy");
            String time1 = timeFormat1.format(date1);
            Date.setText(time1);
        };
        // Timer refreshes the Date and Time so that it always display the current Date and Time
        timer = new Timer(1000, DaT);
        timer.setInitialDelay(0);
        timer.start();

        // Reads the file made in ListingMake class and inserts said file into the JTable to be viewed
        Timer passOn;
        ActionListener Listing = e -> {
            String filePath = "src\\resources\\Programme_listing.txt";
            File file = new File(filePath);
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String firstLine = br.readLine().trim();
                String[] columnsName = firstLine.split(",");
                DefaultTableModel model = (DefaultTableModel)programmeListing.getModel();
                model.setColumnIdentifiers(columnsName);
                programmeListing.getTableHeader().setReorderingAllowed(false);
                programmeListing.getTableHeader().setResizingAllowed(false);

                // get lines from txt file
                Object[] tableLines = br.lines().toArray();

                // extract data from lines
                // set data to JTable model
                for (Object tableLine : tableLines) {
                    String line = tableLine.toString().trim();
                    String[] dataRow = line.split(",");
                    model.addRow(dataRow);
                }
                // Applies the row changes that were made to accommodate the row colors
                programmeListing.setDefaultRenderer(Object.class, new MonCellRenderer());
                br.close();
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, "!NULL FILE!", ex);
            }

        };
        passOn = new Timer(1000000000, Listing);
        passOn.setInitialDelay(0);
        passOn.start();


        // Creates an action for the Admin section that accepts a password the allows them to edit the file however they wish
        Action adminPass = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPasswordField ps = new JPasswordField();
                int pass = JOptionPane.showConfirmDialog(null, ps, "Enter Admin Password: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if(pass == JOptionPane.OK_OPTION){
                    // Takes the password to compare
                    String password = new String(ps.getPassword());
                    if (password.equals("Welcome1")){
                        System.out.println("Welcome Administrator");
                        String[] values = {"Comedy", "General", "Gospel", "Kids", "Movies", "News", "Weather"};
                        Object selected = JOptionPane.showInputDialog(null, "Welcome Administrator", "ADMIN MENU", JOptionPane.DEFAULT_OPTION, null, values, 0);
                        if (selected != null) {//null if the user cancels.
                            String selectedString = selected.toString();
                            new AdminAccess(selectedString);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Sorry Wrong Password, please try again", "WRONG PASSWORD", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        };
        // Creates an action to input the directory of the resource files to be accepted by the program
        Action giveDirectory = (new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField dir = new JTextField();
                int direct = JOptionPane.showConfirmDialog(null, dir,"Enter directory path to resources files: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if(direct == JOptionPane.OK_OPTION){
                    String directory = dir.getText();
                    Programme director = new Comedy();
                    director.setDirectory(directory);
                }
            }
        });

        // Keybinding the keys "S" and "F1" to the actions above
        MainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "pass");
        MainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "dir");

        MainPanel.getActionMap().put("pass", adminPass);
        MainPanel.getActionMap().put("dir", giveDirectory);
    }



    // Overriding a class to make it possible to implement color coded rows
    public static class MonCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);

            // Depending on the row a specific color will be the background with also a change in text color to make it more readable
            if (row == 1 || row == 8 || row == 9 || row == 20) {
                setBackground(Color.YELLOW);
                setForeground(Color.BLACK);
            } else if(row == 2 || row == 10 || row == 19 || row == 24 || row == 0 || row == 3 || row == 4 || row == 16) {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            } else if(row == 17 || row == 22 || row == 11 || row == 27){
                setBackground(Color.BLUE);
                setForeground(Color.WHITE);
            } else if(row == 6 || row == 12 || row == 13 || row == 26){
                setBackground(new Color(95, 3, 172));
                setForeground(Color.WHITE);
            } else if(row == 21 || row == 14 || row == 15 || row == 23) {
                setBackground(Color.RED);
                setForeground(Color.WHITE);
            } else{
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
            }
            return this;
        }
    }

}