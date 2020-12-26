package view;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private JTextField ovenTemperature;
    private JTextField biscuitCount;
    private JLabel ovenLabel;
    private JLabel biscuitLabel;

    public InfoPanel() {
        this.ovenLabel = new JLabel("Oven temperature: ");
        this.ovenTemperature = new JTextField(3);

        this.biscuitLabel = new JLabel("Biscuit count: ");
        this.biscuitCount = new JTextField(3);

        ovenTemperature.setEnabled(false);
        biscuitCount.setEnabled(false);

        this.layoutComponents();
    }

    public void setOvenTemperature(int temperature) {
        this.ovenTemperature.setText(String.valueOf(temperature));
    }

    public void setBiscuitCount(int count) {
        this.biscuitCount.setText(String.valueOf(count));
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // First row

        gbc.gridy = 0;

        gbc.weightx = 1;
        gbc.weighty = 0.1;

        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(this.ovenLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(this.ovenTemperature, gbc);

        // Next row

        gbc.gridy++;

        gbc.weightx = 1;
        gbc.weighty = 0.1;

        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(this.biscuitLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(this.biscuitCount, gbc);
    }
}