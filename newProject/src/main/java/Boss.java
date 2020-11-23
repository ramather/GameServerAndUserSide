public class Boss extends Enemy {
    private int EnemyHealth = 250;
    private int enemyAttackDamage = 100;
    private String name;

    public Boss(){
        name = "Almighty Frieza";
    }

    @Override
    public int getEnemyHealth() {
        return EnemyHealth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    @Override
    public int getMaxEnemyHealth() {
        return super.getMaxEnemyHealth();
    }

    @Override
    public void setEnemyHealth(int enemyHealth) {
        EnemyHealth = enemyHealth;
    }

    public void setEnemyAttackDamage(int enemyAttackDamage) {
        this.enemyAttackDamage = enemyAttackDamage;
    }
}
