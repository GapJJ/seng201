import java.util.ArrayList;
import java.util.Scanner;

public class Farm {
    Scanner scan = new Scanner(System.in);

    private final String name;
    private String type;
    private Farmer farmer;
    private ArrayList<Crop> crops;
    private ArrayList<Animal> animals;
    private ArrayList<Item> items;
    private int bank;

    public Farm(Farmer playerFarmer, String farmType){
        System.out.println("What is your farm name?");
        String farmname = scan.nextLine();
        name = farmname;
        type = farmType;
        farmer = playerFarmer; 
        crops = new ArrayList<Crop>();
        animals = new ArrayList<Animal>();
        items = new ArrayList<Item>();
        bank = 500;

        //just for testing
        crops.add(new Carrot());
        crops.add(new Corn());
        animals.add(new Pig());
        animals.add(new Llama());
        animals.add(new Sheep());
        items.add(new AnimalToy());
        items.add(new NutrientWater());

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

    public void tendCrop(String selection) {
        for (Crop crop : crops) {
            if (crop.getCropType().equals(selection)) {
                crop.reduceDTH(1);
            }
        }
    }

        //tend crop with item
    public void tendCrop(String selection, Item item) {
        if (item.getName().equals("Nutrient Water")) {
            for (Crop crop : crops) {
                if (crop.getCropType().equals(selection)) {
                    crop.reduceDTH(1);
                }
            }
        }        
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

    public void feedAllAnimals() {
        for (Animal animal : animals) {
            animal.raiseHealthiness();
        }
    }

    public void playAllAnimals() {
        for (Animal animal : animals) {
            animal.raiseHappiness();
        }
    }

    //items

    public ArrayList<Item> getItems() {
        return items;
    }

    public void use(Item item) {
        if (item.getName().equals("Animal Toy")) {
            for (Animal animal : animals) {
                animal.raiseHappiness();
            }
        }
    }

    public Item remove(Item item) {
        System.out.println(items.remove(item));
        return new NutrientWater();
    }

}