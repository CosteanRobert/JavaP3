package ro.uvt.p3.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements Comparable<Player> {
    String name;
    int HP, stamina, maxHP, maxStamina, max, level;
    List<Item> inventory = new ArrayList<>();
    Map<MountPoint, Equipment> equipment = new HashMap<>();

    public List<Item> getInventory() {
        return inventory;
    }
    public Equipment getEquipment(MountPoint mount){
        return equipment.get(mount);
    }
    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMaxStamina() {
        return maxStamina;
    }
    public int getLevel(){
        return level;
    }

    public Player(String name) {
        this.name = name;
        HP = 100;
        stamina = 100;
        maxStamina = 100;
        maxHP = 100;
        max = 100;
        level = 1;
    }

    public void levelUp() {
        level++;
        this.HP = (int) (this.HP * 1.2);
        this.maxHP = (int) (this.maxHP * 1.2);
        this.stamina = (int) (this.stamina * 1.2);
        this.maxStamina = (int) (this.maxStamina * 1.2);
    }

    public void addItem(Item e) {
        inventory.add(e);
    }

    public void equip(MountPoint m, int pos){
        if(equipment.get(m) == null) {
             equipment.put(m, (Equipment) inventory.get(pos));

        }
        else{
            inventory.add((Item) equipment.get(m));
            equipment.put(m, (Equipment) inventory.get(pos));
        }
    }

    public int compareTo(Player f) {
        if (level == f.level) {
            if (inventory.size() == f.inventory.size())
                return 0;
            else if(inventory.size() >= f.inventory.size())
                return 1;
            else
            return -1;
        }
        else if (level > f.level)
            return 1;
        else
            return -1;
    }

    public static Weapon findBestWeapon(List<Player> playerList){
        int max = 0, min = 0;
        Weapon weapon, finalWeapon = null;
        for (Player player : playerList) {
            for (Item item : player.inventory) {
                if (item instanceof Weapon) {
                    weapon = (Weapon) item;
                    if(weapon.maxAttack > max){
                        max = weapon.maxAttack;
                        min = weapon.minAttack;
                        finalWeapon = weapon;
                    }
                    else if(weapon.maxAttack == max){
                        if(weapon.minAttack > min){
                            min = weapon.minAttack;
                            finalWeapon = weapon;
                        }
                    }
                }
            }
        }
    return finalWeapon;
    }
}

