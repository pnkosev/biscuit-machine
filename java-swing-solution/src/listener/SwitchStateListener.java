package listener;

import model.SwitchPosition;

public interface SwitchStateListener {

    void switchChanged(SwitchPosition switchPosition);
}
