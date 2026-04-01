package by;

import java.util.LinkedHashSet;
import java.util.Set;

public class Player {
    private Set<Step> steps;
    int errorCounter = 0;

    public Player() {
        steps = new LinkedHashSet<>();
    }

    public void addStep(Step step) {
        if (step.validateStep()) {
            if (!steps.add(step)){
                System.out.println("Вы уже вводили эту букву. Введите другую");
            } else {
                if (step.isError()) {
                    errorCounter++;
                }
            }
        }
    }

    public int getErrorCounter() {
        return errorCounter;
    }

    public Set<Step> getSteps() {
        return steps;
    }

    public void clean() {
        steps.clear();
        errorCounter = 0;
    }
}
