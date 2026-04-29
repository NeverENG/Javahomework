package homework2;

import java.util.Random;

public class Titan{
    private int Energy;
    private int fightCount;      // 交手次数
    private int experience;      // 经验值

    public Titan(){
        this.Energy = 800;
        this.fightCount = 0;
        this.experience = 0;
    }

    public Titan(int e){
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

    public void fight(Zues z){
        Random random = new Random();
        int attack = random.nextInt(91) + 10;
        z.setEnergy(z.getEnergy() - attack);
        this.fightCount++;
        this.experience += attack;  // 经验值等于造成的伤害
        System.out.println("Titan攻击Zues，产生"+attack+"点攻击值，Zues当前Energy值为"+z.getEnergy());
    }
}