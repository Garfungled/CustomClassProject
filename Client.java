public class Client {
    public static void main(String[] args) throws java.io.IOException {
        ROOT root = new ROOT("garf");

        Folder DIR = root.getSubfolder1().getSubfolder2();
        DIR.addSubfile(new DOTtxt("text"));
        DIR.getSubfile1().write("Hello World 1");
        DIR.getSubfile1().write("Hello World 2");
        System.out.println(DIR.getSubfile1().read());

        System.out.println(root.NERDTree());
    }
}