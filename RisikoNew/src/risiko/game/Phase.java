package risiko.game;

import exceptions.LastPhaseException;


public enum Phase {
    PLAY_CARDS, REINFORCE, FIGHT, MOVE;

    private final int value;

    private Phase() {
        this.value = ordinal();
    }

    /**
     * Passa alla fase successiva del turno.
     * @return la fase successiva.
     * @throws LastPhaseException se è l'ultima fase del turno.
     */
    public Phase next() throws LastPhaseException {
        
        try {
            return Phase.values()[this.value+1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new LastPhaseException();
        }
    }
}