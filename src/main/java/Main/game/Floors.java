package Main.game;

import javafx.scene.image.ImageView;

/**
 * A simple "sprite" of Floors.
 */
public class Floors extends ImageView {

    private Game game; // game containing this sprite
    private double dx; // change in x per update
    private double dy; // change in y per update

    /**
     * Construct an {@code IdleCat} object.
     * @param game parent game
     */
    public Floors(Game game) {
        super("file:resources/sprites/floor.png"); // call parent constructor
        this.setPreserveRatio(true);
        this.setFitWidth(640);
        this.setFitHeight(50);
        this.game = game;
        this.dx = 2; // each update, add 2 to x (to start)
        this.dy = 0; // each update, add 0 to y (to start)
    } // Floors

} // Floors
