package model;

public class Customer extends User {

    private String address;

    public Customer(String name, String email, String phone, String address) {
        super(name, email, phone); // User sınıfının özelliklerini alır
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Müşteri: " + getName() + " (" + address + ")";
    }
}