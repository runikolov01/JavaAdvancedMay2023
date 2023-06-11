package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise ex : exercises) {
            if (ex.getName().equals(name) && ex.getMuscle().equals(muscle)) {
                return exercises.remove(ex);
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise ex : exercises) {
            if (ex.getName().equals(name) && ex.getMuscle().equals(muscle)) {
                return ex;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exercise = null;
        int calories = 0;

        if (this.exercises.size() > 0) {
            for (Exercise ex : this.exercises) {
                if (ex.getBurnedCalories() > calories) {
                    calories = ex.getBurnedCalories();
                }
            }
            for (Exercise ex : this.exercises) {
                if (ex.getBurnedCalories() == calories) {
                    exercise = ex;
                    break;
                }
            }
        }
        return exercise;
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s", this.type)).append(System.lineSeparator());
        for (Exercise ex : exercises) {
            sb.append(ex).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
