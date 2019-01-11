package namegen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import static javafx.scene.layout.BorderWidths.DEFAULT;

public class NameGenView
{
    private VBox mainPane;

    private VBox textContainer;
    private Text infoMessage;

    private VBox srcAndOutContainer;

    private HBox srcContainer;
    private HBox outContainer;


    private TextField inputSource;
    private TextField inputName;

    private Button browseSrcBtn;
    private Button mkFileBtn;



    public NameGenView()
    {
        // Message Container
        infoMessage = new Text("This program generates names based on a file containing names one per line. " +
                "You must provide a appropriately formatted file and a name for the new file containing the new names." +
                "\n\nEnjoy!");
        infoMessage.setWrappingWidth(330);
        textContainer = new VBox();
        textContainer.getChildren().add(infoMessage);
        textContainer.setSpacing(50);
        //textContainer.setAlignment(Pos.CENTER);
        textContainer.setPadding(new Insets(15, 15, 15, 15));
        textContainer.setBorder(new Border(new BorderStroke(Color.BLANCHEDALMOND, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.FULL)));

        // Source Container
        inputSource = new TextField();
        inputSource.setPromptText("Set path to source");
        inputSource.setMinWidth(200);
        browseSrcBtn = new Button("Browse");
        browseSrcBtn.setMinWidth(100);
        srcContainer = new HBox();
        srcContainer.getChildren().addAll(inputSource, browseSrcBtn);

        // Make output container
        inputName = new TextField();
        inputName.setPromptText("Set new file name");
        inputName.setMinWidth(200);
        mkFileBtn = new Button("Generate");
        mkFileBtn.setMinWidth(100);
        outContainer = new HBox();
        outContainer.getChildren().addAll(inputName, mkFileBtn);

        srcAndOutContainer = new VBox();
        srcAndOutContainer.setAlignment(Pos.CENTER);
        srcAndOutContainer.setPadding(new Insets(15, 15, 15, 15));
        srcAndOutContainer.getChildren().addAll(srcContainer, outContainer);

        mainPane = new VBox();
        mainPane.getChildren().addAll(textContainer, srcAndOutContainer);
    }

    public Parent getParent()
    {
        return mainPane;
    }
}

