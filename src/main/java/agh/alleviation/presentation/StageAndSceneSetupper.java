package agh.alleviation.presentation;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class StageAndSceneSetupper {
    protected Stage primaryStage;

    public StageAndSceneSetupper(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage setupStageAndScene(Pane root, String title) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);

        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        return dialogStage;
    }
}
