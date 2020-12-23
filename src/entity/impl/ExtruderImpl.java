package entity.impl;

import entity.api.Extruder;

public class ExtruderImpl implements Extruder {

    @Override
    public void extrude() {
        System.out.println("Cookie extruded!");
    }
}
