package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Programme {
    protected String Directory;
    protected boolean closedCaption;
    protected boolean newProgramme;
    protected boolean repeat;
    protected boolean live;
    protected boolean viewLater;
    protected boolean recorded;
    protected boolean watchNow;
    protected String Misc = "";
    protected String time = "";
    protected String rating = "";
    protected String release = "";

    Programme(){
        Directory = "src\\resources\\";
        closedCaption = false;
        newProgramme = false;
        repeat = false;
        live = false;
        viewLater = false;
        recorded  = false;
        watchNow = false;
    }
    public void viewToggle(){
        if(viewLater)
            viewLater = false;
        else
            viewLater = true;
    }
    public void recToggle(){
        if(recorded)
            recorded = false;
        else
            recorded = true;
    }
    public void watchToggle(){
        if(watchNow)
            watchNow = false;
        else
            watchNow = true;
    }

    public void setDirectory(String directory) {
        Directory = directory;
    }

    public int numOfLines(File file){
        int lines = 0;
        try {
            Scanner sInFile = new Scanner(file);
            while(sInFile.hasNextLine()){
                sInFile.nextLine();
                lines++;
            }
        }catch (FileNotFoundException e){
            System.out.println("ERROR:- FILE NOT FOUND!");
        }

        return lines;
    }

    abstract public String[] getContentArray();

    abstract public void Retriever(String Codename);

    abstract  public String FilePath();
}