/*
Filename: BodyCompInfo.java
Author: Stephen Jones
Date: 14MAR2019
Purpose: Scans in and formats information about the animal body composition
score from a text file.
*/
package animal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class BodyCompInfo  {
    private Scanner input;
    private JFrame bodyCompFrame;
    private JPanel bodyCompPanel, chartPanel;
    private JTextArea bodyCompTextArea;
    private JButton catChart, dogChart;

    public BodyCompInfo() throws FileNotFoundException {

        // this.input = new Scanner(new FileReader("text/BodyCompInfo.txt"));

        this.input = new Scanner(new FileReader("BodyCompInfo.txt"));

        bodyCompFrame = new JFrame("Body Composition Information");
        bodyCompPanel = new JPanel(new BorderLayout());
        chartPanel = new JPanel();

        bodyCompTextArea = new JTextArea();
        bodyCompTextArea.append(this.toString());

        catChart = new JButton("Cat Chart");
        dogChart = new JButton("Dog Chart");

        catChart.addActionListener(e -> getBodyScoreChart("cat"));
        dogChart.addActionListener(e-> getBodyScoreChart ("dog"));

        //Add Components to Panel
        chartPanel.add(catChart);
        chartPanel.add(dogChart);
        bodyCompPanel.add(chartPanel, BorderLayout.NORTH);
        bodyCompPanel.add(bodyCompTextArea, BorderLayout.CENTER);
        bodyCompFrame.add(bodyCompPanel);

        setInfoFrame(bodyCompFrame);
    }
    public void getBodyScoreChart(String animalType) {
        BodyScoreChart animalBSC = new BodyScoreChart(animalType);
        try {
            animalBSC.selectAnimal();
        } catch (IOException ex) {
            Logger.getLogger(BodyCompInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void setInfoFrame(JFrame aFrame){
        aFrame.setSize(300,300);
        aFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aFrame.setLocationRelativeTo(null);
        aFrame.setVisible(true);
        //aFrame.pack();
    }

    @Override
    public String toString(){
        String compScoreString = "";
        while(input.hasNextLine()){
        compScoreString += input.nextLine() + "\n";
        }

        return compScoreString;
    }



}
