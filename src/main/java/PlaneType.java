public enum PlaneType {
    AIRBUS_A320(8, 352),
    BOEING_737(10, 500),
    CONCORDE(5, 200);

    private final int capacity;
    private final int totalWeight;

    PlaneType(int capacity, int totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getTotalWeight(){
        return totalWeight;
    }
}
