package org.lowes.promotion.promotionstatetransition.controllers;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offer")
public class OfferController {

  @GetMapping("/{id}")
  public Offer getOffer(@PathVariable Long id) {
    return new Offer();
  }


}
