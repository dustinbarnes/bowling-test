package com.dynacron.pairing.bowling;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BowlingTest
{
    private BowlingScorer scorer = new BowlingScorer();

    @Test
    public void testPerfectGame()
    {
        List<Integer> pins = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        Assert.assertEquals(300, scorer.scoreGame(pins));
    }

    @Test
    public void testTerribleGame()
    {
        List<Integer> pins = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assert.assertEquals(0, scorer.scoreGame(pins));
    }

    @Test
    public void testOnlySparesGame()
    {
        List<Integer> pins = Arrays.asList(0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0);
        Assert.assertEquals(100, scorer.scoreGame(pins));
    }

    @Test
    public void testManySparesGame()
    {
        List<Integer> pins = Arrays.asList(0, 10, 0, 10, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assert.assertEquals(45, scorer.scoreGame(pins));
    }

    @Test(expected=InvalidGameException.class)
    public void testInvalidGame()
    {
        List<Integer> pins = Arrays.asList(0, 0, 0, 10, 0, 10);
        scorer.scoreGame(pins);
        Assert.fail("Should be invalid");
    }

}
