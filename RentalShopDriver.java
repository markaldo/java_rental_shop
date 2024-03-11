package z02_eng_v2II;

public class RentalShopDriver {
    public static void main(String[] args) {
        // Creating a new rental shop with 5 garages
        RentalShop rentalShop = new RentalShop(5);

        // Adding some vehicles to the rental shop
        Car blueCar = new Car("Blue Car", 2, 50);
        Motorboat redBoat = new Motorboat("Red Boat", 1, 100);
        Bicycle greenBike = new Bicycle("Green Bike");
        Scooter yellowScooter = new Scooter("Yellow Scooter", 8, 80);
        Car honda1 = new Car("Honda", 2, 20);
        Car bmw = new Car("BMW M3", 2, 40);
        Car mercedes = new Car("Mercedes AMG", 2, 28);
        Car audi = new Car("Audi S", 2, 25);
        Car volvo = new Car("Volvo", 2, 22);
        Car volzswagen = new Car("Volzswagen", 2, 20);
        Bicycle bike = new Bicycle("Giant");
        Scooter grayScooter = new Scooter("Gray Scooter", 8, 80);
        

        rentalShop.addVehicle(blueCar);
        rentalShop.addVehicle(redBoat);
        rentalShop.addVehicle(greenBike);
        rentalShop.addVehicle(yellowScooter);
        rentalShop.addVehicle(honda1);
        rentalShop.addVehicle(bmw);
        rentalShop.addVehicle(mercedes);
        rentalShop.addVehicle(audi);
        rentalShop.addVehicle(volvo);
        rentalShop.addVehicle(volzswagen);
        rentalShop.addVehicle(bike);
        rentalShop.addVehicle(grayScooter);

        // Listing all vehicles in the rental shop
        System.out.println("All vehicles in the rental shop:");
        rentalShop.listVehicles();

        // Sorting vehicles by parked status and list them
        rentalShop.sortVehiclesByParked();
        System.out.println("\nVehicles sorted by parked status:");
        rentalShop.listVehicles();

        // Sorting vehicles by type and list them
        rentalShop.sortVehiclesByType();
        System.out.println("\nVehicles sorted by type:");
        rentalShop.listVehicles();

        // Sorting vehicles by name and list them
        rentalShop.sortVehiclesByName();
        System.out.println("\nVehicles sorted by name:");
        rentalShop.listVehicles();

        // Sorting vehicles by fuel type and list them
        rentalShop.sortVehiclesByFuelType();
        System.out.println("\nVehicles sorted by fuel type:");
        rentalShop.listVehicles();

        // Sorting vehicles by fuel quantity and list them
        rentalShop.sortVehiclesByFuelQuantity();
        System.out.println("\nVehicles sorted by fuel quantity:");
        rentalShop.listVehicles();

        // Removing a vehicle from the rental shop
        rentalShop.deleteVehicle(yellowScooter.getId());

        // Listing the remaining vehicles in the rental shop
        System.out.println("\nRemaining vehicles in the rental shop:");
        rentalShop.listVehicles();
    }
}
