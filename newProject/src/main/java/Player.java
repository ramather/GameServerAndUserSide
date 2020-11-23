import java.util.Random;

public class Player {
    private int health = 1000;
    private int attackDamage = 100;
    private int level = 1;
    private int numberOfHealthPots = 3;
    private int numberOfMonstersKilled = 0;
    private boolean defeatedFrieza = false;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHealthPots() {
        return numberOfHealthPots;
    }
    public void drinkHealthPot(){
        if(numberOfHealthPots > 0){
            health += 30;
            numberOfHealthPots--;
            System.out.println("\t> you drink a health potion, healing yourself for " +
                    "30 HP \n\t You now have "+health+
                    "\n\t> You have "+ numberOfHealthPots+" health potions left. \n");
        }else{
            System.out.println("\t You have no health potions left!");
        }
    }
    public int getLevel() {
        return level;
    }

    public int getNumberOfMonstersKilled() {
        return numberOfMonstersKilled;
    }
    public void monsterWasDefeated(){
        numberOfMonstersKilled++;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Player(){

    }
    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealth() {
        return health;
    }
    public void levelUp(){
        level++;
        health += 10;
        attackDamage += 25;
    }
    public void checkIfLevelUp(){
        if(numberOfMonstersKilled % 5 == 0){
            levelUp();
            System.out.println("# You Leveled Up!");
        }
    }
    public void healthPotDrop(Enemy enemy){
        Random rand = new Random();
        if (rand.nextInt(70) < 50) {
            numberOfHealthPots++;
            System.out.println(" # The " + enemy.getName() + " dropped a health potion!");
        }
    }
    public void setFriezaDefeatedByPlayer(){
        defeatedFrieza = true;
    }

    public boolean isDefeatedFriezabyPlayer() {
        return defeatedFrieza;
    }
    public int calculateScore(){
        if(isDefeatedFriezabyPlayer()){
            return 50 + getNumberOfMonstersKilled();
        }else{
            return getNumberOfMonstersKilled();
        }
    }
}
