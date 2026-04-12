package com.prx.commons.services.cloudflare.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ImageUploadRequest")
class ImageUploadRequestTest {

    private static final byte[] VALID_DATA = new byte[]{1, 2, 3};
    private static final String JPEG = "image/jpeg";

    // =========================================================================
    // Validation — null / empty guards
    // =========================================================================

    @Test
    @DisplayName("null data throws NullPointerException")
    void nullDataThrows() {
        assertThrows(NullPointerException.class,
                () -> new ImageUploadRequest(null, null, JPEG, null));
    }

    @Test
    @DisplayName("empty data throws IllegalArgumentException")
    void emptyDataThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new ImageUploadRequest(null, new byte[0], JPEG, null));
    }

    @Test
    @DisplayName("null contentType throws NullPointerException")
    void nullContentTypeThrows() {
        assertThrows(NullPointerException.class,
                () -> new ImageUploadRequest(null, VALID_DATA, null, null));
    }

    // =========================================================================
    // Construction — direct constructor
    // =========================================================================

    @Test
    @DisplayName("valid constructor sets all fields")
    void validConstructorSetsFields() {
        Map<String, String> meta = Map.of("userId", "u1");
        ImageUploadRequest req = new ImageUploadRequest("key/avatar.jpg", VALID_DATA, JPEG, meta);

        assertEquals("key/avatar.jpg", req.objectKey());
        assertEquals(JPEG, req.contentType());
        assertEquals("u1", req.metadata().get("userId"));
    }

    @Test
    @DisplayName("null objectKey is allowed")
    void nullObjectKeyAllowed() {
        ImageUploadRequest req = new ImageUploadRequest(null, VALID_DATA, JPEG, null);
        assertNull(req.objectKey());
    }

    @Test
    @DisplayName("null metadata becomes empty map")
    void nullMetadataBecomeEmptyMap() {
        ImageUploadRequest req = new ImageUploadRequest(null, VALID_DATA, JPEG, null);
        assertNotNull(req.metadata());
        assertTrue(req.metadata().isEmpty());
    }

    @Test
    @DisplayName("metadata map is unmodifiable")
    void metadataIsUnmodifiable() {
        Map<String, String> mutable = new HashMap<>();
        mutable.put("k", "v");
        ImageUploadRequest req = new ImageUploadRequest(null, VALID_DATA, JPEG, mutable);
        assertThrows(UnsupportedOperationException.class, () -> req.metadata().put("x", "y"));
    }

    // =========================================================================
    // Defensive copy of byte array
    // =========================================================================

    @Test
    @DisplayName("data is defensively copied on construction")
    void dataIsDefensivelyCopied() {
        byte[] original = new byte[]{10, 20, 30};
        ImageUploadRequest req = new ImageUploadRequest(null, original, JPEG, null);
        original[0] = 99;
        assertEquals(10, req.data()[0]);
    }

    @Test
    @DisplayName("data array is a different reference than the input")
    void dataArrayIsCopy() {
        byte[] original = new byte[]{1, 2, 3};
        ImageUploadRequest req = new ImageUploadRequest(null, original, JPEG, null);
        assertNotSame(original, req.data());
    }

    // =========================================================================
    // Factory methods
    // =========================================================================

    @Test
    @DisplayName("of(data, contentType) sets null objectKey")
    void factoryOfDataContentType() {
        ImageUploadRequest req = ImageUploadRequest.of(VALID_DATA, JPEG);
        assertNull(req.objectKey());
        assertArrayEquals(VALID_DATA, req.data());
        assertEquals(JPEG, req.contentType());
        assertTrue(req.metadata().isEmpty());
    }

    @Test
    @DisplayName("of(objectKey, data, contentType) sets objectKey")
    void factoryOfKeyDataContentType() {
        ImageUploadRequest req = ImageUploadRequest.of("profiles/u1/a.jpg", VALID_DATA, JPEG);
        assertEquals("profiles/u1/a.jpg", req.objectKey());
        assertArrayEquals(VALID_DATA, req.data());
        assertEquals(JPEG, req.contentType());
    }

    @Test
    @DisplayName("of(objectKey, data, contentType, metadata) sets all fields")
    void factoryOfKeyDataContentTypeMetadata() {
        Map<String, String> meta = Map.of("source", "web");
        ImageUploadRequest req = ImageUploadRequest.of("k", VALID_DATA, JPEG, meta);
        assertEquals("k", req.objectKey());
        assertEquals("web", req.metadata().get("source"));
    }
}
