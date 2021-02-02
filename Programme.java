package Project;

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
        Directory = "C:\\Users\\anlka\\Documents\\OOP Class\\Project\\2020 OOP Project\\src\\resources\\";
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

    abstract public String[] getContentArray();

    abstract public void Retriever(String Codename);

    abstract  public String FilePath();
}