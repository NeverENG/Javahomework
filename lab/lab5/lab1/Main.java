public class Main {
    public static void main(String[] args) {
        // 体操比赛：去掉最高分和最低分后计算平均分
        double[] gymnasticsScores = {9.8, 9.2, 9.5, 9.7, 9.9, 9.1};
        Gymnastics gymnastics = new Gymnastics(gymnasticsScores);
        System.out.println("体操选手最后得分：" + String.format("%.3f", gymnastics.getAverage()));
        
        // 学校考试：计算全班平均成绩
        double[] schoolScores = {85.5, 90.0, 78.5, 92.0, 88.5};
        School school = new School(schoolScores);
        System.out.println("班级考试平均分数：" + String.format("%.2f", school.getAverage()));
    }
}
