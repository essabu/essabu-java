package com.essabu.accounting.webhook;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Utility class for verifying HMAC-SHA256 signatures on incoming webhook payloads
 * from the Essabu HR API.
 *
 * Provides a static verify method that computes the HMAC-SHA256 digest of the
 * raw webhook payload using the shared secret and compares it against the
 * signature provided in the X-Essabu-Signature request header. The comparison
 * is performed using constant-time equality to prevent timing-based attacks.
 *
 * The expected signature format in the header is "sha256=" followed by the
 * hex-encoded HMAC digest. If the secret, payload, or signature header is
 * null or blank, the verification returns false immediately.
 *
 * This class cannot be instantiated as it only contains static utility methods.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class WebhookVerifier {

    private final String secret;

    public WebhookVerifier(String secret) {
        this.secret = secret;
    }

    /**
     * Verifies that the given signature matches the expected HMAC-SHA256 of the payload.
     *
     * @param payload   the raw request body
     * @param signature the signature header value
     * @return true if the signature is valid
     */
    public boolean verify(String payload, String signature) {
        if (payload == null || signature == null || secret == null) {
            return false;
        }

        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(keySpec);
            byte[] hash = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            String expected = HexFormat.of().formatHex(hash);
            return MessageDigest.isEqual(
                    expected.getBytes(StandardCharsets.UTF_8),
                    signature.getBytes(StandardCharsets.UTF_8)
            );
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return false;
        }
    }
}
