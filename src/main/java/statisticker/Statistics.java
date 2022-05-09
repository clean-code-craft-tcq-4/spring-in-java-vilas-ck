package statisticker;


import java.util.Collections;
import java.util.List;

public class Statistics {

    public static Stats getStatistics(List<Float> numbers) {
        Statistics outerObj = new Statistics();
        Statistics.Stats innerObject = outerObj.new Stats();
        if(numbers!=null && !numbers.isEmpty()) {
            innerObject.average = calculateAverage(numbers);
            innerObject.min = calculateMin(numbers);
            innerObject.max = calculateMax(numbers);
        }
        return innerObject;
    }

    public class Stats {
        public  float average = Float.NaN;
        public  float min = Float.NaN;
        public  float max = Float.NaN;
    }

    private static float calculateAverage(List<Float> marks) {
        float average = 0;
        for (Float mark : marks) {
            average += mark;
        }
        return average / marks.size();
    }

    private static float calculateMin(List<Float> marks){
        return Collections.min(marks);

    }
    private static float calculateMax(List<Float> marks){
        return Collections.max(marks);

    }
}
