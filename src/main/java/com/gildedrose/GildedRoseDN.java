package com.gildedrose;

class GildedRoseDN {
    Item[] items;

    public GildedRoseDN(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1; // for normal prod (incl Conjured)reduce 1 
                        if (items[i].name.equals("Conjured Mana Cake")) //Added
                        	items[i].quality = (items[i].quality - 1)< 0?0:items[i].quality - 1; // Added -reduce one more for Conjured
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1; // for Aged Brie and concert

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            } // end of else

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            } //for all product sellin decreases except SUlphur

            // after expiry calculation
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1; // all except sulfur(incl Conjured) // after expiry 2nd deduction
                                
                                if (items[i].name.equals("Conjured Mana Cake"))  /// Added 
                                	items[i].quality = (items[i].quality - 1)< 0?0:items[i].quality - 1;//Added
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;// for concert 0
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1; // Aged Brie keep increasing till 50
                    }
                }
            }
        } // end for loop
    }
}
