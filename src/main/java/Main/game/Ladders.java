package Main.game;


import javafx.scene.image.ImageView;

/**
 * A simple "sprite" of Ladders.
 */
public class Ladders extends ImageView {

    private Game game; // game containing this sprite
    private double dx; // change in x per update
    private double dy; // change in y per update
    Floors from;
    Floors to;

    /**
     * Construct an {@code IdleCat} object.
     * @param game parent game
     */
    public Ladders(Game game) {
        super("file:resources/sprites/ladder.png"); // call parent constructor
        this.setPreserveRatio(true);
        this.setFitWidth(200);
        this.setFitHeight(100);
        this.game = game;
        this.dx = 2; // each update, add 2 to x (to start)
        this.dy = 0; // each update, add 0 to y (to start)
    } // Ladders

    /**
     * Construct getFrom method.
     * @return from getFrom.
     */
    public Floors getFrom() {
        return from;
    }

    /**
     * Construct setFrom method.
     * @param from getting floors.
     */
    public void setFrom(Floors from) {
        this.from = from;
    }

    /**
     * Construct getTo method.
     * @return to from getTo.
     */
    public Floors getTo() {
        return to;
    }

    /**
     * Construct setTo method.
     * @param to from floors.
     */
    public void setTo(Floors to) {
        this.to = to;
    }
} // Ladders
