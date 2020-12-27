package model;

public class Biscuit {

    private BiscuitType biscuitType;

    private BiscuitState biscuitState;

    public Biscuit(BiscuitType biscuitType) {
        this.biscuitType = biscuitType;
        this.biscuitState = BiscuitState.RAW;
    }

    public BiscuitState getBiscuitState() { return this.biscuitState; }

    public void setBiscuitState(BiscuitState biscuitState) {
        this.biscuitState = biscuitState;
    }
}
