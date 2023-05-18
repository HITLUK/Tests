package ru.myitschool.lesson20221216_1;

import java.util.Arrays;

public class Reposit {
     public static  Reposit reposit = new Reposit();
    public void addUnit(Unit unit) {
        addItem(unit);
    }

    private Item[] items = new Item[0];
public Unit getUnit(int i) {
    return (Unit) items[i];
}

    public Item[] getItems() {
        return items;
    }
public void setUnit(Item unit,int i) {setItem(unit,i);}
    public void setItem(Item item,int i) {
        items[i] = item;

    }

    private void addItem(Item item) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = item;
    }
}
