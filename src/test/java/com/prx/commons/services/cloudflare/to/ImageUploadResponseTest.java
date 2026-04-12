package com.prx.commons.services.cloudflare.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ImageUploadResponse")
class ImageUploadResponseTest {

    @Test
    @DisplayName("constructor sets all fields")
    void constructorSetsAllFields() {
        ImageUploadResponse resp = new ImageUploadResponse(
                "profiles/u1/avatar.jpg",
                "https://pub.example.r2.dev/profiles/u1/avatar.jpg",
                "image/jpeg",
                45231L);

        assertEquals("profiles/u1/avatar.jpg", resp.objectKey());
        assertEquals("https://pub.example.r2.dev/profiles/u1/avatar.jpg", resp.publicUrl());
        assertEquals("image/jpeg", resp.contentType());
        assertEquals(45231L, resp.size());
    }

    @Test
    @DisplayName("equality is value-based")
    void equalityIsValueBased() {
        ImageUploadResponse a = new ImageUploadResponse("key", "url", "image/png", 100L);
        ImageUploadResponse b = new ImageUploadResponse("key", "url", "image/png", 100L);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("toString contains field values")
    void toStringContainsValues() {
        ImageUploadResponse resp = new ImageUploadResponse("mykey", "myurl", "image/gif", 999L);
        String str = resp.toString();
        assert str.contains("mykey");
        assert str.contains("myurl");
        assert str.contains("image/gif");
        assert str.contains("999");
    }
}
