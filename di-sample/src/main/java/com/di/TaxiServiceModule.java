package com.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class TaxiServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        // Базова конфігурація Guice
    }

    @Provides
    public TaxiDriver provideTaxiDriver() {
        TaxiDriver driver = new TaxiDriver("Аліса Сміт", "098-765-4321");
        driver.setCar(new Car("Toyota Camry", "XYZ123")); // Використання setter
        return driver;
    }

    @Provides
    public Client provideClient() {
        return new Client("Джон Доу", "123-456-7890", "Центральний парк", 60.00);
    }
}
