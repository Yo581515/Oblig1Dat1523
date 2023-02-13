package com.example.oblig1dat153.model;

public class Animal  {
    private ImageItem image;
    private String name;
    private String wrongName1;
    private String wrongName2;

    public Animal(ImageItem image, String name, String wrongName1, String wrongName2) {
        this.image = image;
        this.name = name;
        this.wrongName1 = wrongName1;
        this.wrongName2 = wrongName2;
    }

    public ImageItem getImage() {
        return image;
    }

    public void setImage(ImageItem image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWrongName1() {
        return wrongName1;
    }

    public void setWrongName1(String wrongName1) {
        this.wrongName1 = wrongName1;
    }

    public String getWrongName2() {
        return wrongName2;
    }

    public void setWrongName2(String wrongName2) {
        this.wrongName2 = wrongName2;
    }

    public boolean isCorrectName(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", wrongName1='" + wrongName1 + '\'' +
                ", wrongName2='" + wrongName2 + '\'' +
                '}';
    }
}
