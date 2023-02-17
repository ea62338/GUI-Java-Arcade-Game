package Main.game;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.geometry.Bounds;

/**
 * DonkeyKong arcade game in JavaFX. The play can move the rectangle left/right
 * with the arrow keys or jump with space!
 */
public class DemoGame extends Game {

    private Player player;
    private IdleDonkeyKong donkeykong;
    private IdlePauline pauline;
    private ArrayList<Barrels> barrels;
    private ArrayList<Floors> floors;
    private ArrayList<Ladders> ladders;

    private int jump = 0;
    private boolean climbedUp = false;
    private boolean climbedDown = false;

    /**
     * Construct a {@code DemoGame} object.
     * @param width scene width
     * @param height scene height
     */
    public DemoGame(int width, int height) {
        super(width, height, 60);            // call parent constructor

        this.player = new Player(this); // Player to represent the player


        this.donkeykong  = new IdleDonkeyKong(this);
        this.pauline = new IdlePauline(this);

        floors = new ArrayList<>();
        ladders = new ArrayList<>();

        for (int i = 0 ; i < 5 ; i++) {
            floors.add(new Floors(this));
            if (i < 4) {
                ladders.add(new Ladders(this));
            }
            if (i == 3) {
                ladders.get(3).setFitHeight(83);
            }
        }
        for (int i = 0 ; i < ladders.size() ; i++) {
            Ladders current = ladders.get(i);
            current.setFrom(floors.get(i));
            current.setTo(floors.get(i + 1));

        }

        barrels = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++) {
            barrels.add(new Barrels(this));
        }

    } // DemoGame

    /** {@inheritDoc}*/
    @Override
    protected void init() {
        // setup subgraph for this component
        getChildren().addAll(floors);
        getChildren().addAll(ladders);
        getChildren().addAll(barrels);
        getChildren().addAll(player, donkeykong, pauline); // add to main container
        setPositions();
    } // init

    /** Method for setting positions of objects.
     */
    private void setPositions() {
        // setup player
        player.setX(65);                           // 50px in the x direction (right)
        player.setY(430);                           // 50ps in the y direction (down)
        jump = 0;
        donkeykong.setX(10);
        donkeykong.setY(18);
        // pauline
        pauline.setX(150);
        pauline.setY(27);
        //floors
        floors.get(0).setX(0);
        floors.get(0).setY(470);
        player.setFloor(floors.get(0));
        player.setFloorNumber(0);
        floors.get(1).setX(0);
        floors.get(1).setY(370);
        floors.get(2).setX(0);
        floors.get(2).setY(270);
        floors.get(3).setX(0);
        floors.get(3).setY(170);
        floors.get(4).setX(0);
        floors.get(4).setY(87);
        //ladders
        ladders.get(0).setX(500);                        // 50px in the x direction (right)
        ladders.get(0).setY(370);                      // 50ps in the y direction (down)
        ladders.get(1).setX(100);
        ladders.get(1).setY(270);
        ladders.get(2).setX(500);
        ladders.get(2).setY(170);
        ladders.get(3).setX(300);
        ladders.get(3).setY(87);
        //barrel
        barrels.get(0).setX(540);
        barrels.get(0).setY(451);
        barrels.get(1).setX(40);
        barrels.get(1).setY(351);
        barrels.get(2).setX(540);
        barrels.get(2).setY(251);
        barrels.get(3).setX(40);
        barrels.get(3).setY(151);
        barrels.get(4).setX(541);
        barrels.get(4).setY(68);
        for (int i = 0 ; i < 5 ; i++) {
            Bounds b = floors.get(i).getBoundsInParent();
            System.out.println(b.getMaxY());
        }
    }
    /** {@inheritDoc}*/

    @Override
    protected void update() {
        Bounds playerBounds = player.getBoundsInParent();
        // update player position
        isKeyPressed(KeyCode.LEFT, () -> {
            player.setX(player.getX() - 10.0);
            if (player.getX() < 0) {
                player.setX(0);
            }
            player.setDirection(-1);
            climbedUp = false;
            climbedDown = false;
        });
        isKeyPressed(KeyCode.RIGHT, () -> {
            if (playerBounds.getMaxX() >= this.bounds.getMaxX()) {
                player.setX(player.getX() + 0);
            } else {
                player.setX(player.getX() + 10.0);
            }
            player.setDirection(1);
            climbedUp = false;
            climbedDown = false;
        });
        isKeyPressed(KeyCode.SPACE, () -> {
            if (jump == 0) {
                player.jump();
                //how long he stays in air
                jump = 6;
            }
        });
        isKeyPressed(KeyCode.UP, () -> {
            if (!climbedUp) {
                for (Ladders l : ladders) {
                    Bounds lb = l.getBoundsInParent();
                    if (lb.intersects(playerBounds) && l.getFrom() == player.getFloor()) {
                        player.setY(player.getY() - 10);
                        int f = player.getFloorNumber();
                        Floors next = floors.get(f + 1);
                        if (player.getY() - 40 < next.getBoundsInParent().getMaxY()) {
                            System.out.println("Change floor");
                            player.setFloor(next);
                            player.setFloorNumber(f + 1);
                            player.resetJump();
                            climbedUp = true;
                        }
                        return;
                    }
                }
            }
        });
        if (jump > 0) {
            jump--;
            if (jump == 0) {
                player.resetJump();
            }
        }
        for (Barrels b : barrels) {         //barrels move here!!
            b.setX(b.getX() + b.getDx());
            Bounds bounds = b.getBoundsInParent();
            if (bounds.getMaxX() >= this.bounds.getMaxX()) {
                //speed refer barrel dx
                b.setDx(-b.getDx());
            } else if (bounds.getMinX() <= 0) {
                b.setDx(-b.getDx());
            }
            if (bounds.intersects(playerBounds)) {
                gameOver("You Lost! Do you want to play again?");
            }
        }
        if (playerBounds.intersects(pauline.getBoundsInParent())) {
            gameOver("You won! Do you want to play again?");
        }
    } // update

    /**
     * Method for game over message.
     * @param message
     */

    private void gameOver(String message) {
        loop.stop();
        Platform.runLater(() -> {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, message);
            Optional<ButtonType> respons = a.showAndWait();
            if (respons.isPresent()) {
                if (respons.get() == ButtonType.OK) {
                    setPositions();
                    keysPressed.clear();
                    loop.play();
                } else {
                    System.exit(0);
                }
            }
        });
    }
} // DemoGame