public class Animal {

    private int pPrice;
    private int moneyGained;
    private int health;
    private int happiness;

    public void setPPrice(int p) {
        pPrice = p;
    }
    public int getPPrice() {
        return pPrice;
    }
    public void setMoneyGained(int m) {
        moneyGained = m;
    }
    public int getMoneyGained() {
        return moneyGained;
    }
    public void setHealth(int h) {
        health = h;
    }
    public int getHealth() {
        return health;
    }
    public void setHappiness(int h) {
        happiness = h;
    }
    public int getHappiness() {
        return happiness;
    }


    public int tendToAnimal() {
        return moneyGained;
    }

}