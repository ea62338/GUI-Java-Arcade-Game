package Main.game;

import javafx.scene.image.ImageView;

/**
 * A simple "sprite" of Floors.
 */
public class Barrels extends ImageView {

    private Game game; // game containing this sprite
    private int dx; // change in x per update
    private int dy; // change in y per update

    /**
     * Construct an {@code IdleCat} object.
     * @param game parent game
     */
    public Barrels(Game game) {
        super("file:resources/sprites/barrel.png"); // call parent constructor
        this.setPreserveRatio(true);
        this.setFitWidth(23);
        this.setFitHeight(23);
        this.game = game;
        //horizontal speed
        this.dx = 12; // each update, add 2 to x (to start)
        this.dy = 0; // each update, add 0 to y (to start)
    } // IdleCat

    /**
     * Construct getDX method.
     * @return dx from get.
     */
    public int getDx() {
        return dx;
    }

    /**
     * Construct setDX method.
     * @param dx from setDx.
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * Construct getDy method.
     * @return dy from getDy.
     */
    public int getDy() {
        return dy;
    }

    /**
     * Construct getDy method.
     * @param dy rom setDy.
     */
    public void setDy(int dy) {
        this.dy = dy;
    }
} // Barrels
