package com.ml.language.FuzzyLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuzzyInferenceSystem {

    Map<String, FuzzyVariable> variables = new HashMap<>();
    List<FuzzyRule> rules = new ArrayList<>();

    public void addVariable(FuzzyVariable var) {
        variables.put(var.name, var);
    }

    public void addRule(FuzzyRule rule) {
        rules.add(rule);
    }





    // Inference with multiple inputs, this can be expanded
    public double infer(Map<String, Double> inputs, String outputVar, Map<String, Double> outputCenters) {
        double numerator = 0.0;
        double denominator = 0.0;

        for (FuzzyRule rule : rules) {
            if (!rule.outputVar.equals(outputVar)) continue;
            System.out.println("Evaluating rule \n" + rule.toString());

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
