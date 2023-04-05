package com.codecool.dungeoncrawl.logic;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Weapon> items;

    public Inventory() {
        items = new HashMap<String, Weapon>();
    }
    public void addItem(Weapon weapon) {
        String itemName = weapon.getName();
        if (items.containsKey(itemName)) {
            Weapon existingWeapon = items.get(itemName);
            existingWeapon.setQuantity(existingWeapon.getQuantity() + weapon.getQuantity());
        } else {
            items.put(itemName, weapon);
        }
    }

    public void removeItem(Weapon weapon) {
        String itemName = weapon.getName();
        if (items.containsKey(itemName)) {
            Weapon existingWeapon = items.get(itemName);
            int quantity = existingWeapon.getQuantity() - weapon.getQuantity();
            if (quantity <= 0) {
                items.remove(itemName);
            } else {
                existingWeapon.setQuantity(quantity);
            }
        }
    }
    public boolean hasItem(Weapon weapon) {
        String itemName = weapon.getName();
        if (items.containsKey(itemName)) {
            Weapon existingWeapon = items.get(itemName);
            return existingWeapon.getQuantity() >= weapon.getQuantity();
        }
        return false;
    }



    public Map<String, Integer> getItemQuantities() {
        Map<String, Integer> itemQuantities = new HashMap<>();
        for (Map.Entry<String, Weapon> entry : items.entrySet()) {
            itemQuantities.put(entry.getKey(), entry.getValue().getQuantity());
        }
        return itemQuantities;
    }

    public Map<String, Integer> getItems() {
        Map<String, Integer> itemQuantities = new HashMap<>();
        for (Map.Entry<String, Weapon> entry : items.entrySet()) {
            itemQuantities.put(entry.getKey(), entry.getValue().getQuantity());
        }
        return itemQuantities;
    }
    public Weapon getEquippedItem() {
        for (Map.Entry<String, Weapon> entry : items.entrySet()) {
            Weapon weapon = entry.getValue();
            if (weapon.isEquipped()) {
                return weapon;
            }
        }
        return null;
    }

    public Weapon getItem(String itemName){
        for (Map.Entry<String, Weapon> entry : items.entrySet()){
            Weapon weapon = entry.getValue();
            if(itemName.equals(weapon.getName())) return weapon;
        }
        return null;
    }
}
