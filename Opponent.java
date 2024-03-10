public class Opponent extends Entity {
    private static String[] nameList = {"Dr. Dark", "Big J", "Lemo", "Peppo", "Mr. E", "Woet R.", "Dr. Pepper", "CoCo", "Ronald M.", "Johny Test"};
    private static String[] factionList = {"Sparkys", "Dark Souls", "Soul Stealers", "Blood Suckers", "Shadow Sneakers"};
    private static String[] powerList = {"Uppercut", "Cut", "Slice", "Zap", "Freeze", "Stun", "Blood Boil", ""};
    private static String[] superPowerList = {"Meteor Punch", "Lightning Strike", "Fragmentize", "Life Drain"};

    public Opponent() {
        this.entityType = "Against";
        this.setUp();
    }

    public void setUp() {
        this.numberOfPowers = (int) (Math.random() * 3) + 3;
        this.name = Opponent.nameList[(int) (Math.random() * Opponent.nameList.length)];
        this.faction = Opponent.factionList[(int) (Math.random() * Opponent.factionList.length)];
        for (int i = 0; i < this.numberOfPowers; i++) {
            int randI = (int) (Math.random() * Opponent.factionList.length);
            String adding = Opponent.powerList[randI];
            if (this.powers.contains(adding)) {
                i--;
                continue;
            }
            this.powers.add(adding);
        }
        this.superPower = Opponent.superPowerList[(int) (Math.random() * Opponent.superPowerList.length)];
        
    }
}
