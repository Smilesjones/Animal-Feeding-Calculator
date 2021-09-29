/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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


public class BodyScoreChart extends JPanel{
    private static final int IMAGEWIDTH = 510;
    private static final int IMAGEHEIGHT = 660;
    
    
    private String animal = "";
    private JFrame chartFrame;
    private JPanel mainPanel;
    private JTextArea mainField;
    private BufferedImage chartImage;
    private Image newImage;
    
    public BodyScoreChart(String animalType){
        animal = animalType;
        chartFrame = new JFrame();
        //chartFrame.add(this);
        this.setInfoFrame(chartFrame);
    }
    
    public void selectAnimal() throws IOException{
        switch (animal){
            case "cat" : 
                /*
                String catFile = "images/BCSFeline.jpg";
                BufferedImage catImage = ImageIO.read(getClass().getResource(catFile));
                mainPanel.add(catImage);
                */
                getBCSChart("/images/BCSFeline.jpg");
                //chartFrame.add(new BackgroundPanel())
                         break;
            case "dog" : getBCSChart("/images/BCSCanine.jpg");
        }
    }
    public void getBCSChart(String imagePath) throws IOException{
        Image image = ImageIO.read(getClass().getResource(imagePath));
        chartFrame.add(new BackgroundPanel(image));
        /*newImage = image.getScaledInstance(IMAGEWIDTH, IMAGEHEIGHT, Image.SCALE_SMOOTH);
        int newImageWidth = IMAGEWIDTH * 2;
        int newImageHeight = IMAGEHEIGHT * 2;
        BufferedImage resizedImage = new BufferedImage(newImageWidth, newImageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(newImage, 0, 0, newImageWidth , newImageHeight , null);
        g.dispose();*/
    }
    /*
    @Override
    public Dimension getPreferredSize()
    {
        //return (new Dimension(image.getWidth(), image.getHeight()));
        return (new Dimension(400, 500));

    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(newImage, 0, 0, this);
    }*/
    public void setInfoFrame(JFrame aFrame){
        aFrame.setSize(IMAGEWIDTH,IMAGEHEIGHT);
        aFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aFrame.setLocationRelativeTo(null);
        aFrame.setVisible(true);
        //aFrame.pack();
    }
    
}
