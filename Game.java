public class Game {
    private Player p1;

    public void start() {
        this.p1 = new Player(8);
        p1.setUp();
        p1.confirm();
        int match = 0;
        while (true) { // game loop
            p1.startMatchWith(new Opponent());
            if (!p1.alive()) {
                break;
            }
            match++;
            if (match % 3 == 0) {
                p1.goToStore();
            }
        }
        System.out.println("You have been killed!! :< ");
        p1.closeInput();
    }
}
