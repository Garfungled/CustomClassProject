public class Client {
    public static void main(String[] args) throws java.io.IOException {
        ROOT root = new ROOT("garf");

        Folder DIR = root;

        DIR = DIR.getSubfolder1();

        System.out.println(root.NERDTree());
    }
}