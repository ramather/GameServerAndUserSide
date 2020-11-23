import service.ScoreDTO;
import service.ScoreService;

import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        run();
    }
    public static void run(){
        ScoreService scoreService = new ScoreService();
        scoreService.displayScores();
        Scanner in = new Scanner(System.in);

        Player player = new Player();
        boolean running = true;

        System.out.println("\t-----Welcome to the dungeon-----");
        System.out.println("-----------------------------------------------------");
        GAME:
        while (running){
            Enemy enemy = new Enemy();
            System.out.println("\t# " + enemy.getName() + " has appeared! #\n");
            while (enemy.getEnemyHealth() > 0){
                monsterCombatPrompt(enemy.getName(), enemy.getEnemyHealth(), player.getHealth());
                String input = in.nextLine();
                if(input.equals("1")){
                    combat(player, enemy);
                    if(player.getHealth()<=0){
                        System.out.println("\t> You have taken too much damage," +
                                " you are too weak to go on!");
                        running = false;
                    }
                }else if(input.equals("2")){
                    player.drinkHealthPot();
                }else if(input.equals("3")){
                    System.out.println("\t You run away from the " + enemy.getName() + "!");
                    continue GAME;
                }else {
                    System.out.println("\t Invalid command");
                }
            }
        player.monsterWasDefeated();
            System.out.println("-----------------------------------------------------");
            System.out.println("  #  " + enemy.getName() + " was defeated! #");
        player.checkIfLevelUp();
        player.healthPotDrop(enemy);

        postCombatPrompt(player);
        String input = in.nextLine();
        while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
        if (input.equals("1")){
            System.out.println("\t You continue on your adventure");
            continue GAME;
        }else if(input.equals("2")){
            friezaBattle(player);
            running = false;
        }else if(input.equals("3")){
            System.out.println("\t You exit from the dungeon");
            running = false;
        }
        }
        System.out.print("\tPlease Enter Your Name:");
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setName(in.nextLine());
        scoreDTO.setScore(player.calculateScore());
        scoreService.createScore(scoreDTO);
        System.out.println("-------------------------------------------------------------");

        System.out.println("\tThanks for playing!!!");
    }
    public static void friezaBattle(Player player){
        Scanner in = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------");
        System.out.println("You see a door barely visible towards the edge of the dungeon" +
                "\n inside the door sits none other than FRIEZA");
        System.out.println("The battle begins");
        System.out.println("-----------------------------------------------------------");
        Boss frieza = new Boss();

        while(frieza.getEnemyHealth() > 1){
            monsterCombatPrompt(frieza.getName(), frieza.getEnemyHealth(), player.getHealth());

            String input = in.nextLine();
            while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            if (input.equals("1")){
                combat(player,frieza);
                if(player.getHealth()<=0){
                    System.out.println("\t> You have taken too much damage," +
                            " you are too weak to go on!");
                    break;
                }
            } else if (input.equals("2")){
                player.drinkHealthPot();
            } else if (input.equals("3")){
                System.out.println("\t Fool! You cannot escape the all-powerful Frieza!");
            }
            if (frieza.getEnemyHealth() < 1 && player.getHealth() < 1) {
                System.out.println("\t You defeated Frieza but killed yourself in the process" +
                        "\n they will sing songs of your valor");
                player.setFriezaDefeatedByPlayer();
                break;
            } else if (frieza.getEnemyHealth() < 1) {
                System.out.println("\t You have defeated Frieza!");
                player.setFriezaDefeatedByPlayer();
                break;
            }  else if (player.getHealth() < 1) {
                System.out.println("you limp out of the dungeon");
                break;
            }
        }
    }
    public static void combat(Player player, Enemy enemy){

        Random rand = new Random();

        int damageDealt = rand.nextInt(player.getAttackDamage());
        int damageTaken= rand.nextInt(enemy.getEnemyAttackDamage());
        player.setHealth(player.getHealth() - damageTaken);
        enemy.setEnemyHealth(enemy.getEnemyHealth() - damageDealt);
        System.out.println("\t> You strike the " + enemy.getName() + " for " + damageDealt + " damage.");
        System.out.println("\t> You receive " + damageTaken + " in retaliation!");


    }
    public static void monsterCombatPrompt(String enemy, int enemyHealth, int health) {
        System.out.println("\tYour HP: " + health);
        System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
        System.out.println("\n\tWhat would you like to do?");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Drink health potion.");
        System.out.println("\t3. Run!");
    }
    public static void postCombatPrompt(Player player){
        System.out.println(" # you have killed " + player.getNumberOfMonstersKilled() + " monster(s)");
        System.out.println("# you are currently level: " + player.getLevel());
        System.out.println("-----------------------------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1. continue fighting?");
        System.out.println("2. try your luck with something more difficult");
        System.out.println("3. Exit dungeon");
    }



}

