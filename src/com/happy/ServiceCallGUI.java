package com.happy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;



/**
 * Created by Happy on 4/26/2017.
 */
public class ServiceCallGUI extends JFrame {
    Scanner s = new Scanner(System.in);

    boolean quit = false;
    private static LinkedList<ServiceCall> todayServiceCalls;
    LinkedList<ServiceCall> todayServiceCallQueue = new LinkedList<ServiceCall>();
    LinkedList<ServiceCall> resolvedServiceCalls = new LinkedList<ServiceCall>();

    private JPanel rootPanel;
    private JTextField AddresstextField1;
    private JTextField descriptiontextField2;
    private JTextField modeltextField3;
    private JLabel modelLabel;
    private JRadioButton furnaceRadioButton1;
    private JRadioButton ACRadioButton;
    private JLabel furnaceLabel;
    private JComboBox furnceTypecomboBox;
    private JList serviceCalllist1;
    private JButton addbutton;
    private JButton deleteButton;
    private JButton quitButton;

    protected String resolution;
    protected double fee;

    DefaultListModel<ServiceCall> serviceCallGUIListModel;


    public ServiceCallGUI() {
        super("Service call");
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(new Dimension(400, 400));
        final String furnaceTypes = "forced Air";
        final String furnaceType = "Boiler/Radiators";
        final String FurnacType = "Older 'Octopus' Style";
        furnceTypecomboBox.addItem(furnaceTypes);
        furnceTypecomboBox.addItem(furnaceType);
        furnceTypecomboBox.addItem(FurnacType);


       serviceCallGUIListModel = new DefaultListModel<ServiceCall>();
        serviceCalllist1.setModel(serviceCallGUIListModel);
        serviceCalllist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        modeltextField3.setVisible(false);
        modelLabel.setVisible(false);
        ACRadioButton.setSelected(false);
        //ResolutiontextField1.setVisible(false);

        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String serviceAddress = AddresstextField1.getText();
                String report = descriptiontextField2.getText();
                //String models = modeltextField3.getText();
                String description = descriptiontextField2.getText();
                //String furnacetoString = furnaceradioButton1.getText();
                Date date = new Date();

                if (ACRadioButton.isSelected()) {
                    String model = modeltextField3.getText();
                    CentralAC newservice = new CentralAC(serviceAddress, description, date, model);
                    serviceCallGUIListModel.addElement(newservice);
                    todayServiceCallQueue.add(newservice);
                } else {
                   // Furnace furnaceType = new Furnace();
                    if (furnaceRadioButton1.isSelected()) {
                        if (furnceTypecomboBox.getSelectedItem().equals("forced Air")) {
                           int furnaceType = 1;

                            Furnace furnace = new Furnace( serviceAddress , description, date, furnaceType);
                            serviceCallGUIListModel.addElement(furnace);
                            todayServiceCallQueue.add(furnace);
                        }
                        if (furnceTypecomboBox.getSelectedItem().equals("Boiler/Radiators")) {
                           int furnaceType = 2;
                            Furnace furnace = new Furnace(serviceAddress, description, date, furnaceType);

                            serviceCallGUIListModel.addElement(furnace);
                            todayServiceCallQueue.add(furnace);

                        }
                        if (furnceTypecomboBox.getSelectedItem().equals("Older 'Octopus' Style")) {
                           int furnaceType = 3;
                            Furnace furnace = new Furnace(serviceAddress, description, date, furnaceType);
                            serviceCallGUIListModel.addElement(furnace);
                            todayServiceCallQueue.add(furnace);
                        }
                    }

                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }

        });
        ACRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ACRadioButton.isSelected()) {
                    modeltextField3.setVisible(true);
                    modelLabel.setVisible(true);
                } else {
                    modeltextField3.setVisible(false);
                    modelLabel.setVisible(false);
                }
            }
        });
        furnaceRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (furnaceRadioButton1.isSelected()) {
                    furnceTypecomboBox.setVisible(true);
                    furnaceLabel.setVisible(true);
                } else {
                    furnceTypecomboBox.setVisible(false);
                    furnaceLabel.setVisible(false);
                }
            }

        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceCall serviceCall = (ServiceCall) ServiceCallGUI.this.serviceCalllist1.getSelectedValue();
                ServiceCallGUI.this.serviceCallGUIListModel.removeElement(serviceCall);


            }
        });
    }
}










