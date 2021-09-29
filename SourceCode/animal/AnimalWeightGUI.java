
package animal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
//import javax.swing.;

public class AnimalWeightGUI extends JFrame {
    //Variables
    private JPanel mainPanel;
    private JLabel idealLabel, weightLabel, bodyLabel, calorieLabel, dayAmtLabel, twiceAmtLabel,
            thriceAmtLabel, emptyLabel, bodyCompInfoLabel;
    private JTextField idealText, weightText, bodyText, calorieText, dayAmtText, twiceAmtText,
            thriceAmtText;
    private JButton computeButton, bodyCompInfoButton;
    private JRadioButton kiloButton, poundButton;
    private Border inputBorder, outputBorder, blackline, grayLine;
    private Font titleFontFormat;
    
    //Decimal format for all calculations
    DecimalFormat df = new DecimalFormat("0.00");
    //Construction with components
    public AnimalWeightGUI(){
        //this.setFrame(this);
        
        
        mainPanel = new JPanel(new BorderLayout());
        
        
        JPanel northGrid = new JPanel(new GridLayout(5,2));
        JPanel southGrid = new JPanel(new GridLayout(4,2));
        JPanel radioButtonPanel = new JPanel();
        
        //Borders
        grayLine = BorderFactory.createLineBorder(Color.GRAY, 1);
        blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
        titleFontFormat = new java.awt.Font ("Monospaced", 0, 12);
        inputBorder = BorderFactory.createTitledBorder(grayLine, 
                "Animal Information",
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION,
                titleFontFormat, Color.GRAY);
        outputBorder = BorderFactory.createTitledBorder(grayLine, 
                "Feeding Suggestions",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                titleFontFormat, 
                Color.GRAY);
        
        //Labels
        emptyLabel = new JLabel("");
        weightLabel = new JLabel ("  Animal's Current Weight:");
        bodyLabel = new JLabel ("  Body Condition Score:");
        calorieLabel = new JLabel ("  Calories Per Cup:");
        bodyCompInfoLabel = new JLabel("  Calculator Instructions:");
        idealLabel = new JLabel("  Ideal Weight:");
        dayAmtLabel = new JLabel ("  Cups Per Day:");
        twiceAmtLabel = new JLabel ("  Cups Twice A Day:");
        thriceAmtLabel = new JLabel ("  Cups Three Times A Day:");
        
        //Text Fields
        weightText = new JTextField();
        weightText.setToolTipText("Enter in pet's current weight and choose kilo or pound.");
        bodyText = new JTextField();
        bodyText.setToolTipText("Enter in pet's body composition score (1-9).");
        calorieText = new JTextField();
        calorieText.setToolTipText("Enter in the number of calories per cup of animals food.");
        idealText = new JTextField();
        idealText.setEditable(false);
        idealText.setToolTipText("Pet's ideal weight.");
        dayAmtText = new JTextField();
        dayAmtText.setEditable(false);
        dayAmtText.setToolTipText("Amount of food, in cups, to feed pet once a day.");
        twiceAmtText = new JTextField();
        twiceAmtText.setEditable(false);
        twiceAmtText.setToolTipText("Amount of food, in cups, to feed pet twice a day.");
        thriceAmtText = new JTextField();
        thriceAmtText.setEditable(false);
        thriceAmtText.setToolTipText("Amount of food, in cups, to feed pet three times a day.");
        
        //Button
        computeButton = new JButton("Compute");
        computeButton.setToolTipText("Click to compute results.");
        mainPanel.add(computeButton, BorderLayout.CENTER);
        bodyCompInfoButton = new JButton("Instructions");
        
        //radio buttons
        kiloButton = new JRadioButton("Kilo");
        poundButton = new JRadioButton("Pound");
        kiloButton.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(kiloButton);
        group.add(poundButton);
        radioButtonPanel.add(kiloButton);
        radioButtonPanel.add(poundButton);
      
        //add to the northGrid
        northGrid.add(bodyCompInfoLabel);
        northGrid.add(bodyCompInfoButton);
        northGrid.add(weightLabel);
        northGrid.add(weightText);
        northGrid.add(emptyLabel);
        northGrid.add(radioButtonPanel);
        northGrid.add(bodyLabel);
        northGrid.add(bodyText);
        northGrid.add(calorieLabel);
        northGrid.add(calorieText);
        northGrid.setBorder(inputBorder);
        
        //add to the southGrid
        southGrid.add(idealLabel);
        southGrid.add(idealText);
        southGrid.add(dayAmtLabel);
        southGrid.add(dayAmtText);
        southGrid.add(twiceAmtLabel);
        southGrid.add(twiceAmtText);
        southGrid.add(thriceAmtLabel);
        southGrid.add(thriceAmtText);
        southGrid.setBorder(outputBorder);
        
        //add to the main panel
        mainPanel.add(northGrid, BorderLayout.NORTH);
        mainPanel.add(southGrid, BorderLayout.SOUTH);
        this.add(mainPanel);
        setFrame(this);
        
        //actionlisteners
        computeButton.addActionListener(e -> computeResults());
        bodyCompInfoButton.addActionListener(e -> {
            try {
                BodyCompInfo infoObject = new BodyCompInfo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AnimalWeightGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    //Methods
    public void computeResults(){
        try{
            int bodyNumInput = Integer.parseInt(bodyText.getText());
            double weightInput = Double.parseDouble(weightText.getText());
            double calorieInput = Double.parseDouble(calorieText.getText());
        
        if (bodyNumInput < 0 || weightInput < 0 || calorieInput < 0){
            throw new NegativeNumberException();
        }
        if (bodyNumInput > 9 || bodyNumInput == 0){
            throw new NumberOutOfRangeException();
        }
        
        Animal newAnimal = new Animal(bodyNumInput, weightInput, calorieInput);
        if(poundButton.isSelected()){
            weightInput = newAnimal.convertToKilo(weightInput);
            newAnimal.setWeight(weightInput);
        }
        newAnimal.calcIdealWeight();
        if(poundButton.isSelected()){
            idealText.setText(df.format(2.2*newAnimal.getIdealWeight()) + " (pounds)");
        }
        else{
            idealText.setText(df.format(newAnimal.getIdealWeight()) + " (kilograms)");
        }
        dayAmtText.setText(df.format(newAnimal.calcFoodAmt()));
        twiceAmtText.setText(df.format(newAnimal.calcTwiceDaily()));
        thriceAmtText.setText(df.format(newAnimal.calcThriceDaily()));


        }catch(NumberOutOfRangeException re){
            JOptionPane.showMessageDialog(null, "Please enter a value from 1-9.",
                    "Value Out Of Range", JOptionPane.ERROR_MESSAGE);
        }catch(NumberFormatException ne){
            JOptionPane.showMessageDialog(null, "Please enter an appropriate " +
                    "number for each text field.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }catch(NegativeNumberException nne){
            JOptionPane.showMessageDialog(null, "Please enter a positive value",
                    "Negative Number Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void setFrame(JFrame aFrame){
        aFrame.setSize(350,370);
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setLocationRelativeTo(null);
        aFrame.setVisible(true);
        aFrame.setTitle("Ideal Weight Calculator");
        //aFrame.pack();
    }
    
    public static void main(String[] args) {
        //create Frame
        JFrame theFrame = new AnimalWeightGUI();
        
    }
    
}
