package test;

import logic.TriangleHelper;
import org.junit.Test;
import org.junit.Assert;


public class TriangleHelperTest {

    @Test
    public void testIsValidTraingle_PostitveCase() {
        Assert.assertTrue(TriangleHelper.isValidTriangle(2,2,3));
    }

    @Test
    public void testIsValidTraingle_PostitveCaseRight() {
        Assert.assertTrue(TriangleHelper.isValidTriangle(3,4,5));
    }

    @Test
    public void testIsValidTraingle_NegativeCase() {
        Assert.assertFalse(TriangleHelper.isValidTriangle(1,2,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidTraingle_InvalidNegativeFirstLengthCase() {
        TriangleHelper.isValidTriangle(-1,2,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidTraingle_InvalidNegativeSecondLengthCase() {
        TriangleHelper.isValidTriangle(2,-2,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidTraingle_InvalidNegativeThirdLengthCase() {
        TriangleHelper.isValidTriangle(2,2,-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidTraingle_InvalidZeroFirstLengthCase() {
        TriangleHelper.isValidTriangle(0,2,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidTraingle_InvalidZeroSecondLengthCase() {
        TriangleHelper.isValidTriangle(2,0,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidTraingle_InvalidZeroThirdLengthCase() {
        TriangleHelper.isValidTriangle(2,2,0);
    }

}
