package iter4_fillarc_strategy;

import java.awt.Color;
import java.util.Random;

public class RandomColorStrategy extends ColorStrategy{
    private final Color[] COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.ORANGE, Color.MAGENTA, Color.CYAN};

    private Random rand;

    public RandomColorStrategy(){
        rand = new Random();
        colors[0] = COLORS[rand.nextInt(COLORS.length)];
        colors[1] = COLORS[rand.nextInt(COLORS.length)];
        colors[2] = COLORS[rand.nextInt(COLORS.length)];
        colors[3] = COLORS[rand.nextInt(COLORS.length)];
    }
}
