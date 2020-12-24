package model;

public class Stamper {

    public void stamp(Biscuit biscuit) {

//        System.out.println("Cookie stamped!");
        biscuit.setBiscuitState(BiscuitState.STAMPED);
    }
}
