import java.util.ArrayList;

public class Entity {
    protected String name;
    protected String faction;
    protected ArrayList<String> powers;
    protected String superPower;
    protected int numberOfPowers;

    protected String entityType;

    protected int health;
    protected int attack;
    protected int defence;

    public Entity() {
        this.health = 100;
        this.powers = new ArrayList<String>();
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealth() {
        return this.health;
    }

    public void receiveDamage(int damage) {
        if (defence > damage) {
            health = 0;
            return;
        }
        health -= damage - defence;
    }
    
    public boolean alive() {
        return this.health > 0 ? true : false;
    }
    
    protected String stringifyPowers() {
        String toReturn = "";
        boolean addingNewline = false;
        for (int i = 0; i < this.numberOfPowers; i++) {
            addingNewline = i % 2 == 0 ? true : false;
            String power = powers.get(i);
            if (i+1 == this.numberOfPowers) {
                toReturn += addingNewline ? power + "\n\t" : power;
                break;
            }
            toReturn += addingNewline ? power + ",\n\t" : power + ", ";
        }
        return toReturn;
    }

    public String getInfoCard() {
        return "__________________________________________________" +
        "\n" + "                                                  " +
        "\n" + "   "+this.entityType+": "+this.name+"\t"+"Faction: "+this.faction  +
        "\n" + "   List of Powers: "+stringifyPowers()              +
        "\n" + "   Super Power: "+this.superPower                   +
        "\n" + "                                                  " +
        "\n" + "__________________________________________________" ;
    }

    public String toString() {
        return getInfoCard();
    }

    public String getStats() {
        return "";
    }

    public String getName() {
        return this.name;
    }
}
