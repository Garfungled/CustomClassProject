public class File {
    // Public so that all other codes know what character to use
    private static String fileIcon = "- ";

    private Folder parent;

    private String name;
    private String fileExtension; // such as ".c", ".java", etc
    private String description;

    private double size;

    /*-------------------------Constructors---------------------------------*/
    public File() {
        this("");
    }

    public File(String fileExtension) {
        this("Untitled", fileExtension);
    }

    public File(String name, String fileExtension) {
        this(null, name, fileExtension, "");
    }

    public File(String name, String fileExtension, String description) {
        this(null, name, fileExtension, description);
    }

    public File(Folder parent, String name, String fileExtension, String description) {
        this(parent, name, fileExtension, 0.0, description);
    }

    public File(Folder parent, String name, String fileExtension, double size, String description) {
        this.parent = parent;
        this.name = name;
        this.fileExtension = fileExtension;
        this.size = size;
        this.description = description;
    }

    /*-------------------------Actions---------------------------------*/
    public void write(String buffer) throws java.io.IOException {}
    public String read() throws java.io.IOException  {return "";}

    /*-------------------------Basic Class Functions---------------------------------*/
    public String toString() {
        return parent.toString() + "/" + this.name + this.fileExtension;
    }

    // Technically the same thing as toString but added just for clarity
    public String getDirectory() {
        return this.toString();
    }

    // The actual directory within the users OS
    public String getDirectoryREAL() {
        return this.parent.getDirectoryREAL() + "/" + this.getNameFull();
    }

    public String properties() {
        return "File name: " + this.name + ", File Extension: " + this.fileExtension.substring(1).toUpperCase() + ", File Size: " + this.size;
    }

    // Explain what this does here since name isn't very intuitive
    public void nameSetFromOther(File other) {
        if(other == null) {return;}
        if(this.getName() != other.getName()) {return;}

        this.setName(other.getName() + "(1)");
    }

    /*-------------------------Setters---------------------------------*/
    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /*-------------------------Getters---------------------------------*/
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    // Name plus fileExtension -> e.x. "pwd.exe"
    public String getNameFull() {
        return this.name + this.fileExtension;
    }

    public Folder getParent() {
        return this.parent;
    }

    public double getSize() {
        return this.size;
    }

    public static String getFileIcon() {
        return File.fileIcon;
    }
}