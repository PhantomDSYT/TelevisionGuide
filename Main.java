/*
 2020 Object Oriented Programming Project

 Group Members with ID Numbers:
     Anelka Lopez - 1908764
     Ashanti Noble  - 1908766
     Obberlee Sutton - 1903478

 Lecturer: Ms. Nembhard
 Module: Object Oriented Programming

 This project's Graphical User Interface was heavily made using an GUI Builder
    with small usages of coded events for a more desired look and/or execution
*/
package Project;

import javax.swing.*;

public class Main extends GUI {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        final GUI output = new GUI();
        output.setContentPane(new GUI().MainPanel);
        output.setVisible(true);
        output.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }




}
