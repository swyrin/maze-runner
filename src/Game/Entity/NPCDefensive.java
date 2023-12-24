package Game.Entity;

public class NPCDefensive extends Player {

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

        // Get the player instance here

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
