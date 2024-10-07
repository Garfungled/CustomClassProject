import java.io.FileWriter; 
import java.util.Scanner;

public class DOTtxt extends File {
    private String lastLoadedContents;

    /*-------------------------Constructors---------------------------------*/
    public DOTtxt(String name) {
        super(name, ".txt");
    }

    /*-------------------------Actions---------------------------------*/
    public void write(String buffer) throws java.io.IOException {
        FileWriter fileWriter = new FileWriter(this.getDirectoryREAL());
        fileWriter.write((this.lastLoadedContents == "")? buffer : this.lastLoadedContents + "\n" + buffer);
        this.lastLoadedContents = buffer;
        fileWriter.close();
    }

    public String read() throws java.io.IOException {
        String contents = "";
        Scanner fileReader = new Scanner(new java.io.File(this.getDirectoryREAL()));
        while (fileReader.hasNextLine()) {
            contents += fileReader.nextLine() + "\n";
        }
        fileReader.close();
        return contents;
    }

    /*-------------------------Setters---------------------------------*/

    /*-------------------------Getters---------------------------------*/
}