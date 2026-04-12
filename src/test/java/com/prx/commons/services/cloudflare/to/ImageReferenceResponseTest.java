package com.prx.commons.services.cloudflare.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("ImageReferenceResponse")
class ImageReferenceResponseTest {

    @Test
    @DisplayName("constructor sets all fields")
    void constructorSetsAllFields() {
        ImageReferenceResponse resp = new ImageReferenceResponse(
                "profiles/u1/avatar.jpg",
                "https://pub.example.r2.dev/profiles/u1/avatar.jpg",
                "image/jpeg");

        assertEquals("profiles/u1/avatar.jpg", resp.objectKey());
        assertEquals("https://pub.example.r2.dev/profiles/u1/avatar.jpg", resp.publicUrl());
        assertEquals("image/jpeg", resp.contentType());
    }

    @Test
    @DisplayName("contentType may be null for list operations")
    void contentTypeCanBeNull() {
        ImageReferenceResponse resp = new ImageReferenceResponse("key", "https://example.com/key", null);
        assertNull(resp.contentType());
    }

    @Test
    @DisplayName("equality is value-based")
    void equalityIsValueBased() {
        ImageReferenceResponse a = new ImageReferenceResponse("key", "url", "image/png");
        ImageReferenceResponse b = new ImageReferenceResponse("key", "url", "image/png");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("toString contains field values")
    void toStringContainsValues() {
        ImageReferenceResponse resp = new ImageReferenceResponse("mykey", "myurl", "image/gif");
        String str = resp.toString();
        assert str.contains("mykey");
        assert str.contains("myurl");
        assert str.contains("image/gif");
    }
}
