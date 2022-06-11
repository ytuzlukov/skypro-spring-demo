package pro.sky.skyprospringdemo.example;

import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.TruckDriver;

public class PolymorphismExample {
    public static void main(String[] args) {
        Driver driver = new TruckDriver(
                "Max",
                "Rocotansky",
                "123",
                "2456",
                1);
        driver.setDriverLicenseNumber("1234");
        System.out.println("driver.getDriverLicenseNumber() = " + driver.getDriverLicenseNumber());
    }
}
