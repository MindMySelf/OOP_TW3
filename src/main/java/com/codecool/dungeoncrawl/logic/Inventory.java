package com.codecool.dungeoncrawl.logic;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> items;

    public Inventory() {
        items = new HashMap<String, Item>();
    }
    public void addItem(Item item) {
        String itemName = item.getName();
        if (items.containsKey(itemName)) {
            Item existingItem = items.get(itemName);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(itemName, item);
        }
    }

    public void removeItem(Item item) {
        String itemName = item.getName();
        if (items.containsKey(itemName)) {
            Item existingItem = items.get(itemName);
            int quantity = existingItem.getQuantity() - item.getQuantity();
            if (quantity <= 0) {
                items.remove(itemName);
            } else {
                existingItem.setQuantity(quantity);
            }
        }
    }
    public boolean hasItem(Item item) {
        String itemName = item.getName();
        if (items.containsKey(itemName)) {
            Item existingItem = items.get(itemName);
            return existingItem.getQuantity() >= item.getQuantity();
        }
        return false;
    }



    public Map<String, Integer> getItemQuantities() {
        Map<String, Integer> itemQuantities = new HashMap<>();
        for (Map.Entry<String, Item> entry : items.entrySet()) {
            itemQuantities.put(entry.getKey(), entry.getValue().getQuantity());
        }
        return itemQuantities;
    }

    public Map<String, Integer> getItems() {
        Map<String, Integer> itemQuantities = new HashMap<>();
        for (Map.Entry<String, Item> entry : items.entrySet()) {
            itemQuantities.put(entry.getKey(), entry.getValue().getQuantity());
        }
        return itemQuantities;
    }


}
