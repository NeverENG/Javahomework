class Animal {
    int Number;
    String Lei;
    public void ShowMessage(){
        System.out.println(Number+":"+Lei);
    }
}

interface Talent {
    public void ShowTalent();
}

class Bird extends Animal implements Talent {
    public Bird(){
        super();
        Number = 1;
        Lei = "Bird";
    }
    public void ShowTalent(){
        System.out.println("I can fly");
    }
}

class Kunchong extends Animal implements Talent {
    public Kunchong(){
        super();
        Number = 2;
        Lei = "Kunchong";
    }
    public void ShowTalent(){
        System.out.println("I can bite");
    }
}

class Paxing extends Animal implements Talent {
    public Paxing(){
        super();
        Number = 3;
        Lei = "Paxing";
    }
    public void ShowTalent(){
        System.out.println("I can claw");
    }
}

public class ShowAnimal{
    public static void main(String args[]){
        Animal[] animals = new Animal[100];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < animals.length; i++) {
            int type = random.nextInt(3);
            switch (type) {
                case 0: animals[i] = new Bird();    break;
                case 1: animals[i] = new Kunchong(); break;
                case 2: animals[i] = new Paxing();   break;
            }
        }

        for (int i = 0; i < animals.length; i++) {
            System.out.print("第" + (i + 1) + "只 ");
            animals[i].ShowMessage();
            ((Talent) animals[i]).ShowTalent();
        }
    }
}

