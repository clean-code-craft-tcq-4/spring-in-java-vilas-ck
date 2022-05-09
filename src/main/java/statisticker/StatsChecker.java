package statisticker;

import java.util.List;

public class StatsChecker {
    private float maxThreshold;
    private IAlerter[] alerters;

    public StatsChecker(float maxThreshold, IAlerter[] alerters) {
        this.maxThreshold = maxThreshold;
        this.alerters = alerters;
    }

    public void checkAndAlert(List<Float> numbers) {
        if(Statistics.getStatistics(numbers).max>maxThreshold){
            for(int i=0; i<alerters.length;i++){
                IAlerter alert = alerters[i];
                if(alert instanceof EmailAlert){
                    ((EmailAlert) alert).emailSent=true;
                }else if(alert instanceof LEDAlert){
                    ((LEDAlert) alert).ledGlows=true;
                }
            }
        }
    }
}
