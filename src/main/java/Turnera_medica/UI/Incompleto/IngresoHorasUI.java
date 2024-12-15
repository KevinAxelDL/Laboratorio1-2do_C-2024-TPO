/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Incompleto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author KevinDL
 */
public class IngresoHorasUI {
    public void crear(){
        JFrame frame = new JFrame("Time Input Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Hour Spinner
        SpinnerNumberModel hourModel = new SpinnerNumberModel(12, 0, 23, 1);
        JSpinner hourSpinner = new JSpinner(hourModel);

        // Minute Spinner
        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
        JSpinner minuteSpinner = new JSpinner(minuteModel);

        // Display selected time
        JLabel timeLabel = new JLabel("Selected Time: 12:00");
        hourSpinner.addChangeListener(e -> updateLabel(timeLabel, hourSpinner, minuteSpinner));
        minuteSpinner.addChangeListener(e -> updateLabel(timeLabel, hourSpinner, minuteSpinner));

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Hour:"));
        panel.add(hourSpinner);
        panel.add(new JLabel("Minute:"));
        panel.add(minuteSpinner);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(timeLabel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void updateLabel(JLabel label, JSpinner hourSpinner, JSpinner minuteSpinner) {
        int hour = (int) hourSpinner.getValue();
        int minute = (int) minuteSpinner.getValue();
        label.setText("Selected Time: " + hour + ":" + String.format("%02d", minute));
    }
}