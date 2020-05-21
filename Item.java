public class Item {
    private int pPrice;
    private String name;

    public String toString() {
        return getName();
    }

    //name
    public void setName(String a) {
        name = a;
    }
    public String getName() {
        return name;
    }


    //pPrice
    public void setPPrice(int p) {
        pPrice = p;
    }

    public int getPPrice() {
        return pPrice;
    }

}