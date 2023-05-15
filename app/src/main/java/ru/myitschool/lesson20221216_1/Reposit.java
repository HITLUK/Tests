package ru.myitschool.lesson20221216_1;

import java.util.Arrays;

public class Reposit {
    private Item[] items = new Item[0];
    public void addquestion(Quest.Question question) {addItem((Item) question);}
    public Item[] getItems() {
        return items;
    }
    private void addItem(Item item) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = item;
    }
}
