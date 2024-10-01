public class Folder {
    // Public so that all other codes know what character to use
    private static String folderIcon = "-> ";

    private String name; // Name of Folder

    private int key; // Key for folder (e.x. 122, is folder 2, inside folder 2, inside folder 1). key of 1 indicates ROOT, it's also the default key.

    private boolean isHidden; // If folder should be hidden (i.e. shows up in NERDTree)

    private Folder parent; // Parent folder, making 'this' the subfolder of parent
    private Folder subfolder1; // Subfolders
    private Folder subfolder2;
    private Folder subfolder3;

    private File subfile1; // Subfiles
    private File subfile2;
    private File subfile3;

    /*-------------------------Constructors---------------------------------*/
    public Folder(String name) {
        this(null, name, 1);
        this.setParent(this);
    }

    public Folder(Folder parent, String name, int key) {
        this(parent, name, key, null, null, null);
    }

    public Folder(Folder parent, String name, int key, Folder subfolder1, Folder subfolder2, Folder subfolder3) {
        this(parent, name, key, subfolder1, subfolder2, subfolder3, null, null, null);
    }

    public Folder(Folder parent, String name, int key, Folder subfolder1, Folder subfolder2, Folder subfolder3, File subfile1, File subfile2, File subfile3) {
        this.parent = parent;
        this.name = name;
        this.key = key;

        this.addSubfolder1(subfolder1);
        this.addSubfolder2(subfolder2);
        this.addSubfolder3(subfolder3);

        this.subfile1 = subfile1;
        this.subfile2 = subfile2;
        this.subfile3 = subfile3;

        if (this.parent != null) {
            String parentString = this.parent.toString();
            new java.io.File(this.getDirectoryREAL()).mkdir();
        }
    }

    /*-------------------------Basic Class Functions---------------------------------*/
    public String toString() {
        if (this.parent == this) {return this.name;}
        return parent.toString() + "/" + this.name;
    }

    // Technically the same thing as toString, but another function to make it clear
    public String getDirectory() {
        return this.toString();
    }

    // The real directory within the users OS
    public String getDirectoryREAL() {
        return System.getProperty("user.dir") + "/" + this.getDirectory();
    }


    /*-------------------------Actions---------------------------------*/

    // Names after the vim plugin
    public String NERDTree() {
        return this.NERDTree(1);
    }

    public String NERDTree(int depth) {
        // Teneray operators to avoid nullpointer
        // If subfolder is null send "", there is nothing inside
        // Recrusive call to print out all the contents of each subfolder
        String folder1 = this.subfolder1 == null? "" : "\n" + "\t".repeat(depth) + Folder.folderIcon + this.subfolder1.NERDTree(depth + 1);
        String folder2 = this.subfolder2 == null? "" : "\n" + "\t".repeat(depth) + Folder.folderIcon + this.subfolder2.NERDTree(depth + 1);
        String folder3 = this.subfolder3 == null? "" : "\n" + "\t".repeat(depth) + Folder.folderIcon + this.subfolder3.NERDTree(depth + 1);

        String file1 = this.subfile1 == null? "" : "\n" + "\t".repeat(depth) + File.getFileIcon() + this.subfile1.getNameFull();
        String file2 = this.subfile2 == null? "" : "\n" + "\t".repeat(depth) + File.getFileIcon() + this.subfile2.getNameFull();
        String file3 = this.subfile3 == null? "" : "\n" + "\t".repeat(depth) + File.getFileIcon() + this.subfile3.getNameFull();

        // .replace is used to make \t only two spaces, "  "
        return (this.name + folder1 + folder2 + folder3 + file1 + file2 + file3).replace("\t", "  ");
    }

    public boolean addSubfile1(File subfile) throws java.io.IOException {
        if(this.subfile1 != null) {return false;}
        if(subfile == null) {return true;}
        // Can't have the same name as any other file in 'this'
        this.setFolderFileName(subfile);
        subfile.setParent(this);
        this.subfile1 = subfile;
        java.io.File newFile = new java.io.File(this.subfile1.getDirectoryREAL());
        System.out.println(this.subfile1.getDirectoryREAL());
        newFile.createNewFile();

        return true;
    }

    public boolean addSubfile2(File subfile) throws java.io.IOException {
        if(this.subfile2 != null) {return false;}
        if(subfile == null) {return true;}
        this.setFolderFileName(subfile);
        subfile.setParent(this);
        this.subfile2 = subfile;
        java.io.File newFile = new java.io.File(this.subfile2.getDirectoryREAL());
        newFile.createNewFile();
        
        return true;
    }

    public boolean addSubfile3(File subfile) throws java.io.IOException{
        if(this.subfile3 != null) {return false;}
        if(subfile == null) {return true;}
        this.setFolderFileName(subfile);
        subfile.setParent(this);
        this.subfile3 = subfile;
        java.io.File newFile = new java.io.File(this.subfile3.getDirectoryREAL());
        newFile.createNewFile();
        
        return true;
    }

    public boolean addSubfile(File subfile, int slot) throws java.io.IOException {
        if (slot == 1) {
            return this.addSubfile1(subfile);
        } else if (slot == 2) {
            return this.addSubfile2(subfile);
        } else if (slot == 3) {
            return this.addSubfile3(subfile);
        }

        return false;
    }

    public boolean addSubfile(File subfile) throws java.io.IOException {
        if (this.addSubfile(subfile, 1)){
            return true;
        } else if (this.addSubfile(subfile, 2)) {
            return true;
        } else if (this.addSubfile(subfile, 3)) {
            return true;
        }

        return false;
    }

    public boolean addSubfile(String name, String fileExtension) throws java.io.IOException {
        return this.addSubfile(new File(name, fileExtension));
    }

    public boolean addSubfolder1(Folder subfolder) {
        if(this.subfolder1 != null) {return false;}
        if(subfolder == null) {return true;}

        subfolder.parent = this;
        subfolder.key = this.key*10 + 1;
        this.subfolder1 = subfolder;
        new java.io.File(System.getProperty("user.dir") + "/" + this.subfolder1.toString()).mkdir();

        return true;
    }

    public boolean addSubfolder2(Folder subfolder) {
        if(this.subfolder2 != null) {return false;}
        if(subfolder == null) {return true;}

        subfolder.parent = this;
        subfolder.key = this.key*10 + 2;
        this.subfolder2 = subfolder;
        new java.io.File(System.getProperty("user.dir") + "/" + this.subfolder2.toString()).mkdir();

        return true;
    }

    public boolean addSubfolder3(Folder subfolder) {
        if(this.subfolder3 != null) {return false;}
        if(subfolder == null) {return true;}

        subfolder.parent = this;
        subfolder.key = this.key*10 + 3;
        this.subfolder3 = subfolder;
        new java.io.File(System.getProperty("user.dir") + "/" + this.subfolder3.toString()).mkdir();

        return true;
    }

    public boolean addSubfolder(Folder subfolder, int slot) {
        if (slot == 1) {
            return addSubfolder1(subfolder);
        } else if (slot == 2) {
            return addSubfolder2(subfolder);
        } else if (slot == 3) {
            return addSubfolder3(subfolder);
        }

        return false;
    }

    public boolean addSubFolder(Folder subfolder) {
        if (this.subfolder1 == null) {
            return addSubfolder1(subfolder);
        } else if (this.subfolder2 == null) {
            return addSubfolder2(subfolder);
        } else if (this.subfolder3 == null) {
            return addSubfolder3(subfolder);
        }

        return false;
    }

    public boolean addSubFolder(String name) {
        Folder folderBuffer = new Folder(name);
        return addSubFolder(folderBuffer);
    }

    public void setFolderFileName(File inputFile) {
        inputFile.nameSetFromOther(this.subfile1);
        inputFile.nameSetFromOther(this.subfile2);
        inputFile.nameSetFromOther(this.subfile3);
    }

    /*-------------------------Checkers---------------------------------*/
    public boolean isSameFolder(Folder other) {
        if(other == null) {return false;}

        return this.getKey() == other.getKey();
    }

    /*-------------------------Setters---------------------------------*/
    public void setKey(int key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    /*-------------------------Getters---------------------------------*/
    public String getName() {
        return this.name;
    }

    public int getKey() {
        return this.key;
    }

    public boolean getHidden() {
        return this.isHidden;
    }

    public Folder getParent() {
        return this.parent;
    }

    public Folder getSubfolder1() {
        return this.subfolder1;
    }

    public Folder getSubfolder2() {
        return this.subfolder2;
    }

    public Folder getSubfolder3() {
        return this.subfolder3;
    }

    public File getSubfile1() {
        return this.subfile1;
    }

    public File getSubfile2() {
        return this.subfile2;
    }

    public File getSubfile3() {
        return this.subfile3;
    }

    public static String getFolderIcon() {
        return Folder.folderIcon;
    }
}