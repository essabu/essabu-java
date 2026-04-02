package com.essabu.hr.webhook;

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

    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String SIGNATURE_PREFIX = "sha256=";

    private WebhookVerifier() {
        // Utility class
    }

    /**
     * Verifies that the webhook payload matches the provided signature.
     *
     * @param secret          the webhook shared secret (e.g., "whsec_xxxxx")
     * @param payload         the raw request body as a string
     * @param signatureHeader the value of the X-Essabu-Signature header (format: "sha256=xxx")
     * @return true if the signature is valid, false otherwise
     */
    public static boolean verify(String secret, String payload, String signatureHeader) {
        if (secret == null || secret.isBlank()) {
            return false;
        }
        if (payload == null || signatureHeader == null || signatureHeader.isBlank()) {
            return false;
        }
        if (!signatureHeader.startsWith(SIGNATURE_PREFIX)) {
            return false;
        }

        String providedSignature = signatureHeader.substring(SIGNATURE_PREFIX.length());
        String computedSignature = computeHmac(secret, payload);

        if (computedSignature == null) {
            return false;
        }

        // Constant-time comparison to prevent timing attacks
        return MessageDigest.isEqual(
                computedSignature.getBytes(StandardCharsets.UTF_8),
                providedSignature.getBytes(StandardCharsets.UTF_8)
        );
    }

    /**
     * Computes the HMAC-SHA256 hex digest for the given payload and secret.
     *
     * @param secret  the HMAC secret key
     * @param payload the payload to sign
     * @return hex-encoded HMAC-SHA256 digest, or null on cryptographic failure
     */
    static String computeHmac(String secret, String payload) {
        try {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(
                    secret.getBytes(StandardCharsets.UTF_8),
                    HMAC_ALGORITHM
            );
            mac.init(keySpec);
            byte[] hmacBytes = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hmacBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return null;
        }
    }
}
