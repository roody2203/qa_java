package com.example;

import java.util.List;

public class Lion {
    IFeline iFeline;
    boolean hasMane;

    public Lion(IFeline iFeline, String sex) throws Exception {
        this.iFeline = iFeline;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return iFeline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return iFeline.getFood("Хищник");
    }
}
