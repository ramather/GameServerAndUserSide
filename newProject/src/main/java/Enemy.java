import java.util.Random;

public class Enemy {
    private String[] enemies = {"Skeleton", "Zombie", "Warrior", "Necromancer"};
    private int maxEnemyHealth = 75;
    private int enemyAttackDamage = 25;
    private int enemyHealth;
    private String name;

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public Enemy(){
        Random rand = new Random();
        name = enemies[rand.nextInt(enemies.length)];
        enemyHealth = rand.nextInt(maxEnemyHealth);

    }
    public String getName() {
        return name;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }
}
