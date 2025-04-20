package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {
    private Feline feline;

    @Before
    public void init() {
        feline = Mockito.mock(Feline.class);
    }

    @After
    public void teardown() {
    }

    @Test
    public void testLionInvalidSex() {
        Exception thrown = assertThrows(Exception.class, () -> new Lion(feline, "Детеныш"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
    }


    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");

        ArrayList<String> foods = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));

        Mockito.when(feline.getFood("Хищник")).thenReturn(foods);

        MatcherAssert.assertThat("Метод getFood должен вернуть " + foods, lion.getFood(), is(foods));
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");

        Mockito.when(feline.getKittens()).thenReturn(1);

        MatcherAssert.assertThat("Метод getKittens должен вернуть 1", lion.getKittens(), is(1));
    }

}