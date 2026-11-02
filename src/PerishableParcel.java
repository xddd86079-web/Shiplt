public class PerishableParcel extends Parcel {
    private static final int PERISHABLE_DELIVERY_COST = 3;
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    protected int getBaseCost() {
        return PERISHABLE_DELIVERY_COST;
    }

    public boolean isExpired(int currentDay) {
        return getSendDay() + timeToLive < currentDay;
    }
}
