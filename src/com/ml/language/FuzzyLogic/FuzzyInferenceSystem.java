package com.ml.language.FuzzyLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Inference System that will take in variable and associated rules
 * to determine membership of the input based on the set of Fuzzy Rules
 */

public class FuzzyInferenceSystem {

    Map<String, FuzzyVariable> variables = new HashMap<>();
    List<FuzzyRule> rules = new ArrayList<>();

    /**
     * Setter for the Fuzzy Variable
     * @param var
     */
    public void addVariable(FuzzyVariable var) {
        variables.put(var.name, var);
    }

    /**
     * Setter for the Fuzzy Rule
     * @param rule
     */
    public void addRule(FuzzyRule rule) {
        rules.add(rule);
    }

    /**
     * Infer the membership of the given input based on Fuzzy Variables and associated rules
     * @param inputs to evaluate
     * @param outputVar result we are looking for
     * @param outputCenters output defined in terms of degrees of truth
     * @return membership in the degrees of truth
     */
    // Inference with multiple inputs, this can be expanded
    public double infer(Map<String, Double> inputs, String outputVar, Map<String, Double> outputCenters) {
        double numerator = 0.0;
        double denominator = 0.0;

        for (FuzzyRule rule : rules) {
            if (!rule.outputVar.equals(outputVar)) continue;
            System.out.println("Evaluating rule \n" + rule);

            // All conditions to be evaluated
            double degree = 1.0;
            for (Condition cond : rule.conditions) {

                System.out.println("Evaluating condition variable from inputs " + cond.variable);

                double value = inputs.get(cond.variable);

                if ( variables.containsKey(cond.variable)){
                    System.out.println("Variable map Contains "+ cond.variable);
                }

                FuzzyVariable fuzzyVariable = variables.get(cond.variable);
                double dMembership = fuzzyVariable.getMembership(cond.set, value);
                degree = Math.min(degree, dMembership);
            }

            double center = outputCenters.get(rule.outputSet);
            numerator += degree * center;
            denominator += degree;
        }

        return (denominator == 0) ? 0 : numerator / denominator;
    }
}
