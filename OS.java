/*
    This is the "simulated OS" that the files will be built off.
*/

public class OS {
    private ROOT root;
    private String name;
    private String nameLogo; // use TDD.txt
    private String logo; // use https://www.asciiart.eu/image-to-ascii, intended to be 50x50

    /*-------------------------OS Config---------------------------------*/
    private String osFolderLocation; // The actual OS location within the users REAL computer, this is pretty meta
    private String colorTheme;
    private String osParent; // The OS that this OS is in (the actual OS that is running the code)
    private String cpu;
    private String gpu;

    public OS(ROOT root, String name) {
        // Makes logo a big warning sign
        this(root, name, "                                                    \n" + //
                        "    ,---,.                                          \n" + //
                        "  ,'  .' |                                          \n" + //
                        ",---.'   |   __  ,-.   __  ,-.    ,---.     __  ,-. \n" + //
                        "|   |   .' ,' ,'/ /| ,' ,'/ /|   '   ,'\\  ,' ,'/ /| \n" + //
                        ":   :  |-, '  | |' | '  | |' |  /   /   | '  | |' | \n" + //
                        ":   |  ;/| |  |   ,' |  |   ,' .   ; ,. : |  |   ,' \n" + //
                        "|   :   .' '  :  /   '  :  /   '   | |: : '  :  /   \n" + //
                        "|   |  |-, |  | '    |  | '    '   | .; : |  | '    \n" + //
                        "'   :  ;/| ;  : |    ;  : |    |   :    | ;  : |    \n" + //
                        "|   |    \\ |  , ;    |  , ;     \\   \\  /  |  , ;    \n" + //
                        "|   :   .'  ---'      ---'       `----'    ---'     \n" + //
                        "|   | ,'                                            \n" + //
                        "`----'                                              ", "                                                  \n");
    }

    public OS(ROOT root, String name, String nameLogo) {
        this(root, name, nameLogo, "  .+******************************************+.  \n" + " -**********************************************- \n" + " -******************-::::::::-******************- \n" + " -*************=                  =*************- \n" + " -**********+..    .--=+--=+--.    ..=**********- \n" + " -********+:     +****=   .=****+     .+********- \n" + " -*******-.   -*******+:  -********-.  .:*******- \n" + " -******:.  :*********=   :+*********:   :******- \n" + " -*****+  .:**********=    .+*********:.  +*****- \n" + " -****+.  .***********-    :***********:  .+****- \n" + " -****:   +***********.    =***********+   :****- \n" + " -****:  =************:    =************=  :****- \n" + " -****:  =************+:   =************+  :****- \n" + " -****:  =************+.  :+************=  :****- \n" + " -****:   +***********=.  .=***********+   :****- \n" + " -****+.  .****************************:  .+****- \n" + " -*****+  .:**********=. .-***********:.  +*****- \n" + " -******:.  :*********.    =*********:   :******- \n" + " -*******:.   -*******+:.:+********-.  .:*******- \n" + " -********+.     +**************+     .+********- \n" + " -**********+.     .-=+****+=-.     .=**********- \n" + " -*************=                  =*************- \n" + " -*****************+-::::::::-+*****************- \n" + " -**********************************************- \n" + "  .+******************************************+.  \n" + "                                                  \n");
    }

    public OS(ROOT root, String name, String nameLogo, String logo) {
        this(root, name, nameLogo, logo, "default");
    }

    public OS(ROOT root, String name, String nameLogo, String logo, String colorTheme) {
        this(root, name, nameLogo, logo, System.getProperty("user.dir"), colorTheme);
    }

    public OS(ROOT root, String name, String nameLogo, String logo, String osFolderLocation, String colorTheme) {
        this(root, name, nameLogo, logo, osFolderLocation, colorTheme, "macOS", "Apple M3 Pro", "Apple M3 Pro");
    }

    public OS(ROOT root, String name, String nameLogo, String logo, String osFolderLocation, String colorTheme, String osParent, String cpu, String gpu) {
        this.root = root;
        this.name = name;
        this.nameLogo = nameLogo;
        this.logo = logo;
        this.osFolderLocation = osFolderLocation;
        this.colorTheme = colorTheme;
        this.osParent = osParent;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public String toString() {
        return "Finding OS........\nFound " + this.name + "........\n\n\n" + this.logo + this.nameLogo + "\n\n\nLoading File System........\nROOT File System Found........\nPrinting NERDTree........\n\n\n" + this.root.NERDTree();
    }
}