package com.askme.arun.myapplication;

import com.askme.arun.myapplication.model.Item;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    Item myItem;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void validateItemPrice() throws Exception {
        myItem = new Item();
        myItem.setPrice(null);
        assertEquals(myItem.getPrice(), "N/A");
        myItem.setPrice("null");
        assertEquals(myItem.getPrice(), "N/A");
        myItem.setPrice("");
        assertEquals(myItem.getPrice(), "N/A");
        myItem.setPrice("abcd");
        assertEquals(myItem.getPrice(), "abcd");
        myItem.setPrice("86.3453");
        assertEquals(myItem.getPrice(), "86.3453");
    }

    @Test
    public void validateItemTitle() throws Exception {
        myItem = new Item();
        myItem.setTitle(null);
        assertEquals(myItem.getTitle(), "N/A");
        myItem.setTitle("null");
        assertEquals(myItem.getTitle(), "N/A");
        myItem.setTitle("");
        assertEquals(myItem.getTitle(), "N/A");
        myItem.setTitle("abcd");
        assertEquals(myItem.getTitle(), "abcd");
        myItem.setTitle("8585.45646");
        assertEquals(myItem.getTitle(), "8585.45646");
    }

    @Test
    public void validateItemSummary() throws Exception {
        myItem = new Item();
        myItem.setSummary(null);
        assertEquals(myItem.getSummary(), "N/A");
        myItem.setSummary("null");
        assertEquals(myItem.getSummary(), "N/A");
        myItem.setSummary("");
        assertEquals(myItem.getSummary(), "N/A");
        myItem.setSummary("abcd");
        assertEquals(myItem.getSummary(), "abcd");
        myItem.setSummary("983459384.9877984");
        assertEquals(myItem.getSummary(), "983459384");
    }
}