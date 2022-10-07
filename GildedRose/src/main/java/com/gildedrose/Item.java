package com.gildedrose;

public class Item {


    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";


    public static final int BORNE_MAX_QUALITY = 50;
    public static final int BORNE_MIN_QUALITY = 0;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    static void updateQuality(Item item, int i) {
        item.quality += i;
        if (item.quality > Item.BORNE_MAX_QUALITY-1) {
            item.quality = 50;
        }
        if (item.quality < Item.BORNE_MIN_QUALITY+1) {
            item.quality = 0;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
