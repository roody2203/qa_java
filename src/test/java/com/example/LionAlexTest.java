package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
public class LionAlexTest {

    @Before
    public void init() {
    }

    @After
    public void teardown() {
    }

    @Test
    public void testLionAlex() throws Exception {
        Feline feline = new Feline();

        LionAlex lionAlex = new LionAlex(feline);
    }

    @Test
    public void testGetFriends() throws Exception {
        Feline feline = new Feline();

        LionAlex lionAlex = new LionAlex(feline);

        ArrayList<String> friends = new ArrayList<>(Arrays.asList("Марти", "Глория", "Мелман"));

        MatcherAssert.assertThat(lionAlex.getFriends(), is(friends));
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        Feline feline = new Feline();

        LionAlex lionAlex = new LionAlex(feline);

        String placeOfLiving = "Нью-Йоркский зоопарк";

        MatcherAssert.assertThat(lionAlex.getPlaceOfLiving(), is(placeOfLiving));
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline feline = new Feline();

        LionAlex lionAlex = new LionAlex(feline);

        MatcherAssert.assertThat(lionAlex.getKittens(), is(0));
    }
}
