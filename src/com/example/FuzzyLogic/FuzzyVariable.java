package com.example.FuzzyLogic;

import java.util.HashMap;
import java.util.Map;

public class FuzzyVariable {
    String name;
    Map<String, FuzzySet> sets = new HashMap<>();

    public FuzzyVariable(String name) {
        this.name = name;
    }

    public void addFuzzySet(FuzzySet set) {
        sets.put(set.sName, set);
    }

    public double getMembership(String setName, double value) {
        return sets.get(setName).membership(value);
    }
}
