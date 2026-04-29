package homework2;

import java.util.Random;

public class Zues{
    private int Energy;
    private int fightCount;      // 交手次数
    private int experience;      // 经验值

    public Zues(){
        this.Energy = 1000;
        this.fightCount = 0;
        this.experience = 0;
    }

    public Zues(int e){
        this.Energy = e;
        this.fightCount = 0;
        this.experience = 0;
    }

    public int getEnergy() {
        return Energy;
    }

    public void setEnergy(int energy) {
        Energy = energy;
    }

    public int getFightCount() {
        return fightCount;
    }

    public int getExperience() {
        return experience;
    }

    public void fight(Titan t){
        Random random = new Random();
        int attack = random.nextInt(71);
        t.setEnergy(t.getEnergy() - attack);
        this.fightCount++;
        this.experience += attack;  // 经验值等于造成的伤害
        System.out.println("Zues攻击Titan，产生"+attack+"点攻击值，Titan当前Energy值为"+t.getEnergy());
    }
}