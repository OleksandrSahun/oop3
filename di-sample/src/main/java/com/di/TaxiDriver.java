package com.di;

import com.google.inject.Inject;

import java.util.Random;

public class TaxiDriver extends AbstractPerson implements RideInterface {
    private Car car;
    private String currentRoute;
    private double distance;

    private static final double BASE_FARE = 10.0;
    private static final double FARE_PER_KM = 5.0;

    // Конструктор для передачі параметрів AbstractPerson
    public TaxiDriver(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    // Метод setter для впровадження Car
    @Inject
    public void setCar(Car car) {
        this.car = car;
    }

    // Реалізація методу buildRoute
    @Override
    public void buildRoute(String currentLocation, String destination) {
        currentRoute = currentLocation + " -> " + destination;
        System.out.println(getName() + " будує маршрут: " + currentRoute + ".");
    }

    // Реалізація методу calculateRideCost
    @Override
    public double calculateRideCost(double distance) {
        return BASE_FARE + (FARE_PER_KM * distance);
    }

    // Реалізація методу markComplete
    @Override
    public void markComplete() {
        System.out.println(getName() + " завершив поїздку за маршрутом: " + currentRoute + ".");
        currentRoute = null;
    }

    // Додатковий метод acceptOrder
    public void acceptOrder(Client client, String currentLocation) {
        System.out.println(getName() + " прийняв замовлення від " + client.getName() + ".");
        buildRoute(currentLocation, client.getDestination());
        distance = new Random().nextInt(16) + 5; // Генерація відстані 5-20 км для прикладу
        double cost = calculateRideCost(distance);
        System.out.println("Відстань: " + distance + " км. Вартість поїздки: " + cost + " грн.");

        if (client.payForRide(cost)) {
            markComplete();
        } else {
            System.out.println("Поїздку не завершено через несплату.");
        }
    }

    // Реалізація абстрактного методу login
    @Override
    public boolean login(String phoneNumber) {
        if (getPhoneNumber().equals(phoneNumber)) {
            System.out.println(getName() + " успішно увійшов у систему як водій.");
            return true;
        }
        System.out.println("Помилка входу.");
        return false;
    }
}