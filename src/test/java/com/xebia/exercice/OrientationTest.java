package com.xebia.exercice;

import com.xebia.exercice.elements.enumeration.Orientation;
import org.junit.Assert;
import org.junit.Test;

public class OrientationTest {


    @Test
    public void testCardinal() {

        Orientation orientation = Orientation.N;
        Assert.assertEquals( orientation.goLeft(), Orientation.W );
        Assert.assertEquals( orientation.goRight(), Orientation.E );

        orientation = Orientation.S;
        Assert.assertEquals( orientation.goLeft(), Orientation.E );
        Assert.assertEquals( orientation.goRight(), Orientation.W );

        orientation = Orientation.E;
        Assert.assertEquals( orientation.goLeft(), Orientation.N );
        Assert.assertEquals( orientation.goRight(), Orientation.S );

        orientation = Orientation.W;
        Assert.assertEquals( orientation.goLeft(), Orientation.S );
        Assert.assertEquals( orientation.goRight(), Orientation.N );
    }

}
