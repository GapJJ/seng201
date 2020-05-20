public class Crop {
    private String cropType;
    private int pPrice;
    private int sPrice;
    private int daysTillHarvest;
    private int daysAlive;

    public String toString() {
        return getCropType() + ". Days until harvestable: " + Integer.toString(getDTH()) + ". Days since sowed: " + Integer.toString(getDaysAlive());
    }

    public void reduceDTH(int reduce) {
        daysTillHarvest -= reduce;
    }

    public void tendToCrop() {
        reduceDTH(1);
    }


    public String getCropType() {
        return cropType;
    }
    public void setCropType(String c) {
        cropType = c;
    }

    public int getPPrice() {
        return daysTillHarvest;
    }
    public void setPPrice(int p) {
        pPrice = p;
    }

    public int getSPrice() {
        return daysAlive;
    }
    public void setSPrice(int s) {
        sPrice = s;
    }

    public int getDTH() {
        return daysTillHarvest;
    }
    public void setDTH(int DTH) {
        daysTillHarvest = DTH;
    }

    public int getDaysAlive() {
        return daysAlive;
    }
    public void setDaysAlive(int days) {
        daysAlive = days;
    }


}