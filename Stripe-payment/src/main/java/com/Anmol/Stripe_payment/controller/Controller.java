package com.Anmol.Stripe_payment.controller;

import com.Anmol.Stripe_payment.dto.ProductRequest;
import com.Anmol.Stripe_payment.dto.StripeResponse;
import com.Anmol.Stripe_payment.service.StripeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/v1")
public class Controller {

    private StripeService stripeService;

    public Controller(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkout(@RequestBody ProductRequest productRequest){
        StripeResponse stripeResponse= stripeService.checkout(productRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stripeResponse);

    }

}
