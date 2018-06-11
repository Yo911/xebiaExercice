package com.xebia.exercice;

import com.xebia.exercice.elements.Grass;
import com.xebia.exercice.elements.Mower;
import com.xebia.exercice.elements.enumeration.Orientation;
import org.junit.Assert;
import org.junit.Test;

public class MowerTest {

    @Test
    public void testMove() {
        Grass grass = new Grass(5, 5);

        Mower mower = new Mower(1,2, "N");
        mower.setGrass(grass);
        mower.move("GAGAGAGAA");

        Assert.assertTrue( mower.getPositionX() == 1 );
        Assert.assertTrue( mower.getPositionY() == 3 );
        Assert.assertEquals( mower.getOrientation(), Orientation.N);

        mower = new Mower(3, 3, "E");
        mower.setGrass(grass);
        mower.move("AADAADADDA");

        Assert.assertTrue( mower.getPositionX() == 5 );
        Assert.assertTrue( mower.getPositionY() == 1 );
        Assert.assertEquals( mower.getOrientation(), Orientation.E);



    }

}
