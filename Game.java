public class Game {
    private Player p1;

    public void start() {
        int how_many_powers_for_user = 4;
        this.p1 = new Player(how_many_powers_for_user);
        p1.setUp();
        p1.confirm();
        int match = 0;
        while (true) { // game loop
            p1.startMatchWith(new Opponent());
            if (!p1.alive()) {
                break;
            }
            System.out.println("You won!!!");
            match++;
            if (match % 3 == 0) {
                p1.goToStore();
            }
        }
        System.out.println("You have been killed!! :<  Sorry, but that's game over...");
        p1.closeInput();
    }
}
