package com.example;

import java.util.List;

public interface IFeline extends Predator {

    public List<String> getFood(String animalKind) throws Exception;

    public int getKittens();

    public int getKittens(int kittensCount);
}
