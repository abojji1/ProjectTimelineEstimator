package com.ml.language.FuzzyLogic;

/**
 * Fuzzy Set to define the name the qualities that define it
 */
public class FuzzySet {
    String sName;
    double qtyA, qtyB, qtyC; // three dimensions ( Low, Med, High ) , you could go higher ( LowLow, LowMed, MedMed, etc. )

    /**
     * Constructor
     * @param name of the Fuzzy Set
     * @param a dimension
     * @param b dimension
     * @param c dimension
     */
    public FuzzySet(String name, double a, double b, double c) {
        this.sName = name;
        this.qtyA = a;
        this.qtyB = b;
        this.qtyC = c;
    }

    /**
     * Logic to determine membership. This example is currently linear. We can replace this with a sigmoid or any suitable function
     *
     * @param x , input that determines membership
     * @return membership value
     */
    public double membership(double x) {
        double dMembership;
        if (x <= qtyA || x >= qtyC) {
            dMembership = 0.0;
        } else if (x == qtyB) {
            dMembership = 1.0;
        } else if (x > qtyA && x < qtyB) {
            dMembership = (x - qtyA) / (qtyB - qtyA);
        } else {
            dMembership = (qtyC - x) / (qtyC - qtyB);
        }
        return dMembership;
    }
}
