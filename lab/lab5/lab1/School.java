public class School implements ComputerAverage {
    double[] scores;
    
    public School(double[] scores) {
        this.scores = scores;
    }
    
    @Override
    public double getAverage() {
        if (scores == null || scores.length == 0) {
            return 0;
        }
        
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        
        return sum / scores.length;
    }
}