package mic.java9.by.example.mastermind.lettered;

import mic.java9.by.example.mastermind.Color;
import mic.java9.by.example.mastermind.ColorFactory;

public class LetteredColorFactory implements ColorFactory {
    private static final String letters = "0123456789ABCDEFGHIJKLMNOPQRSTVWXYZabcdefghijklmnopqrstvwxzy";
    private int counter = 0;

    @Override
    public Color newColor() {
        Color color = new LetteredColor(letters.substring(counter, counter + 1));
        counter++;
        return color;
    }
}
