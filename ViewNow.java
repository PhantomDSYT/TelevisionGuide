package Project;

import javax.swing.*;

public class ViewNow extends JDialog{
    private JPanel viewPanel;
    private JLabel Title;
    private JLabel Misc;
    private JLabel Time;
    private JLabel titleAtri;
    private JLabel MiscAtri;
    private JLabel timeAtri;
    private JButton exit;
    private JLabel Release;
    private JLabel rating;
    private JLabel ratingAtri;
    private JLabel releaseAtri;

    ViewNow(int cat, String title, String misc,String duration){

        setVisible(true);
        setSize(1280, 720);
        setContentPane(viewPanel);
        setTitle("Viewing Now - " + title);
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Sets all labels to false to avoid output that is unintended
        Misc.setVisible(false);
        MiscAtri.setVisible(false);
        ratingAtri.setVisible(false);
        releaseAtri.setVisible(false);

        // Makes the Exit button closes the window
        exit.addActionListener(e -> dispose());

        // Depending on Category specific Labels will be visible along with information
        switch(cat){
            case 0:
                Misc.setVisible(true);
                MiscAtri.setVisible(true);
                Title.setText("Title: ");
                Misc.setText("Actors: ");
                Time.setText("Length: ");
                titleAtri.setText(title);
                MiscAtri.setText(misc);
                timeAtri.setText(duration);
                break;

            case 1: Title.setText("Title: ");
                Time.setText("Time: ");
                timeAtri.setText(title);
                timeAtri.setText(duration);
                break;

            case 2:
                    Misc.setVisible(true);
                    MiscAtri.setVisible(true);
                    Title.setText("Denomination: ");
                    Misc.setText("Title: ");
                    Time.setText("Time: ");
                    titleAtri.setText(title);
                    MiscAtri.setText(misc);
                    timeAtri.setText(duration);
                break;

            case 3:
                Misc.setVisible(true);
                MiscAtri.setVisible(true);
                Title.setText("Episode: ");
                Misc.setText("Age Range: ");
                Time.setText("Length: ");
                titleAtri.setText(title);
                MiscAtri.setText(misc);
                timeAtri.setText(duration);
                break;

            case 5: Title.setText("Title: ");
                Time.setText("Period: ");
                titleAtri.setText(title);
                timeAtri.setText(duration);
                break;

            case 6: Misc.setVisible(true);
                MiscAtri.setVisible(true);
                Title.setText("Title: ");
                Misc.setText("Severity Rating: ");
                Time.setText("Length: ");
                titleAtri.setText(title);
                MiscAtri.setText(misc);
                timeAtri.setText(duration);
                break;
        }
    }
    // Separate overloaded method for movies because it has more attributes
    ViewNow(String title, String actors, String Rating, String Length, String ReleaseDate){
        setVisible(true);
        setSize(1280, 720);
        setContentPane(viewPanel);
        setTitle("Viewing Now - " + title);
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        Misc.setVisible(true);
        MiscAtri.setVisible(true);
        Release.setVisible(true);
        rating.setVisible(true);
        ratingAtri.setVisible(true);
        releaseAtri.setVisible(true);

        exit.addActionListener(e -> dispose());

        Title.setText("Title: ");
        Misc.setText("Actors: ");
        rating.setText("Rating: ");
        Time.setText("Length: ");
        Release.setText("Release Date: ");
        titleAtri.setText(title);
        MiscAtri.setText(actors);
        ratingAtri.setText(Rating);
        timeAtri.setText(Length);
        releaseAtri.setText(ReleaseDate);


    }

}
