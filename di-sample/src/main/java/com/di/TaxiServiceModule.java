package com.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class TaxiServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        // Впровадження значень для аргументів Car через @Named
        bind(String.class).annotatedWith(Names.named("CarModel")).toInstance("Toyota Camry");
        bind(String.class).annotatedWith(Names.named("LicenseNumber")).toInstance("XYZ123");
    }

    @Provides
    public Car provideCar() {
        return new Car("Toyota Camry", "XYZ123");
    }

    @Provides
    public TaxiDriver provideTaxiDriver() {
        TaxiDriver driver = new TaxiDriver("Аліса Сміт", "098-765-4321");
        return driver; // Guice автоматично викликає setCar() для цього екземпляра
    }

    @Provides
    public Client provideClient() {
        return new Client("Джон Доу", "123-456-7890", "Центральний парк", 60.00);
    }
}
