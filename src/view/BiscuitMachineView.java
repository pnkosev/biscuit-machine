package view;

import controller.BiscuitMachineController;
import model.SwitchPosition;
import model.api.Switch;
import model.impl.SwitchImpl;

import javax.swing.*;
import java.awt.*;

public class BiscuitMachineView {

    private Switch aSwitch;

    private JRadioButton onBtn;
    private JRadioButton pauseBtn;
    private JRadioButton offBtn;

    public BiscuitMachineView() {
        aSwitch = new SwitchImpl();
    }

    public void show() {
        JFrame frame = new JFrame("Biscuit Machine");

        Container panel = frame.getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setUpButtons(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public SwitchPosition getSwitchState() {
        return this.aSwitch.getState();
    }

    private void setUpButtons(Container pane) {
        this.onBtn = new JRadioButton("turn on");
        this.onBtn.addActionListener(e -> this.aSwitch.turnOn());

        this.pauseBtn = new JRadioButton("pause");
        this.pauseBtn.addActionListener(e -> this.aSwitch.pause());

        this.offBtn = new JRadioButton("turn off");
        this.offBtn.addActionListener(e -> this.aSwitch.turnOff());
        this.offBtn.doClick();

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(onBtn);
        btnGroup.add(pauseBtn);
        btnGroup.add(offBtn);

        pane.add(onBtn);
        pane.add(pauseBtn);
        pane.add(offBtn);
    }
}
