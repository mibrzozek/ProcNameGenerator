package namegen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGui extends Application
{
    private NameGenView view;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        view = new NameGenView();

        MainGui gui = new MainGui();
        primaryStage.setTitle("Name Generator");
        primaryStage.setScene(new Scene(view.getParent(), 350, 350));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String ... args)
    {
        launch(args);
    }
}
