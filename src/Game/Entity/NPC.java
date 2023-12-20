package Game.Entity;

import java.util.Random;

/**
 * Represents an AI player with random movement.
 */
class NPCNormal extends Player {

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

/**
 * Represents an AI player with defensive movement.
 */
class NPCDefensive extends Player {

    public NPCDefensive(int x, int y) {
        super(x, y);
        // Set animation paths for idle state
        this.animationIdleUp = "/Player/lizard_m_idle_anim_f0.png";
        this.animationIdleDown = "/Player/lizard_m_idle_anim_f1.png";
        this.animationIdleLeft = "/Player/lizard_m_idle_anim_f2.png";
        this.animationIdleRight = "/Player/lizard_m_idle_anim_f3.png";
        // Set animation paths for running state
        this.animationRunUp = "/Player/lizard_m_run_anim_f0.png";
        this.animationRunDown = "/Player/lizard_m_run_anim_f1.png";
        this.animationRunLeft = "/Player/lizard_m_run_anim_f2.png";
        this.animationRunRight = "/Player/lizard_m_run_anim_f3.png";
    }

    //   @Override
    public void update() {
        //   super.update();
        // Implement AI defensive logic movement

        Player player = null;

        // Get the player instance here (Assuming Player is a class with getX() and getY() methods)

        int playerX = player.getX();
        int playerY = player.getY();

        int deltaX = playerX - getX();
        int deltaY = playerY - getY();

        // Choose a direction away from the player and move
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            // Move horizontally
            if (deltaX > 0) {
                setDirection(Direction.LEFT);
                addX(-1);
            } else {
                setDirection(Direction.RIGHT);
                addX(1);
            }
        } else {
            // Move vertically
            if (deltaY > 0) {
                setDirection(Direction.UP);
                addY(-1);
            } else {
                setDirection(Direction.DOWN);
                addY(1);
            }
        }
    }
}

/**
 * Represents an AI player with aggressive movement.
 */
class NPCAggressive extends Player {

    public NPCAggressive(int x, int y) {
        super(x, y);
        // Set animation paths for idle state
        this.animationIdleUp = "/Player/wizzard_m_idle_anim_f0.png";
        this.animationIdleDown = "/Player/wizzard_m_idle_anim_f1.png";
        this.animationIdleLeft = "/Player/wizzard_m_idle_anim_f2.png";
        this.animationIdleRight = "/Player/wizzard_m_idle_anim_f3.png";
        // Set animation paths for running state
        this.animationRunUp = "/Player/wizzard_m_run_anim_f0.png";
        this.animationRunDown = "/Player/wizzard_m_run_anim_f1.png";
        this.animationRunLeft = "/Player/wizzard_m_run_anim_f2.png";
        this.animationRunRight = "/Player/wizzard_m_run_anim_f3.png";
    }

    //   @Override
    public void update() {
        //   super.update();
        // Implement aggressive AI logic movement

        Player player = null;

        // Get the player instance here (Assuming Player is a class with getX() and getY() methods)

        int playerX = player.getX();
        int playerY = player.getY();

        int deltaX = playerX - getX();
        int deltaY = playerY - getY();

        // Choose a direction towards the player and move
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            // Move horizontally
            if (deltaX > 0) {
                setDirection(Direction.RIGHT);
                addX(1);
            } else {
                setDirection(Direction.LEFT);
                addX(-1);
            }
        } else {
            // Move vertically
            if (deltaY > 0) {
                setDirection(Direction.DOWN);
                addY(1);
            } else {
                setDirection(Direction.UP);
                addY(-1);
            }
        }
    }
}

