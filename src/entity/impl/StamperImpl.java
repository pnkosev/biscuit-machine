package entity.impl;

import entity.api.Stamper;

public class StamperImpl implements Stamper {

    @Override
    public void stamp() {
        System.out.println("Cookie stamped!");
    }
}
