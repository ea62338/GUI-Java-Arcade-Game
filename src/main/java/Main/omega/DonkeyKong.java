package Main.omega;

import Main.game.DemoGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 * This is a DonkeyKong arcade game recreation in JavaFX.
 */
public class DonkeyKong extends Application {
    //test
    /**
     * Constructs an {@code DonkeyKong} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public DonkeyKong() {}

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        // demo game provided with the starter code
        DemoGame game = new DemoGame(640, 550);

        // setup scene
        Group root = new Group(game);
        //VBox root = new VBox(player_inst, jump_inst, ladder_inst, game);
        Scene scene = new Scene(root, Color.BLACK);

        // setup stage
        stage.setTitle("DonkeyKong!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();

        // play the game
        game.play();

    } // start
} // DonkeyKong