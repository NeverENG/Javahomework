public class Gymnastics implements ComputerAverage{
    double[] scores;

    public Gymnastics(double[] scores){
        this.scores = scores;
    }

    @Override
    public double getAverage() {
        if (scores == null || scores.length < 3) {
            return 0;
        }
        
        double sum = 0;
        double max = scores[0];
        double min = scores[0];
        
        for (double score : scores) {
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;
        }
        
        // 去掉最高分和最低分
        sum = sum - max - min;
        return sum / (scores.length - 2);
    }
}
