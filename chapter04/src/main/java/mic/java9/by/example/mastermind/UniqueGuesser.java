package mic.java9.by.example.mastermind;

import java.util.HashSet;
import java.util.Set;

public class UniqueGuesser extends Guesser {

    public UniqueGuesser(Table table) {
        super(table);
    }

    @Override
    protected void setFirstGuess() {
        int i = lastGuess.length - 1;
        for (Color color = table.manager.firstColor(); i >= 0; color = table.manager.nextColor(color)) {
            lastGuess[i--] = color;
        }
    }

    private boolean isNotUnique(Color[] guess) {
        final Set<Color> alreadyPresent = new HashSet<>();
        for (Color color : guess) {
            if (alreadyPresent.contains(color)) {
                return true;
            }
            alreadyPresent.add(color);
        }
        return false;
    }

    @Override
    protected Color[] nextGuess() {
        Color[] guess = super.nextGuess();
        while (isNotUnique(guess)) {
            guess = super.nextGuess();
        }
        return guess;
    }
}
