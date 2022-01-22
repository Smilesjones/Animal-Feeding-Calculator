/*
Filename: BodyScoreChart.java
Author: Stephen Jones
Created: 14MAR2019
Updated: 22JAN2022
Purpose: Displays body chart images for cats and dogs.
*/
package animal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BodyScoreChart extends JPanel{
    //Variables
    private static final int IMAGEWIDTH = 510;
    private static final int IMAGEHEIGHT = 660;


    private String animal = "";
    private JFrame chartFrame;
    private JPanel mainPanel;
    private JTextArea mainField;
    private BufferedImage chartImage;
    private Image newImage;

    //Constructor
    public BodyScoreChart(String animalType){
        animal = animalType;
        chartFrame = new JFrame();
        this.setInfoFrame(chartFrame);
    }

    //Methods
    // Selects the appropriate chart type
    public void selectAnimal() throws IOException{
        switch (animal){
            case "cat" :
                getBCSChart("../resources/images/BCSFeline.jpg");
                break;
            case "dog" : getBCSChart("../resources/images/BCSCanine.jpg");
        }
    }
    // Retrieves appropriate image
    public void getBCSChart(String imagePath) throws IOException{
        try{
            Image image = ImageIO.read(getClass().getResource(imagePath));
            chartFrame.add(new BackgroundPanel(image));
        }catch (IOException ioe){
            Logger.getLogger(BodyScoreChart.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
    // Set frame specs
    public void setInfoFrame(JFrame aFrame){
        aFrame.setSize(IMAGEWIDTH,IMAGEHEIGHT);
        aFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aFrame.setLocationRelativeTo(null);
        aFrame.setVisible(true);
    }
}
