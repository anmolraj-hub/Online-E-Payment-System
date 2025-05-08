package com.Anmol.Stripe_payment.dto;

public class StripeResponse {
    private String status;
    private String message;
    private String sessionID;
    private String sessionURL;

    // Private constructor to enforce the use of the builder
    private StripeResponse(Builder builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.sessionID = builder.sessionID;
        this.sessionURL = builder.sessionURL;
    }

    public static Builder builder() {
        return new Builder();
    }


    // Static nested Builder class
    public static class Builder {
        private String status;
        private String message;
        private String sessionID;
        private String sessionURL;

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder sessionID(String sessionID) {
            this.sessionID = sessionID;
            return this;
        }

        public Builder sessionURL(String sessionURL) {
            this.sessionURL = sessionURL;
            return this;
        }

        public StripeResponse build() {
            return new StripeResponse(this);
        }
    }

    // Getters for the fields
    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getSessionURL() {
        return sessionURL;
    }
}
