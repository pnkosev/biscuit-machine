package model;

public class Biscuit {

    private BiscuitType biscuitType;

    private BiscuitState biscuitState;

    public Biscuit(BiscuitType biscuitType) {
        this.biscuitType = biscuitType;
        this.biscuitState = BiscuitState.RAW;
    }

    public void setBiscuitState(BiscuitState biscuitState) {
        this.biscuitState = biscuitState;
    }
}
