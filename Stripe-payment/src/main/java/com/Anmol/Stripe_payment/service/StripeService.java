package com.Anmol.Stripe_payment.service;

import com.Anmol.Stripe_payment.dto.ProductRequest;
import com.Anmol.Stripe_payment.dto.StripeResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripeService {


    public StripeResponse checkout(ProductRequest productRequest){
        Stripe.apiKey="Your_KEY";
        SessionCreateParams.LineItem.PriceData.ProductData productData = SessionCreateParams.LineItem.PriceData.ProductData.builder()
                .setName(productRequest.getName()).build();

        SessionCreateParams.LineItem.PriceData priceData= SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency(productRequest.getCurrency()==null?"USD" : productRequest.getCurrency())
                .setUnitAmount(productRequest.getAmount())
                .setProductData(productData).build();

        SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                .setQuantity(productRequest.getQuantity())
                .setPriceData(priceData)
                .build();

        SessionCreateParams params=SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:8080/success")
                .setCancelUrl("http://localhost:8080/cancel")
                .addLineItem(lineItem)
                .build();

        Session session= null;

        try {
            session=Session.create(params);
        } catch (StripeException e) {
            System.out.println(e.getMessage());
        }

        return StripeResponse.builder()
                .status("Success")
                .message("Payment session created successfully !")
                .sessionID(session.getId())
                .sessionURL(session.getUrl())
                .build();


    }
}
