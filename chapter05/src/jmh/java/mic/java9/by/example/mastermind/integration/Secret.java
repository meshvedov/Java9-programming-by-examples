package mic.java9.by.example.mastermind.integration;

import mic.java9.by.example.mastermind.Guess;

public interface Secret {
    Guess createSecret(int nrColumns);
}
