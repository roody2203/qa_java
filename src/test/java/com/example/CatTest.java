package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

public class CatTest {

    private Feline feline;

    @Before
    public void init() {
        feline = Mockito.mock(Feline.class);
    }

    @After
    public void teardown() {
    }

    @Test
    public void testCat() {
        try{
            Cat cat = new Cat(feline);
        } catch(Exception e) {
            fail("Конструктор класса Cat выбросил исключение " + e.getClass().getSimpleName());
        }
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        MatcherAssert.assertThat("Метод getSound должен возвращать строку 'Мяу'", cat.getSound(), is("Мяу"));
    }

    @Test
    public void testGetFood() throws Exception {
         Cat cat = new Cat(feline);

        ArrayList<String> foods = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));

        Mockito.when(feline.eatMeat()).thenReturn(foods);

        MatcherAssert.assertThat("Метод getFood должен вернуть " + foods, cat.getFood(), is(foods));
    }
}
