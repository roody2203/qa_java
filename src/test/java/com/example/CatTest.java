package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class CatTest {

    private Cat cat;

    @Before
    public void init() {
    }

    @After
    public void teardown() {
    }

    @Test
    public void testCat() {
        Feline feline = Mockito.mock(Feline.class);

        Cat cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        Feline feline = Mockito.mock(Feline.class);

        Cat cat = new Cat(feline);
        MatcherAssert.assertThat(cat.getSound(), is("Мяу"));
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Cat cat = new Cat(feline);

        ArrayList<String> foods = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));

        Mockito.when(feline.eatMeat()).thenReturn(foods);

        MatcherAssert.assertThat(cat.getFood(), is(foods));
    }



}
