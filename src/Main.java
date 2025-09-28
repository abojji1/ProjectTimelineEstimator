import com.ml.language.FuzzyLogic.FuzzyInferenceSystem;
import com.ml.language.FuzzyLogic.FuzzyRule;
import com.ml.language.FuzzyLogic.FuzzySet;
import com.ml.language.FuzzyLogic.FuzzyVariable;


final String sTaskComplexity = "TaskComplexity";
final String sInformationComplexity = "InformationComplexity";
final String sTimeNeededToDeliver = "TimeNeededToDeliver";

final String sLow = "Low";
final String sMedium = "Medium";
final String sHigh = "High";




void main() {


    // Input variable: Task Complexity
    FuzzyVariable taskComplexity = new FuzzyVariable(sTaskComplexity);
    taskComplexity.addFuzzySet(new FuzzySet(sLow, 0, 25, 100));
    taskComplexity.addFuzzySet(new FuzzySet(sMedium, 0, 50, 100));
    taskComplexity.addFuzzySet(new FuzzySet(sHigh, 0, 75, 100));


    // Input variable: Information Clarity
    FuzzyVariable informationClarity = new FuzzyVariable(sInformationComplexity);
    informationClarity.addFuzzySet(new FuzzySet(sLow, 0, 20, 100));
    informationClarity.addFuzzySet(new FuzzySet(sMedium, 0, 50, 100));
    informationClarity.addFuzzySet(new FuzzySet(sHigh, 0, 80, 100));

    // Output variable: Time to Deliver
    FuzzyVariable timeNeededToDeliver = new FuzzyVariable(sTimeNeededToDeliver);
    timeNeededToDeliver.addFuzzySet(new FuzzySet(sLow, 0, 20, 100));
    timeNeededToDeliver.addFuzzySet(new FuzzySet(sMedium, 0, 50, 100));
    timeNeededToDeliver.addFuzzySet(new FuzzySet(sHigh, 0, 90, 100));

    // Build Fuzzy Inference System
    FuzzyInferenceSystem fuzzyInferenceSystem = new FuzzyInferenceSystem();
    fuzzyInferenceSystem.addVariable(taskComplexity);
    fuzzyInferenceSystem.addVariable(informationClarity);
    fuzzyInferenceSystem.addVariable(timeNeededToDeliver);

    // Define rules
    FuzzyRule rule1 = new FuzzyRule(sTimeNeededToDeliver, sLow);
    rule1.addCondition(sTaskComplexity, sLow);
    rule1.addCondition(sInformationComplexity, sLow);

    FuzzyRule rule2 = new FuzzyRule(sTimeNeededToDeliver, sMedium);
    rule2.addCondition(sTaskComplexity, sMedium);
    rule2.addCondition(sInformationComplexity, sMedium);

    FuzzyRule rule3 = new FuzzyRule(sTimeNeededToDeliver, sHigh);
    rule3.addCondition(sTaskComplexity, sHigh);
    rule3.addCondition(sInformationComplexity, sHigh);

    fuzzyInferenceSystem.addRule(rule1);
    fuzzyInferenceSystem.addRule(rule2);
    fuzzyInferenceSystem.addRule(rule3);

    // Output set centers
    Map<String, Double> timeToDeliver = new HashMap<>();
    timeToDeliver.put(sLow, 20.0);
    timeToDeliver.put(sMedium, 50.0);
    timeToDeliver.put(sHigh, 90.0);


    // Example inputs
        Map<String, Double> inputs = new HashMap<>();
        inputs.put(sTaskComplexity, 50.0);
        inputs.put(sInformationComplexity, 90.0);

    double dExpectedTimeToDeliver = fuzzyInferenceSystem.infer(inputs, sTimeNeededToDeliver, timeToDeliver);

        System.out.println("Task Complexity: " + inputs.get(sTaskComplexity) + "%");
        System.out.println("Information Complexity: " + inputs.get(sInformationComplexity) + "%");
        System.out.println("Time Needed To Deliver (calculated): " + dExpectedTimeToDeliver + "T");
}
