public class Animal {

    private String animalType;
    private int pPrice;
    private int moneyGained;
    private int health;
    private int happiness;
    private int foodHealthAmount;
    private int playHappyAmount;
    public String toString() {
        return getAnimalType() + ". Happiness Level: " + Integer.toString(getHappiness()) + ". Health Level: " + Integer.toString(getHealth());
    }

    //animal type
    public void setAnimalType(String a) {
        animalType = a;
    }
    public String getAnimalType() {
        return animalType;
    }

    //prices
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
    //health
    public void setHealth(int h) {
        health = h;
    }
    public int getHealth() {
        return health;
    }

    public void raiseHealthiness() {
        health += foodHealthAmount;
    }

    //happniness
    public void setHappiness(int h) {
        happiness = h;
    }
    public int getHappiness() {
        return happiness;
    }
    
    public void raiseHappiness() {
        happiness += playHappyAmount;
    }

}