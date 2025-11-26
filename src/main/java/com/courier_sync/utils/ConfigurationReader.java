package com.courier_sync.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import net.thucydides.model.environment.SystemEnvironmentVariables;

/**
 * Clase utilitaria para leer configuraciones desde serenity.conf
 * y variables de entorno
 */
public class ConfigurationReader {

    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    /**
     * Obtiene el email del usuario desde la configuración
     * @return email del usuario
     */
    public static String getUserEmail() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("user.email");
    }

    /**
     * Obtiene la contraseña del usuario desde la configuración
     * @return contraseña del usuario
     */
    public static String getUserPassword() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("user.password");
    }

    /**
     * Obtiene la URL base de la aplicación
     * @return URL base
     */
    public static String getBaseUrl() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");
    }
}

