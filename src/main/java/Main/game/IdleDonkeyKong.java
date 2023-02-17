package Main.game;

import javafx.scene.image.ImageView;

/**
 * A simple "sprite" of an idle donkeykong.
 */
public class IdleDonkeyKong extends ImageView {

    private Game game; // game containing this sprite
    private double dx; // change in x per update
    private double dy; // change in y per update

    /**
     * Construct an {@code IdleCat} object.
     * @param game parent game
     */
    public IdleDonkeyKong(Game game) {
        super("file:resources/sprites/DK_animated.gif"); // call parent constructor
        this.setPreserveRatio(true);
        this.setFitWidth(100);
        this.setFitHeight(100);
        this.game = game;
        this.dx = 2; // each update, add 2 to x (to start)
        this.dy = 0; // each update, add 0 to y (to start)
    } // IdleCat

} // IdleDonkeyKong
