package com.xebia.exercice.elements;

import com.xebia.exercice.elements.enumeration.Orientation;

public class Mower {

    private int positionX;
    private int positionY;
    private Orientation orientation;
    private Grass grass;

    public Mower(int positionX, int positionY, Orientation orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public Mower(int positionX, int positionY, String orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = Orientation.valueOf(orientation);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Grass getGrass() {
        return grass;
    }

    public void setGrass(Grass grass) {
        this.grass = grass;
    }

}
