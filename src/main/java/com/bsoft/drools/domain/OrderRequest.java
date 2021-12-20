package com.bsoft.drools.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Integer orderId;
    private String paymentType;
    private Integer totalPrice;
    private Integer discount;

    public Integer getPrice() {
        Integer result;
        Double price = totalPrice.doubleValue();

        if ((discount != null) && (discount.intValue() != 0)) {
            price = (100 - discount) * totalPrice / 100.0;
        }
        result = price.intValue();

        return result;
    }
}
