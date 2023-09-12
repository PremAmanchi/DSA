import java.util.*;
/*
 * time complexity : O(n)
 * space complexity : O(1)
 * 
 * Write a program to calculate tax if Salary and Tax Brackets are given as list in the form [
 *  [10000, .3],[20000, .2], [30000, .1], [None, .1]]. 
 * You don’t know in the beginning how many tax brackets are there. You have to test for all of them


 */
public class calculateTax{
    public static void main (String[] args) {

	List<List<Double>> levels = new ArrayList<>();
    levels.add( Arrays.asList(10000.0, 0.1) );
    levels.add( Arrays.asList(20000.0, 0.2) );
    levels.add( Arrays.asList(30000.0, 0.3) );
    levels.add( Arrays.asList(null, 0.4) );
    double tax = calculateTax(levels,25000);
    System.out.println(tax);

}

public static double calculateTax(List<List<Double>> levels, double salary ){
    double prevAmount = 0.0f;
    double taxAmount = 0.0f;
    for(int i = 0 ; i<levels.size(); i++){
        double slab = levels.get(i).get(0) == null? 0 : levels.get(i).get(0);
        if(levels.get(i).get(0) == null  || salary <= slab){
            taxAmount += (salary-prevAmount)*levels.get(i).get(1);
            return taxAmount;
        }
        taxAmount += (slab -prevAmount) * levels.get(i).get(1);
        prevAmount = slab;
    }
    return taxAmount;
}
}