public class Opponent extends Entity {
    public Opponent() {
        this.entityType = "Opponent";
        this.setUp();
    }

    public void setUp() {
        this.numberOfPowers = (int) (Math.random() * 3) + 3;
        
    }
}
