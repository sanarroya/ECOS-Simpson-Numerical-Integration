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
public class IntegralInfo {
    
    private double degreesOfFreedom;
    private double integralLowerLimit;
    private double integralUpperLimit;
    private double integralResult;

    /**
     *Empty constructor of the class
     */
    public IntegralInfo() {
    }

    /**
     *Constructor of the class
     * 
     * @param numberOfSegments to integrate
     * @param segmentWidth width of each segment
     * @param degreesOfFreedom Integration degrees of freedom
     * @param integralLowerLimit Lower limit of the interval in which we will integrate
     * @param integralUpperLimit Upper limit of the interval in which we will integrate
     */
    public IntegralInfo(double degreesOfFreedom, double integralLowerLimit, double integralUpperLimit) {
        this.degreesOfFreedom = degreesOfFreedom;
        this.integralLowerLimit = integralLowerLimit;
        this.integralUpperLimit = integralUpperLimit;
    }

    /**
     * Number of segments getter
     * 
     * @return number of segments
     */
    public double getNumberOfSegments() {
        return 10.0;
    }

    /**
     * Segment width getter
     * 
     * @return segment width
     */
    public double getSegmentWidth() {
        return this.integralUpperLimit / this.getNumberOfSegments();
    }

    /**
     *Degrees of freedom getter
     * 
     * @return degrees of freedom
     */
    public double getDegreesOfFreedom() {
        return degreesOfFreedom;
    }

    /**
     *Degrees of freedom setter
     * 
     * @param degreesOfFreedom
     */
    public void setDegreesOfFreedom(double degreesOfFreedom) {
        this.degreesOfFreedom = degreesOfFreedom;
    }

    /**
     *Integral lower limit getter
     * 
     * @return integral lower limit
     */
    public double getIntegralLowerLimit() {
        return integralLowerLimit;
    }

    /**
     *Integral lower limit setter
     * 
     * @param integralLowerLimit
     */
    public void setIntegralLowerLimit(double integralLowerLimit) {
        this.integralLowerLimit = integralLowerLimit;
    }

    /**
     *Integral upper limit getter
     * 
     * @return integral upper limit
     */
    public double getIntegralUpperLimit() {
        return integralUpperLimit;
    }

    /**
     *Integral upper limit setter
     * 
     * @param integralUpperLimit
     */
    public void setIntegralUpperLimit(double integralUpperLimit) {
        this.integralUpperLimit = integralUpperLimit;
    }

    /**
     *Integral result getter
     * @return integral result
     */
    public double getIntegralResult() {
        return integralResult;
    }

    /**
     *Integral result setter
     * 
     * @param integralResult
     */
    public void setIntegralResult(double integralResult) {
        this.integralResult = integralResult;
    }
    
    
}
