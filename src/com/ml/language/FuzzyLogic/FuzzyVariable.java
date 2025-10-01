package com.ml.language.FuzzyLogic;

import java.util.HashMap;
import java.util.Map;

/**
 * Fuzzy Variable class to connects the variable with set to obtain membership
 *
 */
public class FuzzyVariable {
    String name;
    Map<String, FuzzySet> sets = new HashMap<>();

    /**
     * Constructor
     * @param name of the variable
     */

    public FuzzyVariable(String name) {
        this.name = name;
    }

    /**
     * Fuzzy set associated with the variable
     * @param set Fuzzy set to add
     */
    public void addFuzzySet(FuzzySet set) {
        sets.put(set.sName, set);
    }

    /**
     * Obtain membership of this variable across various applicable Fuzzy Sets
     * @param setName Fuzzy Set name
     * @param value value for which we are trying to determine the membership
     * @return membership
     */
    public double getMembership(String setName, double value) {
        return sets.get(setName).membership(value);
    }
}
