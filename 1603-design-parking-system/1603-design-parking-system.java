class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    // Constructor
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    // Method to add a car
    public boolean addCar(int carType) {
        if (carType == 1) { // Big car
            if (big > 0) {
                big--;
                return true;
            }
            return false;
        } 
        else if (carType == 2) { // Medium car
            if (medium > 0) {
                medium--;
                return true;
            }
            return false;
        } 
        else if (carType == 3) { // Small car
            if (small > 0) {
                small--;
                return true;
            }
            return false;
        }
        return false;
    }
}