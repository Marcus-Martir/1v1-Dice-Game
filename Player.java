import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity {
    private Scanner input;

    private boolean alive;
    private int points;

    public Player(int numberOfPowers) {
        this.entityType = "You";
        this.numberOfPowers = numberOfPowers;
    }

    public void goToStore() {

    }

    public void startMatchWith(Opponent vs) {
        // if (this.health <= 0);
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
        System.out.println("Your character looks like this:");
        System.out.println(this);
        System.out.print("If anything is wrong, you can set up your character again. Does everything look fine? Y/N : ");
        String yorn = this.input.nextLine();
        switch (yorn) {
            case "N":
                break;
            case "n":
                break;
            default:
                System.out.println("Okay! Setting up again...");
                setUp();
        }
        System.out.println("You have confirmed!");
    }

    public void closeInput() {
        this.input.close();
    }

}

