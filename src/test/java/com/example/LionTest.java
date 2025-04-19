package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean isValid;
    private final boolean hasMane;


    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Самец", true, true},
                {"Самка", true, false},
                {"Детеныш", false, false},
        };
    }

    public LionTest(String sex, boolean isValid, boolean hasMane) {
        this.sex = sex;
        this.isValid = isValid;
        this.hasMane = hasMane;
    }

    @Before
    public void init() {
    }

    @After
    public void teardown() {
    }

    @Test
    public void testLion() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        boolean isException = false;

        try {
            Lion lion = new Lion(feline, sex);
        } catch (Exception exception) {
            isException = true;
        }

        MatcherAssert.assertThat(!(isException), is(isValid));
    }


    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion(feline, "Самец");

        ArrayList<String> foods = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));

        Mockito.when(feline.getFood("Хищник")).thenReturn(foods);

        MatcherAssert.assertThat(lion.getFood(), is(foods));
    }

    @Test
    public void testDoesHasMane() throws Exception {
        if(!isValid)
        {
            return;
        }

        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion(feline, sex);

        MatcherAssert.assertThat(lion.doesHaveMane(), is(hasMane));
    }

    @Test
    public void testGetKittens() throws Exception {
        if(!isValid)
        {
            return;
        }
        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion(feline, sex);

        Mockito.when(feline.getKittens()).thenReturn(1);

        MatcherAssert.assertThat(lion.getKittens(), is(1));
    }

}