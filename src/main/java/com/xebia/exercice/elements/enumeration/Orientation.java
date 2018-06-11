package com.xebia.exercice.elements.enumeration;

public enum Orientation {

    N("NORTH"),
    S("S"),
    E("E"),
    W("W");

    private String cardinal;

    Orientation(String cardinal) {
        this.cardinal = cardinal;
    }

}
