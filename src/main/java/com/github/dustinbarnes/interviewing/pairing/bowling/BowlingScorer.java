package com.github.dustinbarnes.interviewing.pairing.bowling;

import java.util.List;

public class BowlingScorer
{
    public int scoreGame(List<Integer> pins)
    {
        int idx = 0;
        int score = 0;

        for (int frame = 1; frame <= 10; frame++) {

            if (pins.get(idx) == 10) {
                score += pins.get(idx);
                if (idx + 1 < pins.size()) score += pins.get(idx + 1);
                if (idx + 2 < pins.size()) score += pins.get(idx + 2);

                idx += 1;
            } else if (pins.get(idx) + pins.get(idx + 1) == 10) {
                score += pins.get(idx);
                if (idx + 1 < pins.size()) score += pins.get(idx + 1);
                if (idx + 2 < pins.size()) score += pins.get(idx + 2);

                idx += 2;
            } else {
                score += pins.get(idx);
                if (idx + 1 < pins.size()) score += pins.get(idx + 1);

                idx += 2;
            }
        }

        return score;
    }
}
