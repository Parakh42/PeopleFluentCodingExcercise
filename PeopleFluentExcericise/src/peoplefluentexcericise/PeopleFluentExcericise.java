/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplefluentexcericise;

import java.util.HashMap;
import java.util.Map;

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
        
        String[] input = new String[]{"Apple","Orange","Orange","Apple"};
        Double appleUnitCost = 0.60   ;
        Double orangeUnitCost = 0.25;
        HashMap<String,Integer> hmap = new HashMap<String,Integer>();
        
        if(input.length == 0){
            System.out.println("You cart is empty");
        }
        
        for(int i = 0; i < input.length; i++){
            if(hmap.containsKey(input[i])){
                hmap.put(input[i], hmap.get(input[i]) + 1);
            }
            else{
                hmap.put(input[i], 1);
            }
        }
        Double total = 0.0;
        for(Map.Entry<String, Integer> resMap : hmap.entrySet()){
            if(resMap.getKey().equals("Apple")){
                total += resMap.getValue()*appleUnitCost;
            }
            else{
                total += resMap.getValue()*orangeUnitCost;
            }
        }
        System.out.println(3/2);
        System.out.println("Total amount is $" +total);
        
    }
    
}
