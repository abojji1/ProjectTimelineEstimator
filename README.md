# Project Name

Objective of this program is to leverage natural language based linguistic approach to solve common problems.

In natural world we all routinely handle the concept of partial truths and intuitively understand concepts like a bit cold, 
sort of warm or hot, where the truth value may range between completely true and completely false. 

Fuzzy logic allows machines to mimic human-like reasoning by using linguistic terms and rules to handle
uncertainty and make decisions in complex, real-world situations that lack clear-cut answers.

This example program attempts to evaluate the cost of completion/delivery of any given task given 
Complexity of Work(CoW) and Information Clarity(IC) defined in terms of low, medium and high. 
This can be expanded to additional dimensions for increased granularity.

Numerous resource are available to provide background on Fuzzy Logic starting with:
https://en.wikipedia.org/wiki/Fuzzy_logic

Key Concepts:

Degrees of Truth: Instead of "yes" (1) or "no" (0), statements can be partially true, like "warm" (a truth value of 0.4).

Linguistic Terms: It uses words like "hot," "cold," "fast," or "slow" as inputs, which are then mapped to fuzzy sets with a degree of membership.

Fuzzy Rules: Based on these fuzzy inputs, it uses "if-then" rules (e.g., "IF the temperature is hot, THEN increase the fan speed") to make decisions.

Fuzzification & Defuzzification: Data is converted into fuzzy terms (fuzzification), processed by the rules, and then converted back into precise, non-fuzzy outputs (defuzzification)

---

## 🚀 Features
- Example based approach to demonstrate use of Fuzzy Logic that can be easily expanded 
- Allows for three dimensions (ex. Low, Med, High )
- Ability to expand beyond three dimensions (To be implemented)


---

## 📦 Installation
This is based on current version of JDK.
Clone the repository and install JDK dependencies:

```bash
git clone https://github.com/abojji1/ProjectTimelineEstimator.git
cd repo-name

