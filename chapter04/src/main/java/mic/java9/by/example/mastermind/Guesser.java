package mic.java9.by.example.mastermind;

public abstract class Guesser {
    public static final Color[] none = new Color[]{Color.none};
    protected final Table table;
    private final ColorManager manager;
    protected final Color[] lastGuess;

    public Guesser(Table table) {
        this.table = table;
        this.lastGuess = new Color[table.nrColumns];
        this.manager = table.manager;
    }

    abstract protected void setFirstGuess();

    protected Color[] nextGuess() {
        if (lastGuess[0] == null) {
            setFirstGuess();
            return lastGuess;
        } else {
            return nextNonFirstGuess();
        }
    }

    private Color[] nextNonFirstGuess() {
        int i = 0;
        boolean guessFound = false;
        while (i < table.nrColumns && !guessFound) {
            if (manager.thereIsNextColor(lastGuess[i])) {
                guessFound = true;
            } else {
                lastGuess[i] = manager.firstColor();
                i++;
            }
        }
        if (guessFound) {
            return lastGuess;
        } else {
            return none;
        }
    }

    private boolean guessMatch(Color[] guess) {
        for (Row row : table.rows) {
            if (!row.guessMatches(guess)) {
                return false;
            }
        }
        return true;
    }

    private boolean guessDoesNotMatch(Color[] guess) {
        return !guessMatch(guess);
    }

    public Row guess() {
        Color[] guess = nextGuess();
        while (guess != none && guessDoesNotMatch(guess)) {
            guess = nextGuess();
        }
        if (guess == none) {
            return Row.none;
        } else {
            return new Row(guess);
        }
    }
}
