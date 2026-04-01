package by;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Step {
    private final String STEP;
    private boolean error;

    public Step(String step, boolean error) {
        this.STEP = step;
        this.error = error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getStep() {
        return STEP;
    }

    public boolean isError() {return error;}

    public boolean validateStep() {
        if (STEP.isEmpty()) {
            System.out.println("Вы ввели пустое значение. Введите букву.");
            return  false;
        }

        if (STEP.length() != 1) {
            System.out.println("Вы ввели несколько букв. Введите единственную букву.");
            return  false;
        }

        String regexp = "[а-яё]";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(STEP);
        if (!matcher.find()) {
            System.out.println("Вы ввели букву не из рус. алфавита. Введите маленькую букву из рус. алфавита.");
            return  false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        Step step = (Step) obj;
        return this.STEP.equals(step.getStep());
    }

    @Override
    public int hashCode() {
        return this.STEP.hashCode();
    }
}
