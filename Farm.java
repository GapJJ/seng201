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
        Carrot carrot = new Carrot();
        crops.add(new Carrot());
        crops.add(new Corn());
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public int getBank() {
        return bank;
    }

    public  ArrayList<Crop> getCrops() {
        return crops;
    }

}