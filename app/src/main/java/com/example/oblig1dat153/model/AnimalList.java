package com.example.oblig1dat153.model;

import com.example.oblig1dat153.R;

import java.util.ArrayList;
import java.util.List;

public class AnimalList {

    List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        getAnimals().add(animal);
    }

    public void deleteAnimal(int position) {
        animals.remove(position);
    }

    public int getSize() {
        return animals.size();
    }

    private static final AnimalList holder = new AnimalList();

    public static AnimalList getInstance() {

        return holder;
    }


}
