package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();

        ArrayList<String> foods = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));

        MatcherAssert.assertThat("Метод eatMeat должен вернуть " + foods ,feline.eatMeat(), is(foods));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();

        MatcherAssert.assertThat("Метод getFamily должен вернуть строку 'Кошачьи'", feline.getFamily(), is("Кошачьи"));
    }

    @Test
    public void testGetKittensNoArguments() {
        Feline feline = Mockito.spy(Feline.class);

        MatcherAssert.assertThat("Метод getKittens должен вернуть 1", feline.getKittens(), is(1));
    }

    @Test
    public void testGetKittensNoArgumentsCallCount() {
        Feline feline = Mockito.spy(Feline.class);

        feline.getKittens();

        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();

        MatcherAssert.assertThat("Метод getKittens(1) вернул не 1", feline.getKittens(1), is(1));
    }
}
