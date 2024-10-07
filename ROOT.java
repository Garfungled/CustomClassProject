public class ROOT extends Folder {

    /*-------------------------Constructors---------------------------------*/
    public ROOT(String usrname) throws java.io.IOException {
        // Subject to change
        super("ROOT");
        new java.io.File(System.getProperty("user.dir") + "/ROOT").mkdir();

        Folder usr = new Folder(usrname);
        Folder bin = new Folder("bin");
        Folder trash = new Folder("trash");

        this.addSubfolder1(usr);
        this.addSubfolder2(bin);
        this.addSubfolder3(trash);

        // usr folders/files
        this.getSubfolder1().addSubFolder("Desktop");
        this.getSubfolder1().addSubFolder("Documents");
        this.getSubfolder1().addSubFolder("Applications");

        // bin folders/files
        this.getSubfolder2().addSubfile(new DOTexe("pwd"));
        this.getSubfolder2().addSubfile(new DOTexe("ls"));
        this.getSubfolder2().addSubfile(new DOTexe("cd"));

        // trash folders/files
    }

    /*-------------------------Basic Class Functions---------------------------------*/
}
