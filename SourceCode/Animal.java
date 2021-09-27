/*
 * Filename: Animal.java
 *Author: Stephen Jones
 *Date: 18MAY2018
 *Purpose: Class that defines the animal
 */
package animal;


public class Animal {
    private int bodyScale = 0;
    private double weight = 0.0;
    private double calories = 350.0;
    private double idealWeight = 0.0;
    
    public Animal (int newBodyScale, double newWeight, double newCalories){
        bodyScale = newBodyScale;
        weight = newWeight;
        calories = newCalories;
    }
    public double getIdealWeight(){
        return idealWeight;
    }
    public void setWeight(double newWeight){
        weight = newWeight;
    }
    
    public double convertToKilo(double pounds){
        return pounds / 2.2;
    }
    public void calcIdealWeight (){
        switch (bodyScale){
            case 1: 
                idealWeight = weight * 1.2;
                break;
            case 2: 
                idealWeight = weight * 1.15;
                break;
            case 3:
                idealWeight = weight * 1.1;
                break;
            case 4:
                idealWeight = weight * 1.05;
                break;
            case 5:
                idealWeight = weight;
                break;
            case 6:
                idealWeight = weight * 0.95;
                break;
            case 7: 
                idealWeight = weight * 0.90;
                break;
            case 8:
                idealWeight = weight * 0.85;
                break;
            case 9:
                idealWeight = weight * 0.80;
                break;
        }
        
    }
    
    public double calcFoodAmt (){
        double caloriesNeeded = 0.0;
        caloriesNeeded = idealWeight*30 + 70;
        return caloriesNeeded/calories;
    }
    
    public double calcTwiceDaily(){
        return calcFoodAmt()/2;
    }
    
    public double calcThriceDaily(){
        return calcFoodAmt()/3;
    }
    
}
