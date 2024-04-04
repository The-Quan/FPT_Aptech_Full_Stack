package session3.exercise2;

public class Battery {
    private int energy;
    public Battery() {
        energy = 100;
    }
    public void setEnergy(int value){
       this.energy = value;
    }
    public int getEnergy(){
        return this.energy;
    }
    public void decreaseEnergy(){
      energy--;
    }
}