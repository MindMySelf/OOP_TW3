package com.codecool.dungeoncrawl.ui.elements;

import com.codecool.dungeoncrawl.logic.Inventory;
import com.codecool.dungeoncrawl.logic.Item;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Map;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label damageTextLabel;
    private Label damageValueLabel;
    private VBox inventoryBox;


    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        damageTextLabel = new Label("Damage: ");
        damageValueLabel = new Label();
        inventoryBox = new VBox();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);

        ui.add(damageTextLabel,0,1);
        ui.add(damageValueLabel,1,1);

        ui.add(new Label("Inventory"), 0 ,2);
        ui.add(inventoryBox, 0, 3, 2, 1);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }
    public void setDamageValue(String text) {
        damageValueLabel.setText(text);
    }
    public void updateInventory(Inventory inventory) {
        inventoryBox.getChildren().clear();
        Map<String, Integer> itemQuantities = inventory.getItemQuantities();
        for (Map.Entry<String, Integer> entry : itemQuantities.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            Label itemLabel = new Label(itemName + ": " + quantity);
            inventoryBox.getChildren().add(itemLabel);
        }
    }
}
