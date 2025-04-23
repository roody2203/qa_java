
    package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;

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

    @Test
    public void testDoesHasMane() throws Exception {
        Lion lion = new Lion(feline, sex);

        MatcherAssert.assertThat("Метод doesHasMane должен вернуть " + hasMane, lion.doesHaveMane(), is(hasMane));
    }
}


