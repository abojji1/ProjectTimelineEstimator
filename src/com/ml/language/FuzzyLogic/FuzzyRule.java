package com.ml.language.FuzzyLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class defining the Fuzzy Rule
 */
public class FuzzyRule {
    List<Condition> conditions = new ArrayList<>();
    String outputVar, outputSet;

    /**
     * Constructor
     * @param outputVar Output variable we are trying to compute
     * @param outputSet linguistic description of the truth setting ( high , medium, low etc )
     */

    public FuzzyRule(String outputVar, String outputSet) {
        this.outputVar = outputVar;
        this.outputSet = outputSet;
    }

    /**
     * Add condition to the Fuzzy Rule
     * @param variable variables influencing the rule ( ex. how hot you feel ( output )  is determined by variable humidity ( input) and variable temperature ( input ) )
     * @param set values this variable can have ( ex. high , medium, low , slightly left , left , hard right )
     */
    public void addCondition(String variable, String set) {
        conditions.add(new Condition(variable, set));
    }

    /**
     * To String method to aid in logging / debugging
     * @return String  representation of the Fuzzy Rule
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for( Condition c : conditions){
            sb.append("Condition Variable: ").append(c.variable).append(" : ").append(c.set).append("\n");
        }
        sb.append("OutputVar :  ").append(outputVar).append(" : ").append(outputSet);

        return sb.toString();
    }
}
