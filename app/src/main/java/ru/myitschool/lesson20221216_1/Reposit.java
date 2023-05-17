package ru.myitschool.lesson20221216_1;

import java.util.Arrays;

public class Reposit {
     public static  Reposit reposit = new Reposit();
    public void addUnit(Unit unit) {
        addItem(unit);
    }

    private Item[] items = new Item[0];


    public Item[] getItems() {
        return items;
    }


    private void addItem(Item item) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = item;
    }
}
