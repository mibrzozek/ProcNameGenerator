package namegen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;

public class NameGenView
{
    private VBox mainPane;

    private VBox textContainer;
    private VBox randNameContainer;
    private Text infoMessage;

    private VBox srcAndOutContainer;
    private HBox srcContainer;
    private HBox outContainer;
    private HBox lineContainer;

    private TextField inputSource;
    private TextField inputName;
    private TextField outputSize;
    private Button browseSrcBtn;
    private Button mkFileBtn;



    private Text randomNames;

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

        outputSize = new TextField();
        outputSize.setPromptText("Enter number of lines");
        lineContainer = new HBox();
        lineContainer.setPadding(new Insets(15, 15, 15, 15));


        srcAndOutContainer = new VBox();
        srcAndOutContainer.setAlignment(Pos.CENTER);
        srcAndOutContainer.setPadding(new Insets(15, 15, 15, 15));
        srcAndOutContainer.getChildren().addAll(srcContainer,outputSize, outContainer);

        // Random name display
        randomNames = new Text("Names generated from Tolkien names :\n\n"
            + "Togiga\n" +
                "Samwdan\n" +
                "Primeht\n" +
                "Urthor\n" +
                "Tarcawi\n" +
                "Andwfan\n" +
                "Milicctho\n" +
                "Tullfanwen\n" +
                "Folthys\n" +
                "Ae-Ata");
        randNameContainer = new VBox();
        randNameContainer.getChildren().addAll(randomNames);
        randNameContainer.setPadding(new Insets(15, 15, 15, 15));

        mainPane = new VBox();
        mainPane.getChildren().addAll(textContainer, srcAndOutContainer, randNameContainer);
    }
    public void setSorucePath(File f)
    {
        this.inputSource.setText(f.getAbsolutePath());
    }
    public void setOnBrowseButton(EventHandler<ActionEvent> handler)    {   browseSrcBtn.setOnAction(handler);   }
    public void setOnGenerateButton(EventHandler<ActionEvent> handler)  {   mkFileBtn.setOnAction(handler);      }

    public Parent getParent()
    {
        return mainPane;
    }
}

