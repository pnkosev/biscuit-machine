package view;

import model.SwitchPosition;

import javax.swing.*;
import java.awt.*;

public class BiscuitMachineView extends JFrame {

    private SwitchPanel switchPanel;
    private InfoPanel infoPanel;

    private SwitchPosition switchPosition;

    public BiscuitMachineView(String title) {
        super(title);

        this.switchPanel = new SwitchPanel();
        this.infoPanel = new InfoPanel();
        this.switchPosition = SwitchPosition.OFF;
    }

    public void showGUI() {

        this.switchPanel.setListener(switchPosition -> {
            this.switchPosition = switchPosition;
        });

        setLayout(new BorderLayout());
        add(this.switchPanel, BorderLayout.NORTH);
        add(this.infoPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public SwitchPosition getSwitchPosition() {
        return this.switchPosition;
    }

    public void updateOvenTemperature(int temperature) {
        this.infoPanel.setOvenTemperature(temperature);
    }

    public void updateBiscuitCount(int biscuits) {
        this.infoPanel.setBiscuitCount(biscuits);
    }
}
