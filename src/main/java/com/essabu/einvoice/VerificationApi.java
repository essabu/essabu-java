package com.essabu.einvoice;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;

import java.util.Map;

/**
 * API client for public e-invoice verification operations.
 * Endpoint base: /api/public/einvoice
 */
public final class VerificationApi extends BaseApi {

    private static final String BASE = "/api/public/einvoice";

    public VerificationApi(HttpClientWrapper http) {
        super(http);
    }

    public Map verify(String verificationCode) {
        return http.get(BASE + "/verify?code=" + verificationCode, Map.class);
    }

    public Map verifyByQrCode(String qrData) {
        return http.post(BASE + "/verify-qr", Map.of("qrData", qrData), Map.class);
    }
}
