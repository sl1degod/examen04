package com.example.demo1.models;

import javafx.stage.Stage;

public class StageModel {
    public static Stage myStage;

    public static Stage getMyStage() {
        return myStage;
    }

    public static void setMyStage(Stage myStage) {
        StageModel.myStage = myStage;
    }
}
