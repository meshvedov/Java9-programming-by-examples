package mic.java9.by.example.mastermind;

import java.util.HashMap;
import java.util.Map;

public class ColorManager {
    protected final int nrColors;
    private final ColorFactory factory;
    protected final Map<Color, Color> successor = new HashMap<>();
    private Color first;

    public ColorManager(int nrColors, ColorFactory factory) {
        this.nrColors = nrColors;
        this.factory = factory;
        createOrdering();
    }

    private void createOrdering() {
        Color[] colors = createColors();
        first = colors[0];
        for (int i = 0; i < nrColors - 1; i++) {
            successor.put(colors[i], colors[i + 1]);
        }
    }

    private Color[] createColors() {
        Color[] colors = new Color[nrColors];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = factory.newColor();
        }
        return colors;
    }

    public boolean thereIsNextColor(Color color) {
        return successor.containsKey(color);
    }

    public Color nextColor(Color color) {
        return successor.get(color);
    }

    public int getNrColors() {
        return nrColors;
    }

    public Color firstColor() {
        return first;
    }
}
