

public class DOTtxt extends File {
    private String contents;

    /*-------------------------Constructors---------------------------------*/
    public DOTtxt(String name) {
        super(name, ".txt");
    }

    /*-------------------------Actions---------------------------------*/
    public void write(String buffer) {
        // Logic for a file writing system would go here
        
    }

    public String read() {
        return this.contents;
    }

    /*-------------------------Setters---------------------------------*/

    /*-------------------------Getters---------------------------------*/
}