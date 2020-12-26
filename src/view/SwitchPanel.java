package view;

import listener.SwitchStateListener;
import model.SwitchPosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchPanel extends JPanel implements ActionListener {

    private JRadioButton onBtn;
    private JRadioButton pauseBtn;
    private JRadioButton offBtn;

    private SwitchStateListener listener;

    public SwitchPanel() {
        this.setUpButtons();
    }

    private void setUpButtons() {
        this.onBtn = new JRadioButton("turn on");
        this.onBtn.addActionListener(this);

        this.pauseBtn = new JRadioButton("pause");
        this.pauseBtn.addActionListener(this);

        this.offBtn = new JRadioButton("turn off");
        this.offBtn.addActionListener(this);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(this.onBtn);
        btnGroup.add(this.pauseBtn);
        btnGroup.add(this.offBtn);
        this.offBtn.doClick();

        setLayout(new BorderLayout());

        add(this.onBtn, BorderLayout.NORTH);
        add(this.pauseBtn, BorderLayout.CENTER);
        add(this.offBtn, BorderLayout.SOUTH);
    }

    public void setListener(SwitchStateListener listener) { this.listener = listener; }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.listener != null) {
            JRadioButton btnClicked = (JRadioButton) e.getSource();

            if (btnClicked == this.onBtn) {
                this.listener.switchChanged(SwitchPosition.ON);
            } else if (btnClicked == this.pauseBtn) {
                this.listener.switchChanged(SwitchPosition.PAUSED);
            } else if (btnClicked == this.offBtn) {
                this.listener.switchChanged(SwitchPosition.OFF);
            }
        }
    }
}
