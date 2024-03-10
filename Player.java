import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity {
    private Scanner input;
    private int points;

    public Player(int numberOfPowers) {
        this.entityType = "You";
        this.points = 0;
        this.numberOfPowers = numberOfPowers;
    }

    public void goToStore() {
        System.out.println("Went to store!");
    }

    public void startMatchWith(Opponent opponent) {
        System.out.println("=====================================");
        System.out.println("            MATCH STARTING           ");
        System.out.println("=====================================");

        System.out.println(opponent);
        System.out.println("^^This is your opponent^^");

        while (true) {
            System.out.print("--- Press enter to roll the dice ---");
            this.input.nextLine();
            int index = (int) (Math.random() * this.numberOfPowers);
            String power = this.powers.get(index);
            System.out.println("You rolled a " + (index+1) + ", which corresponds to your power \"" + power + "\"");
            System.out.print("--- Press enter to roll for attack ---");
            this.input.nextLine();
            int attack = (int) (Math.random() * 4) + 3;
            if (index == attack) {
                System.out.println("You rolled a " + attack + ", which is the same number you rolled before!");
                System.out.println("You will attack with your super power!");
                attack = 70;
            } else {
                System.out.println("You rolled a " + attack + ", so you will attack with that much.");
            }
            System.out.print("--- Press enter for your opponent to roll ---");
            this.input.nextLine();
            int opponentRoll = (int) (Math.random() * 6);
            opponent.setDefence(opponentRoll);
            System.out.println("Your opponent rolled a " + opponentRoll + ", so that will be their defense...");
            System.out.println("\nATTACK!!!\n");
            if (index == attack) {
                System.out.println("You used your super power, " + this.superPower + " against " + opponent.getName());

            } else {
                System.out.println("You used " + power + " against " + opponent.getName());
            }
            opponent.receiveDamage(attack);
            System.out.println(opponent.getName() + " now has " + (opponent.getHealth() > 0 ? opponent.getHealth() : 0) + " health");
            if (!opponent.alive()) {
                break;
            }
            System.out.print("--- Press enter to ensue opponent's turn ---");
            this.input.nextLine();
            int oppIndex = (int) (Math.random() * opponent.numberOfPowers);
            String oppPower = opponent.powers.get(oppIndex);
            int oppAttack = (int) (Math.random() * 4) + 3;
            if (oppIndex == oppAttack) {
                System.out.println("Your opponent rolled doubles!! Which means they'll get to use their super power...");
                oppAttack = 70;
            } else {
                System.out.println("Your opponent rolled. And will use \""+ oppPower + "\"" + " with " + oppAttack + " attack power...");
            }
            System.out.print("--- Press enter to roll for your defense ---");
            this.input.nextLine();
            int userDefence = (int) (Math.random() * 6);
            this.setDefence(userDefence);
            System.out.println("You rolled a " + userDefence + " for defense.");

            System.out.println("\nDEFEND!!!\n");
            this.receiveDamage(oppAttack);
            if (oppIndex == oppAttack) {
                System.out.println(opponent.getName() + " used " + opponent.superPower + " and now you are left with " + (this.health > 0 ? this.health : 0) + " health");
            } else {
                System.out.println(opponent.getName() + " used " + oppPower + " and now you are left with " + (this.health > 0 ? this.health : 0) + " health");
            }
            if (!this.alive()) {
                break;
            }
            
        }

    }

    public void setUp() {
        System.out.print("What will be the name of your character? ");
        this.input = new Scanner(System.in);
        this.name = this.input.nextLine();
        System.out.print("What faction are you in? ");
        this.faction = this.input.nextLine();
        System.out.println("Enter your " + this.numberOfPowers + " powers:");
        this.powers = new ArrayList<String>();

        for (int i = 1; i <= this.numberOfPowers; i++) {
            System.out.print(i + ". ");
            this.powers.add(this.input.nextLine());
        }

        System.out.print("Add your super power name: ");
        this.superPower = this.input.nextLine();
    }

    public void confirm() {
        System.out.println(this);
        System.out.println("^^Your character looks like this^^");
        System.out.print("If anything is wrong, you can set up your character again. Does everything look fine? Y/N : ");
        String yorn = this.input.nextLine();
        switch (yorn.toUpperCase()) {
            case "Y":
                break;
            case "YES":
                break;
            default:
                System.out.println("Okay! Setting up again...");
                setUp();
        }
        System.out.println("Ready to move on to your first match?");
        System.out.println("---Press enter to continue---");
        this.input.nextLine();
    }

    public void closeInput() {
        this.input.close();
    }

    public void addPoints(int amount) {
        this.points += amount;
    }

}

