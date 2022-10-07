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
                case Item.AGED_BRIE:
                    if (item.sellIn < 0) {
                        Item.updateQuality(item, 2);
                    } else {
                        Item.updateQuality(item, 1);
                    }
                    break;
                case Item.BACKSTAGE_PASSES:
                    int add = 1;

                    if (item.sellIn < 10) {
                        add++;
                    }

                    if (item.sellIn < 5) {
                        add++;
                    }

                    Item.updateQuality(item, add);

                    if (item.sellIn < 0) {
                        item.quality = Item.BORNE_MIN_QUALITY;
                    }

                    break;
                case Item.SULFURAS:break;
                case Item.CONJURED:
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
