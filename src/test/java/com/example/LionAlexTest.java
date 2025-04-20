package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

public class LionAlexTest {

    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @After
    public void teardown() {
    }

    @Test
    public void testLionAlex() {
        try {
            LionAlex lionAlex = new LionAlex(feline);
        } catch(Exception e) {
            fail("Конструктор класса LionAlex выбросил исключение " + e.getClass().getSimpleName());
        }
    }

    @Test
    public void testGetFriends() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);

        ArrayList<String> friends = new ArrayList<>(Arrays.asList("Марти", "Глория", "Мелман"));

        MatcherAssert.assertThat("Метод getFriends должен вернуть " + friends, lionAlex.getFriends(), is(friends));
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);

        String placeOfLiving = "Нью-Йоркский зоопарк";

        MatcherAssert.assertThat("Метод getPlaceOfLiving должен вернуть " + placeOfLiving, lionAlex.getPlaceOfLiving(), is(placeOfLiving));
    }

    @Test
    public void testGetKittens() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);

        MatcherAssert.assertThat("Метод getKittens должен вернуть 0", lionAlex.getKittens(), is(0));
    }
}
