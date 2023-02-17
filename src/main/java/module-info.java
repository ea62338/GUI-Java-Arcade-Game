/**
 * Provides the starter code for the <strong>cs1302-omega</strong> project.
 */
module main {
    requires transitive java.logging;
    requires transitive java.net.http;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.web;
    exports Main.game;
    exports Main.omega;
} // module
