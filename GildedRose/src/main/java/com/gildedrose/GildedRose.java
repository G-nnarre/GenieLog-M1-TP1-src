package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item:this.items) {
            item.sellIn--;
            switch (item.name) {
                case "Aged Brie":
                    if (item.sellIn < 0) {
                        Item.updateQuality(item, 2);
                    } else {
                        Item.updateQuality(item, 1);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    int add = 1;

                    if (item.sellIn < 10) {
                        add++;
                    }

                    if (item.sellIn < 5) {
                        add++;
                    }

                    if (item.sellIn > 0) {
                        Item.updateQuality(item, add);
                    } else {
                        item.quality = 0;
                    }

                    break;
                case "Sulfuras, Hand of Ragnaros":break;
                case "Conjured":
                    int substract = -2;
                    if (item.sellIn < 0) {
                        substract*=2;
                    }
                    Item.updateQuality(item, substract);

                    break;
                default:
                    int sub = -1;
                    if (item.sellIn < 0) {
                        sub--;
                    }
                    Item.updateQuality(item, sub);

                    break;
            }


        }
    }
}
