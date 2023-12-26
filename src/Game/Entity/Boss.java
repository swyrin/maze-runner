package Game.Entity;

import javax.swing.*;
import java.util.List;

/**
 * Represents a boss entity on the screen.
 */

public class Boss extends Player {
    private final Player targetPlayer;
    private Boss boss;
    private List<Player> players;
    private boolean alerted;
    private boolean playerNearBoss;
    private double speed = 1.1;


    public Boss(int x, int y, Player targetPlayer, Boss boss, List<Player> players) {
        super(x, y);
        this.targetPlayer = targetPlayer;
        this.boss = boss;
        this.players = players;
        this.alerted = false;
        this.playerNearBoss = false;


        // Set animation paths for idle state
        this.animationIdleUp = "/Boss/big_demon_idle_anim_f0.png";
        this.animationIdleDown = "/Boss/big_demon_idle_anim_f1.png";
        this.animationIdleLeft = "/Boss/big_demon_idle_anim_f2.png";
        this.animationIdleRight = "/Boss/big_demon_idle_anim_f3.png";
        // Set animation paths for running state
        this.animationRunUp = "/Boss/big_demon_run_anim_f0.png";
        this.animationRunDown = "/Boss/big_demon_run_anim_f1.png";
        this.animationRunLeft = "/Boss/big_demon_run_anim_f2.png";
        this.animationRunRight = "/Boss/big_demon_run_anim_f3.png";

    }


    // Override the update method to implement boss behavior
    @Override
    public void update() {
        // Implement DFS algorithm to search for the nearest player
        Player nearestPlayer = findNearestPlayer(boss.getX(), boss.getY());

        if (nearestPlayer != null) {
            int playerX = nearestPlayer.getX();
            int playerY = nearestPlayer.getY();

            // Check if the player is near the boss
            if (isPlayerNearBoss(playerX, playerY)) {
                boss.setSpeed(1.2); // Increase speed when player is near
                alerted = true;
            } else {
                boss.setSpeed(1.1); // Set default speed
                alerted = false;
            }

            // Move boss towards the nearest player
            moveBossTowardsPlayer(playerX, playerY);
        }
    }

    private Player findNearestPlayer(int startX, int startY) {
        Player nearestPlayer = null;
        double minDistance = Double.MAX_VALUE;

        for(Player player : players){
            int playerX = player.getX();
            int playerY = player.getY();

            double distance = Math.sqrt(Math.pow(startX - playerX,2)+ Math.pow(startY - playerY,2));

            if (distance < minDistance){
                minDistance = distance;
                nearestPlayer = player;
            }
        }

        return nearestPlayer;
    }
    public double getSpeed(){
        return speed;
    }

    private boolean isPlayerNearBoss(int playerX, int playerY) {
        // Check if the player is near the boss spawn point
        int bossX = boss.getX();
        int bossY = boss.getY();

        int distance = Math.abs(bossX - playerX) + Math.abs(bossY - playerY);
        return distance <= 3; // Adjust the distance as needed
    }

    private void moveBossTowardsPlayer(int playerX, int playerY) {
        int bossX = boss.getX();
        int bossY = boss.getY();

        int deltaX = playerX - bossX;
        int deltaY = playerY - bossY;

        if(Math.abs(deltaX) > Math.abs(deltaY)) {
            if (deltaX > 0) {
                setDirection(Direction.RIGHT);
                addX((int) (speed * deltaX / Math.abs(deltaX)));
            } else {
                setDirection(Direction.LEFT);
                addX((int) (speed * deltaX / Math.abs(deltaX)));
            }
        }
                else{
                if (deltaY > 0) {
                    setDirection(Direction.DOWN);
                    addY((int) (speed * deltaY / Math.abs(deltaY)));
                }
            }
    }

    public void setSpeed(double speed){
              this.speed = speed;
    }

    // Rajang when seeing hunter
    public boolean isAlerted() {
        return alerted;
    }

    public boolean isPlayerNearBoss(){
        return playerNearBoss;
    }

    public void hitWithShockTrap() {
        // Logic to handle the shock trap effect
        // Example: boss.paralyze(); // need to implement the paralyze method
     }
}



