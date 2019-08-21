package com.javarush.task.task20.task2026;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testGetRectangleCount() throws Exception {

        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };

        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        byte[][] a3 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };

        int resultA1 = Solution.getRectangleCount(a1);
        int resultA2 = Solution.getRectangleCount(a2);
        int resultA3 = Solution.getRectangleCount(a3);

        Assert.assertEquals(2, resultA1);
        Assert.assertEquals(4, resultA2);
        Assert.assertEquals(5, resultA3);
    }

    @Test
    public void testGetNextHighLeftCorner() {
        byte[][] a = new byte[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int[] result = Solution.getNextHighLeftCorner(a);
        Assert.assertArrayEquals(new int[]{1, 3}, result);
    }


    @Test
    public void testExcludeRectangle() {
        byte[][] field = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };

        int[] coordinates = new int[]{0, 0};

        byte[][] result = Solution.excludeRectangle(field, coordinates);

        Assert.assertArrayEquals(field, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme