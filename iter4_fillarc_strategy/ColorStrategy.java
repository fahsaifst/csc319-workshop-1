package iter4_fillarc_strategy;
import java.awt.*;

public abstract class ColorStrategy {
    protected Color[] colors;

    public ColorStrategy(){
        colors = new Color[4];
    }

    public Color getColor(int idx) {
        return colors[idx];
    }
}
