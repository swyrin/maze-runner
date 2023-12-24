package Game.Entity;
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

    public Boss(int x, int y, Player targetPlayer, Boss boss, List<Player> players) {
        super(x, y);
        this.targetPlayer = targetPlayer;
        this.boss = boss;
        this.players = players;
        this.alerted = false;
        this.playerNearBoss = false;
        double speed = 1.1;


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
                boss.setSpeed(1.15); // Set default speed
                alerted = false;
            }

            // Move boss towards the nearest player
            moveBossTowardsPlayer(playerX, playerY);
        }
    }

    private Player findNearestPlayer(int startX, int startY) {
        // Implement DFS algorithm to find the nearest player
        // ...

        return null; // Placeholder, replace with actual implementation
    }

    private boolean isPlayerNearBoss(int playerX, int playerY) {
        // Check if the player is near the boss spawn point
        int bossX = boss.getX();
        int bossY = boss.getY();

        int distance = Math.abs(bossX - playerX) + Math.abs(bossY - playerY);
        return distance <= 3; // Adjust the distance as needed
    }

    private void moveBossTowardsPlayer(int playerX, int playerY) {
        // logic to move the boss towards the player
        // not figure out yet
    }

    // Rajang when seeing hunter
    public boolean isAlerted() {
        return alerted;
    }
}



  /*  @Override
    public void update() {
        super.update();

        behavior.update();
        if (behavior.isAlerted()) {
            // Do something when alerted
        }
    }
    
    */


