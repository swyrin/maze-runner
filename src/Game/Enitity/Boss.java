package Game.Enitity;

/**
 * Represents a boss entity on the screen.
 */
public class Boss extends Player {
    private Player targetPlayer;

    public Boss(int x, int y, Player targetPlayer) {
        super(x, y);
        this.targetPlayer = targetPlayer;
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
        super.update();

        // Chase the player
        if (targetPlayer != null) {
            int playerX = targetPlayer.getX();
            int playerY = targetPlayer.getY();

            // Implement your logic to move the boss towards the player

            if (playerX < getX()) {
                setDirection(Direction.LEFT);
                setState(State.RUN);
                addX(-1); // Move left
            } else if (playerX > getX()) {
                setDirection(Direction.RIGHT);
                setState(State.RUN);
                addX(1); // Move right
            }

            if (playerY < getY()) {
                setDirection(Direction.UP);
                setState(State.RUN);
                addY(-1); // Move up
            } else if (playerY > getY()) {
                setDirection(Direction.DOWN);
                setState(State.RUN);
                addY(1); // Move down
            }
        }
    }
}
