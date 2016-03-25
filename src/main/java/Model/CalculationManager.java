/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SantiagoAvila
 */
public class CalculationManager {
    
    static public final double ACCEPTABLE_ERROR = 0.00001;
    /**
     *
     * @param integralInfo
     * @return
     */
    static public double tDistribution(IntegralInfo integralInfo) {
        return 0.0;    
    }
    
    /**
     *Calculate factorial of a given value
     * 
     * @param value
     * @return Result of calculating factorial to the given value
     */
    private double factorial(double value) {
        
        double factorialValue = 1.0;
        while(value > 1) {
            factorialValue *= value;
            value--;
        }
        return factorialValue;
    }
    
    /**
     * Calculates the gamma function of a given value
     * 
     * @param value
     * @return Result of calculating gamma function to the given value
     */
    public double gammaFunction(double value) {
        if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
            return factorial(value - 1);
        }
        return 0.0;
    }
}
