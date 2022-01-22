/*
 * Filename: Animal.java
 *Author: Stephen Jones
 *Created: 18MAY2018
 *Update: 22JAN2022
 *Purpose: Class that defines the animal
 */
package animal;


public class Animal {

    // Variables
    private int bodyScale = 0; // A range of body size (obese -> average -> malnourished)
    private double weight = 0.0;
    private double calories = 350.0; // Calories in 1 cup of food
    private double idealWeight = 0.0;

    // Constructor
    public Animal (int newBodyScale, double newWeight, double newCalories){
        bodyScale = newBodyScale;
        weight = newWeight;
        calories = newCalories;
    }

    // Methods
    // Getters
    public double getIdealWeight(){
        return idealWeight;
    }
    public double getCalories(){
        return calories;
    }
    public double getWeight(){
        return weight;
    }
    public int getBodyScale(){
        return bodyScale;
    }

    // Setters
    public void setWeight(double newWeight){
        weight = newWeight;
    }
        public void setbodyScale(double newBodyScale){
        weight = newBodyScale;
    }
        public void setCalories(double newCalories){
        weight = newCalories;
    }
        public void setIdealWeight(double newIdealWeight){
        weight = newIdealWeight;
    }

    // Pounds to Kilo Conversion
    public double convertToKilo(double pounds){
        return pounds / 2.2;
    }

    // Calculates ideal body weight based on the current weight and the body scale number
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

    // Calculates food amount based on calories needed for ideal weight
    public double calcFoodAmt (){
        double caloriesNeeded = 0.0;
        caloriesNeeded = idealWeight*30 + 70;
        return caloriesNeeded/calories;
    }

    //Calculates feeding animal twice a day
    public double calcTwiceDaily(){
        return calcFoodAmt()/2;
    }

    // Calculates feeding animal three times a day
    public double calcThriceDaily(){
        return calcFoodAmt()/3;
    }

}
