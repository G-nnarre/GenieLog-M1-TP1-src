package com.gildedrose;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test the toString")
  void testNameToString() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.toString(), is("foo, -1, 0"));
  }

  @ParameterizedTest
  @CsvSource({"foo,0,0,0"
          ,"foo,-3,2,0"
          ,"foo,1,2,1"
          ,"Aged Brie,2,0,1"
          ,"Aged Brie,-1,0,2"
          ,"Aged Brie,-1,49,50"
          ,"Aged Brie,2,50,50"
          ,"'Sulfuras, Hand of Ragnaros',2,80,80"
          ,"'Sulfuras, Hand of Ragnaros',-4,80,80"
          ,"Backstage passes to a TAFKAL80ETC concert,15,2,3"
          ,"Backstage passes to a TAFKAL80ETC concert,11,2,3"
          ,"Backstage passes to a TAFKAL80ETC concert,10,2,4"
          ,"Backstage passes to a TAFKAL80ETC concert,10,49,50"
          ,"Backstage passes to a TAFKAL80ETC concert,6,2,4"
          ,"Backstage passes to a TAFKAL80ETC concert,5,2,5"
          ,"Backstage passes to a TAFKAL80ETC concert,5,49,50"
          ,"Backstage passes to a TAFKAL80ETC concert,-1,50,0"
  })
  void testGeneral(String itemName,int sellin,int quality,int expected){
    Item element = new Item(itemName, sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(expected));
  }
}
