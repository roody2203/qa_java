package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LionAlex extends Lion {

    public LionAlex(IFeline iFeline) throws Exception {
        super(iFeline, "Самец");
    }

    public List<String> getFriends() {
        return new ArrayList<>(Arrays.asList("Марти", "Глория", "Мелман"));
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }

}
