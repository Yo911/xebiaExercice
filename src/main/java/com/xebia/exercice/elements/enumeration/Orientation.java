package com.xebia.exercice.elements.enumeration;

import com.xebia.exercice.elements.Mower;

public enum Orientation {

    N("NORTH") {
        @Override
        public Orientation goRight() {
            return Orientation.E;
        }

        @Override
        public Orientation goLeft() {
            return Orientation.W;
        }

        @Override
        public void move(Mower mower) {
            int y = mower.getPositionY();
            if( y < mower.getGrass().getMaxY() )
                mower.setPositionY(++y);
        }
    },
    S("SOUTH") {
        @Override
        public Orientation goRight() {
            return Orientation.W;
        }

        @Override
        public Orientation goLeft() {
            return Orientation.E;
        }

        @Override
        public void move(Mower mower) {
            int y = mower.getPositionY();
            if( y > 0 )
            mower.setPositionY(--y);
        }
    },
    E("EAST") {
        @Override
        public Orientation goRight() {
            return Orientation.S;
        }

        @Override
        public Orientation goLeft() {
            return Orientation.N;
        }

        @Override
        public void move(Mower mower) {
            int x = mower.getPositionX();
            if( x < mower.getGrass().getMaxX() )
                mower.setPositionX(++x);
        }
    },
    W("WEST") {
        @Override
        public Orientation goRight() {
            return Orientation.N;
        }

        @Override
        public Orientation goLeft() {
            return Orientation.S;
        }

        @Override
        public void move(Mower mower) {
            int x = mower.getPositionX();
            if( x > 0 )
                mower.setPositionX(--x);
        }
    };

    private String cardinal;

    Orientation(String cardinal) {
        this.cardinal = cardinal;
    }

    public abstract Orientation goRight();

    public abstract Orientation goLeft();

    public abstract void move(Mower mower);

}
