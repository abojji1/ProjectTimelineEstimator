package com.ml.language.FuzzyLogic;

/**
 * Generic Condition class
 */
public class Condition {

    String variable;
    String set;

    /**
     * Constructor, defines condition associated with a fuzzy rule
     * @param variable specific category of the condition ( ex, "Turn" )
     * @param set linguistic description of the setting ( ex, "Slightly Left" )
     */
    public Condition(String variable, String set) {
        this.variable = variable;
        this.set = set;
    }

}
