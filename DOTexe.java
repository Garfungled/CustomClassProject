public class DOTexe extends File {
    public DOTexe (String name) {
        super(name, ".exe");
    }

    public void run() {
        // Logic for an executable running system would go here
        System.out.println(this.getNameFull() + " has ran.");
    }
}