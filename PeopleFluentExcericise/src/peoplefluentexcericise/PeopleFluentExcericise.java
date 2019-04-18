/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplefluentexcericise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author parak
 */
public class PeopleFluentExcericise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter comma separated list of fruits(Apple/Orange):-");
        Scanner userInput = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();
        String[] tokens = userInput.nextLine().split(",");
        for(int i=0; i < tokens.length; i++){
            input.add(tokens[i]);
        }
        if(input.get(0).equals("")){
            System.out.println("You cart is empty");
            return;
        }

        Double appleUnitCost = 0.60;
        Double orangeUnitCost = 0.25;

        HashMap<String,Integer> hmap = new HashMap<String,Integer>();
        for(int i = 0; i < input.size(); i++){
            if(hmap.containsKey(input.get(i))){
                hmap.put(input.get(i), hmap.get(input.get(i)) + 1);
            }
            else{
                hmap.put(input.get(i), 1);
            }
        }
        Double total = 0.0;
        Double discountedPrice = 0.0;
        for(Map.Entry<String, Integer> resMap : hmap.entrySet()){
            if(resMap.getKey().equalsIgnoreCase("Apple")){
               discountedPrice +=  discountedOffer(resMap.getKey(),resMap.getValue());
                total += resMap.getValue()*appleUnitCost;
            }
            else if(resMap.getKey().equalsIgnoreCase("Orange")){
                discountedPrice +=  discountedOffer(resMap.getKey(),resMap.getValue());
                total += resMap.getValue()*orangeUnitCost;
            }
        }
        System.out.println("Total amount is $" + total );
        Scanner dis = new Scanner(System.in);
        System.out.println("Is the customer is eligible for discount(Y/N)?");
        if(dis.nextLine().equalsIgnoreCase("Y")){
            System.out.println("Discounted Amount is $" +discountedPrice);
            total = total - discountedPrice;
            System.out.println("Amount after discount $" + total);
        }
        
        
        
    }
    
    public static double discountedOffer(String fruitName, int quantity){
        double discountedPrice = 0.0;
        if(fruitName.equalsIgnoreCase("Apple")){
            if(quantity < 2){
               discountedPrice += 0.0;
            }
            else{
               discountedPrice += (quantity/2) * 0.60;
            }
        }
        else{
            if(quantity < 3){
               discountedPrice += 0.0;
            }
            else{
                discountedPrice += (quantity/3) * 0.25;
            }
        }
        return discountedPrice;
    }
    
}
