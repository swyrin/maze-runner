package Game.Entity;

import java.util.Random;

/**
 * Represents an AI player with random movement.
 */
public class NPCNormal extends Player {

    public NPCNormal(int x, int y) {
        super(x, y);
        // Set animation paths for idle state
        this.animationIdleUp = "/Player/knight_f_idle_anim_f0.png";
        this.animationIdleDown = "/Player/knight_f_idle_anim_f1.png";
        this.animationIdleLeft = "/Player/knight_f_idle_anim_f2.png";
        this.animationIdleRight = "/Player/knight_f_idle_anim_f3.png";
        // Set animation paths for running state
        this.animationRunUp = "/Player/knight_f_run_anim_f0.png";
        this.animationRunDown = "path/knight_f_run_anim_f1.png";
        this.animationRunLeft = "/Player/knight_f_run_anim_f2.png";
        this.animationRunRight = "/Player/knight_f_run_anim_f3.png";
    }


    //  @Override
    public void update() {
        // super.update();
        // Implement random movement logic
        Random random = new Random();
        int direction = random.nextInt(4); // 0: UP, 1: DOWN, 2: LEFT, 3: RIGHT

        switch (direction) {
            case 0:
                setDirection(Direction.UP);
                setState(State.RUN);
                addY(-1); // Move up
                break;
            case 1:
                setDirection(Direction.DOWN);
                setState(State.RUN);
                addY(1); // Move down
                break;
            case 2:
                setDirection(Direction.LEFT);
                setState(State.RUN);
                addX(-1); // Move left
                break;
            case 3:
                setDirection(Direction.RIGHT);
                setState(State.RUN);
                addX(1); // Move right
                break;
        }
    }
}





