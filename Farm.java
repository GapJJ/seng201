import java.util.ArrayList;
import java.util.Scanner;

public class Farm {
    Scanner scan = new Scanner(System.in);

    private final String name;
    private String type;
    private Farmer farmer;
    private ArrayList<Crop> crops;
    private ArrayList<Animal> animals;
    private int bank;

    public Farm(Farmer playerFarmer, String farmType){
        System.out.println("What is your farm name?");
        String farmname = scan.nextLine();
        name = farmname;
        type = farmType;
        farmer = playerFarmer; 
        crops = new ArrayList<Crop>();
        animals = new ArrayList<Animal>();
        bank = 500;

        //just for testing
        crops.add(new Carrot());
        crops.add(new Corn());
        animals.add(new Pig());
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public int getBank() {
        return bank;
    }

    public void addMoney(int money) {
        bank += money;
    }

    //crops
    public  ArrayList<Crop> getCrops() {
        return crops;
    }

    public  void reduceAllDTH(int days) {
        for (Crop crop : crops) {
            crop.reduceDTH(days);
        }
    }
    //animals
    public  ArrayList<Animal> getAnimals() {
        return animals;
    }

}