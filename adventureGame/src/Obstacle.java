import java.util.Random;

public class Obstacle {
    private String name;
    private int damage;
    private int award;
    private int health;
    private int maxNumber;

    Obstacle(String name, int damage, int award, int health, int maxNumber){
        this.setName(name);
        this.setDamage(damage);
        this.setAward(award);
        this.setHealth(health);
        this.setMaxNumber(maxNumber);
    }

    public int obstacleCount(){
        Random random = new Random();
        return random.nextInt(this.maxNumber) + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
