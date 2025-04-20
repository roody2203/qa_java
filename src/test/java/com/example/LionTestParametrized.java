
    package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionTestParametrized {

    private Feline feline;

    private final String sex;
    private final boolean hasMane;


    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    public LionTestParametrized(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void init() {
        feline = Mockito.mock(Feline.class);
    }

    @After
    public void teardown() {
    }

    @Test
    public void testLion() {
        try {
            Lion lion = new Lion(feline, sex);
        } catch (Exception e) {
            fail("Конструктор класса Lion выбросил исключение " + e.getClass().getSimpleName());
        }
    }

    @Test
    public void testDoesHasMane() throws Exception {
         Lion lion = new Lion(feline, sex);

        MatcherAssert.assertThat("Метод doesHasMane должен вернуть " + hasMane, lion.doesHaveMane(), is(hasMane));
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, sex);

        Mockito.when(feline.getKittens()).thenReturn(1);

        MatcherAssert.assertThat("Метод getKittens должен вернуть 1", lion.getKittens(), is(1));
    }
}
