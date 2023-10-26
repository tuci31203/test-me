import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler; 
import javafx.scene.control.Button; 
import javafx.scene.control.TextArea; 
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane; 
import javafx.scene.shape.Circle;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) { 
        Button button = new Button("Button"); 
        TextArea text = new TextArea(); 
        Circle circle = new Circle(25.0f);
        FlowPane fp = new FlowPane(button, text, circle);
        fp.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent arg0) {
                text.appendText("Filter in flow pane\n"); 
            }
        });
        fp.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) { text.appendText("Handler in flow pane\n");
            } 
        });
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
            text.appendText("Filter in button\n");
            } 
        });
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent arg0) { 
                text.appendText("Handler in button\n");
            }
        });
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() { 
            @Override
            public void handle(MouseEvent arg0) { 
                text.appendText("Filter in circle\n");
            }
        });
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) { 
                text.appendText("Handler in circle\n");
            } 
        });
        // Creating a scene object
        Scene scene = new Scene(fp, 600, 300); stage.setTitle("Event Filters Example");
        stage.setScene(scene);
        stage.show(); }

    /**
     * @param string
     */
    public static void setRoot(String string) {
    }
    public static void main(String args[]){
        Application.launch(App.class, args);
    }
}