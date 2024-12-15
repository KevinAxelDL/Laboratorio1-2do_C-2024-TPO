/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Incompleto;

/**
 *
 * @author KevinDL
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IngresoFecha {
    public static void crear(){
         // Create a JFrame
        JFrame frame = new JFrame("Date Input with Separate Spinners");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Create a spinner for the day (1-31)
        JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        daySpinner.setPreferredSize(new Dimension(60, 30));

        // Create a spinner for the month (1-12)
        JSpinner monthSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        monthSpinner.setPreferredSize(new Dimension(60, 30));

        // Create a spinner for the year (e.g., 1900-2100)
        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(2024, 1900, 2100, 1));
        yearSpinner.setPreferredSize(new Dimension(80, 30));

        // Add labels and spinners to the frame
        frame.add(new JLabel("Dia:"));
        frame.add(daySpinner);
        frame.add(new JLabel("Mes:"));
        frame.add(monthSpinner);
        frame.add(new JLabel("Año:"));
        frame.add(yearSpinner);

        // Set the frame visibility
        frame.setVisible(true);
    }
}