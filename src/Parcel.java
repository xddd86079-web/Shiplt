abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }

    public int calculateDeliveryCost() {
        return weight * getBaseCost();
    }

    protected abstract int getBaseCost();
}
