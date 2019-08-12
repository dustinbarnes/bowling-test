package com.github.dustinbarnes.interviewing.pairing.bowling;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BowlingTest
{
    private BowlingScorer scorer = new BowlingScorer();

    @Test
    public void testPerfectGame() {
        List<Integer> pins = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        Assert.assertEquals(300, scorer.scoreGame(pins));
    }

    @Test
    public void testTerribleGame() {
        List<Integer> pins = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assert.assertEquals(0, scorer.scoreGame(pins));
    }

    @Test
    public void testOnlySparesGame() {
        List<Integer> pins = Arrays.asList(0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0);
        Assert.assertEquals(100, scorer.scoreGame(pins));
    }

    @Test
    public void testNoSpecialCases() {
        List<Integer> pins = Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4);
        Assert.assertEquals(80, scorer.scoreGame(pins));
    }

    @Test
    public void testNormalishGame() {
        List<Integer> pins = Arrays.asList(9, 1, 0, 10, 10, 10, 6, 2, 7, 3, 8, 2, 10, 9, 0, 9, 1, 10);
        Assert.assertEquals(168, scorer.scoreGame(pins));
    }

    @Test
    public void testNormalishGame2() {
        List<Integer> pins = Arrays.asList(4, 3 , 10 , 4, 5, 1, 3, 0, 4, 2, 5, 8, 0, 9, 1, 6, 2, 2,3);
        Assert.assertEquals(87, scorer.scoreGame(pins));
    }

    @Test
    public void testManySparesGame() {
        List<Integer> pins = Arrays.asList(0, 10, 0, 10, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assert.assertEquals(45, scorer.scoreGame(pins));
    }

    @Test(expected=InvalidGameException.class)
    public void testInvalidGame() {
        List<Integer> pins = Arrays.asList(0, 0, 0, 10, 0, 10);
        scorer.scoreGame(pins);
        Assert.fail("Should be invalid");
    }

}
