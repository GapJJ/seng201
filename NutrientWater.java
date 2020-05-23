public class NutrientWater extends Item implements CropItem{
    public NutrientWater() {
        setName("Nutrient Water");
        setPPrice(5);
    }

    public String cropItem() {
        return "Using " + this.getName() + " on crop";
    }
}