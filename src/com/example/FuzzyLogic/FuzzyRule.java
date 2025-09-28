package com.example.FuzzyLogic;

import java.util.ArrayList;
import java.util.List;

public class FuzzyRule {
    List<Condition> conditions = new ArrayList<>();
    String outputVar, outputSet;

    public FuzzyRule(String outputVar, String outputSet) {
        this.outputVar = outputVar;
        this.outputSet = outputSet;
    }

    public void addCondition(String variable, String set) {
        conditions.add(new Condition(variable, set));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for( Condition c : conditions){
            sb.append("Condition Variable: ").append(c.variable).append(" : ").append(c.set).append("\n");
        }
        sb.append("OutputVar :  ").append(outputVar).append(" : ").append(outputSet);

        return sb.toString();
    }
}
