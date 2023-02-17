package Main.game;

import javafx.scene.image.ImageView;

/**
 * A simple "sprite" of Player.
 */
public class Player extends ImageView {

    private Game game; // game containing this sprite
    private double dx; // change in x per update
    private double dy; // change in y per update
    private Floors floor;
    private int floorNumber;

    private int direction = 1;

    /**
     * Construct an {@code IdleCat} object.
     *
     * @param game parent game
     */
    public Player(Game game) {
        super("file:resources/sprites/player.gif"); // call parent constructor
        this.setPreserveRatio(true);
        this.setFitWidth(37);
        this.setFitHeight(37);
        this.game = game;
    } // Ladders

    /**
     * Construct getFloor method.
     * @return floor from getFloor.
     */
    public Floors getFloor() {
        return floor;
    }

    /**
     * Construct setFloor method.
     * @param floor from setFloor.
     */
    public void setFloor(Floors floor) {
        this.floor = floor;
    }

    /**
     * Construct setFloorNumber method.
     * @param i from numbers.
     */
    public void setFloorNumber(int i) {
        this.floorNumber = i;
    }

    /**
     * Construct getFromNumber method.
     * @return floorNumber form get floor.
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * Construct jump method.
     */
    public void jump() {
        //how high he goes
        setY(getY() - 30);
    }

    /**
     * Construct resetJump method.
     */
    public void resetJump() {
        setY(floor.getBoundsInParent().getMinY() - 38);
    }

    /**
     * Construct getDirection method.
     * @return direction getDirection.
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Construct setDirection method.
     * @param direction from setD.
     */
    public void setDirection(int direction) {
        this.setScaleX(direction);
        this.direction = direction;
    }
} // Player
