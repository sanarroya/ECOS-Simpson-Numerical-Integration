/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CalculationManager;
import Model.IntegralInfo;
import Model.LoadData;
import java.util.List;

/**
 *
 * @author SantiagoAvila
 */
public class Controller {
    
    /**
     * Load data from file into list 
     * @param fileName File to read the data from
     * @return List of values to be integrated
     */
    public List<IntegralInfo> loadClassInfo(String fileName) {
        return LoadData.loadDataFromFile(fileName);
    }
    
    /**
     * Calculates t distribution
     * 
     * @param integralInfo
     * @return IntegraInfo object with all integral information
     */
    public double calculateTDistribution(IntegralInfo integralInfo) {
        double p = CalculationManager.simpsonIntegral(integralInfo);
        integralInfo.setNumberOfSegments(20.0);
        double p2 = CalculationManager.simpsonIntegral(integralInfo);
        
        integralInfo.setIntegralResult(CalculationManager.tDistribution(integralInfo));
        return integralInfo;
    }
}
