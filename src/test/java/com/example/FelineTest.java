package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class FelineTest {


    @Before
    public void init() {
    }

    @After
    public void teardown() {
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = Mockito.spy(Feline.class);

        ArrayList<String> foods = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));

        Mockito.when(feline.getFood("Хищник")).thenReturn(foods);

        MatcherAssert.assertThat(feline.eatMeat(), is(foods));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();

        MatcherAssert.assertThat(feline.getFamily(), is("Кошачьи"));
    }

    @Test
    public void testGetKittensWithoutArguments() {
        Feline feline = Mockito.spy(Feline.class);

        MatcherAssert.assertThat(feline.getKittens(), is(1));

        Mockito.verify(feline, Mockito.times(1)).getKittens(1);

    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();

        MatcherAssert.assertThat(feline.getKittens(1), is(1));
    }

}
