import java.util.Random;
public class Hero {
    private String name;
    private int hitpoints;

    public Hero(String a) {
        name = a;
        hitpoints = 100;
    }
    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitpoints;
    }

    public String toString(){
        return "Hero{name='" + name + "', hitPoints="+ hitpoints+ "}";
    }

    public void attack(Hero opponent) {
        double random = Math.random();
        if (random < 0.5) {
            opponent.hitpoints = opponent.hitpoints - 10;
        }
        else {
            hitpoints = hitpoints-10;
        }
    }

    public void senzuBean(){
        hitpoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (hitpoints>0 && opponent.hitpoints>0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitpoints + "\t" + opponent.name + ": " + opponent.hitpoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int wins = 0;
        int losses = 0;
        while (n>0) {
            senzuBean();
            fightUntilTheDeathHelper(opponent);
            if (hitpoints==0) {
                losses++;
            }
            else {
                wins++;
            }
            n--;
        }
        return new int[]{wins, losses};
    }
    public String nFightsToTheDeath(Hero opponent, int n) {
        String s = "";
        int[] array = nFightsToTheDeathHelper(opponent, n);
        if (array[0] > array[1]) {
            s = "Andrew Tate wins!";
        } else if (array[1] > array[0]) {
            s = "Taylor Swift wins!";
        } else {
            s = "OMG! It was actually a draw!";
        }
        return "Andrew Tate: " + array[0] + " wins" + "\n" + "Taylor Swift: " + array[1] + " wins" + "\n" + s;
    }

    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        System.out.println("Andrew Tate: " + hitpoints + "\t" + "Taylor Swift: " + opponent.hitpoints);
        Thread.sleep(1000);
    }
}
