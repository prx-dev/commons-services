package com.prx.commons.services.properties;

import com.prx.commons.services.cloudflare.properties.ManagementAuthenticatorProperties;
import com.prx.commons.services.cloudflare.properties.StoreProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for security settings.
 * This class holds the configuration properties for keystore, truststore, and management authenticator.
 */
@Component
@ConfigurationProperties(prefix = "prx.security")
public class SecurityProperties {

    private StoreProperties keystore;
    private StoreProperties truststore;
    private ManagementAuthenticatorProperties managementAuthenticator;

    /**
     * Default constructor.
     * Creates a new instance of SecurityProperties.
     */
    public SecurityProperties() {
        // Default constructor
    }

    /**
     * Gets the keystore properties.
     *
     * @return the keystore properties
     */
    public StoreProperties getKeystore() {
        return keystore;
    }

    /**
     * Sets the keystore properties.
     *
     * @param keystore the keystore properties to set
     */
    public void setKeystore(StoreProperties keystore) {
        this.keystore = keystore;
    }

    /**
     * Gets the truststore properties.
     *
     * @return the truststore properties
     */
    public StoreProperties getTruststore() {
        return truststore;
    }

    /**
     * Sets the truststore properties.
     *
     * @param truststore the truststore properties to set
     */
    public void setTruststore(StoreProperties truststore) {
        this.truststore = truststore;
    }

    /**
     * Gets the management authenticator properties.
     *
     * @return the management authenticator properties
     */
    public ManagementAuthenticatorProperties getManagementAuthenticator() {
        return managementAuthenticator;
    }

    /**
     * Sets the management authenticator properties.
     *
     * @param managementAuthenticator the management authenticator properties to set
     */
    public void setManagementAuthenticator(ManagementAuthenticatorProperties managementAuthenticator) {
        this.managementAuthenticator = managementAuthenticator;
    }
}
