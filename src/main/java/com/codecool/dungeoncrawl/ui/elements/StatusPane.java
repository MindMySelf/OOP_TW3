package com.codecool.dungeoncrawl.ui.elements;

import com.codecool.dungeoncrawl.logic.Inventory;
import com.codecool.dungeoncrawl.logic.Weapon;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Map;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private static final int FONT_SIZE = 25;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label inventoryLabel;
    private Label damageTextLabel;
    private Label damageValueLabel;
    private VBox inventoryBox;


    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthTextLabel.setFont(new Font(FONT_SIZE));
        healthValueLabel = new Label();
        healthValueLabel.setFont(new Font(FONT_SIZE));
        healthTextLabel.setFont(new Font(FONT_SIZE));
        damageTextLabel = new Label("Damage: ");
        damageTextLabel.setFont(new Font(FONT_SIZE));
        damageValueLabel = new Label();
        inventoryLabel = new Label("Inventory");
        inventoryLabel.setFont(new Font(FONT_SIZE));
        inventoryBox = new VBox();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);

        ui.add(damageTextLabel,0,1);
        ui.add(damageValueLabel,1,1);

        ui.add(inventoryLabel, 0 ,2);
        ui.add(inventoryBox, 0, 3, 2, 1);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
        healthValueLabel.setFont(new Font(FONT_SIZE));
    }
    public void setDamageValue(String text) {
        damageValueLabel.setText(text);
        damageValueLabel.setFont(new Font(FONT_SIZE));
    }
    public void updateInventory(Inventory inventory) {
        inventoryBox.getChildren().clear();
        Map<String, Integer> itemQuantities = inventory.getItemQuantities();
        for (Map.Entry<String, Integer> entry : itemQuantities.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            Weapon weapon = inventory.getWeapon(itemName);
            Label itemLabel = new Label(itemName + ": " + quantity);
            itemLabel.setFont(new Font(FONT_SIZE));
            Label equipLabel = new Label("Click to Equip");
            equipLabel.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-padding: 5px;");
            if(weapon != null && weapon.isEquipped()){
                equipLabel.setText("Equipped");
                equipLabel.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #ffffff; -fx-padding: 5px;");

            }

            equipLabel.setOnMouseClicked(e -> {
                if (weapon != null) {
                    if (!weapon.isEquipped()) {
                        for (String equippedItem: inventory.getItems().keySet()) {
                            if (inventory.getWeapon(equippedItem).isEquipped()) {
                                inventory.getWeapon(equippedItem).setEquipped(false);
                            }
                        }
                        weapon.setEquipped(true);
                        equipLabel.setText("Equipped");
                        equipLabel.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #ffffff; -fx-padding: 5px;");
                        updateInventory(inventory);
                    } else {
                        weapon.setEquipped(false);
                        equipLabel.setText("Click to Equip");
                        equipLabel.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-padding: 5px;");
                    }
                }
            });
            inventoryBox.getChildren().addAll(itemLabel, equipLabel);
        }
    }

}
