package player;

import java.util.Random;

import types.EnemyType;
import util.Description;

public class Enemy implements Descriptable {

    private static int globalID;
    private int id;
    private int damage;
    private int health;
    private EnemyType type;
    private boolean dead;

    public Enemy(int health, int damage) {
        this.id = globalID++;
        this.health = health;
        this.damage = damage;
        this.type = EnemyType.randomType();

    }

    public void damage(int amount) {
        this.health -= amount;
        this.checkDeath();
    }

    public boolean isDead() {
        return this.dead;
    }

    private void checkDeath() {
        if (this.health <= 0) {
            this.dead = true;
        }
    }

    public String getDescription() {
        return this.type.toDescription();
    }

    public Description getDescriptionText() {
        String[] adjectives = {"hairy", "tall", "short", "nice", "strong", "deformed", "thin", "fat", "weak",
                "stupid", "chaser", "giver"};
        Random r = new Random();
        Description description = new Description("enemy");
        description.name = getDescription();
        description.text = "It is a " + adjectives[r.nextInt(adjectives.length)] + " " + description.name;
        return description;
    }

}
