package namegen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainGui extends Application
{
    private boolean openChooser = true;

    private NameGenView view;
    private FileChooser fc;
    private Stage stage;

    public MainGui()
    {
        view = new NameGenView();
        view.setOnBrowseButton(this::handleBrowseButton);
        fc = new FileChooser();
    }
    public void addStage(Stage stage)
    {
        this.stage = stage;
    }
    public Stage getStage()
    {
        return this.stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        MainGui gui = new MainGui();
        primaryStage.setTitle("Name Generator");
        primaryStage.setScene(new Scene(view.getParent(), 350, 430));
        primaryStage.setResizable(false);
        primaryStage.show();

        gui.addStage(primaryStage);

    }
    public void handleBrowseButton(ActionEvent e)
    {
        fc.setTitle("Choose file");
        File f = fc.showOpenDialog(getStage());
        if(f != null)
            view.setSorucePath(f);
    }
    public static void main(String ... args)
    {
        launch(args);
    }
}
