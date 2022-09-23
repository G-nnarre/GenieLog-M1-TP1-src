package com.gildedrose;

import org.junit.jupiter.api.*;
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
  @DisplayName("Test that the name is unchanged")
  void testNameToString() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.toString(), is("foo, -1, 0"));
  }
  @Test
  @DisplayName("test lambda item for quality reduction")
  void testLambdaQualityReduction() {
    Item element = new Item("foo", 0, 1);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("test lambda item for quality reduction sellin past")
  void testLambdaQualityReductionSellinNeg() {
    Item element = new Item("foo", -3, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("test lambda item for quality reduction sellin past")
  void testLambdaQualityReductionSellinaAt0() {
    Item element = new Item("foo", 1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(1));
  }


  @Test
  @DisplayName("test aged brie item for quality augmentation")
  void testBrieQualityAugmentation() {
    Item element = new Item("Aged Brie", 2, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(1));
  }

  @Test
  @DisplayName("test aged brie item for quality augmentation over sellin")
  void testBrieQualityAugmentationPastSellin() {
    Item element = new Item("Aged Brie", -1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(2));
  }

  @Test
  @DisplayName("test aged brie item for quality augmentation over sellin but at max quality")
  void testBrieQualityAugmentationPastSellinMax() {
    Item element = new Item("Aged Brie", -1, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("test aged brie item for quality augmentation if at max quality")
  void testBrieQualityAugmentationMax() {
    Item element = new Item("Aged Brie", 2, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("test sulfuras item for quality ")
  void testSulfurasQuality() {
    int quality = 80;
    Item element = new Item("Sulfuras, Hand of Ragnaros", 2, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality));
  }

  @Test
  @DisplayName("test sulfuras item for quality sellin negative")
  void testSulfurasQualitySellinNeg() {
    int quality = 80;
    Item element = new Item("Sulfuras, Hand of Ragnaros", -4, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality));
  }

  @Test
  @DisplayName("test Backstage passes to a TAFKAL80ETC concert item for quality augmentation 15 day before ")
  void testBackstage15DayBefore() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(3));
  }

  @Test
  @DisplayName("test Backstage passes to a TAFKAL80ETC concert item for quality augmentation 11 day before ")
  void testBackstage11DayBefore() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(3));
  }
  @Test
  @DisplayName("test Backstage passes to a TAFKAL80ETC concert item for quality augmentation 10 day before ")
  void testBackstage10DayBefore() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(4));
  }
  @Test
  @DisplayName("test Backstage passes to a TAFKAL80ETC concert item for quality augmentation 10 day before ")
  void testBackstage10DayBeforeMax() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("test Backstage passes to a TAFKAL80ETC concert item for quality augmentation 6 day before ")
  void testBackstage6DayBefore() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(4));
  }
  @Test
  @DisplayName("test Backstage passes to a TAFKAL80ETC concert item for quality augmentation 5 day before ")
  void testBackstage5DayBefore() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(5));
  }

  @Test
  @DisplayName("test Backstage passes to a TAFKAL80ETC concert item for quality augmentation 5 day before at max ")
  void testBackstage5DayBeforeMax() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("test Backstage passes to a TAFKAL80ETC concert item for quality after the concert ")
  void testBackstagePastConcert() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }





}
