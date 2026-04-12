package com.prx.commons.services.properties;

import com.prx.commons.services.cloudflare.properties.ManagementAuthenticatorProperties;
import com.prx.commons.services.cloudflare.properties.StoreProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("SecurityProperties")
class SecurityPropertiesTest {

    private SecurityProperties props;

    @BeforeEach
    void setUp() {
        props = new SecurityProperties();
    }

    @Test
    @DisplayName("default constructor initialises fields to null")
    void defaultConstructorFieldsAreNull() {
        assertNull(props.getKeystore());
        assertNull(props.getTruststore());
        assertNull(props.getManagementAuthenticator());
    }

    @Test
    @DisplayName("setKeystore / getKeystore round-trip")
    void keystoreRoundTrip() {
        StoreProperties keystore = new StoreProperties();
        keystore.setLocation("/etc/ssl/keystore.p12");
        props.setKeystore(keystore);
        assertEquals("/etc/ssl/keystore.p12", props.getKeystore().getLocation());
    }

    @Test
    @DisplayName("setTruststore / getTruststore round-trip")
    void truststoreRoundTrip() {
        StoreProperties truststore = new StoreProperties();
        truststore.setType("PKCS12");
        props.setTruststore(truststore);
        assertEquals("PKCS12", props.getTruststore().getType());
    }

    @Test
    @DisplayName("setManagementAuthenticator / getManagementAuthenticator round-trip")
    void managementAuthenticatorRoundTrip() {
        ManagementAuthenticatorProperties auth = new ManagementAuthenticatorProperties();
        auth.setKeyAlias("mgmt-alias");
        props.setManagementAuthenticator(auth);
        assertEquals("mgmt-alias", props.getManagementAuthenticator().getKeyAlias());
    }
}
