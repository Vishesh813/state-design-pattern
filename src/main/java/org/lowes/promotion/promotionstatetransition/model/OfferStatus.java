package org.lowes.promotion.promotionstatetransition.model;

import org.lowes.promotion.promotionstatetransition.entity.Offer;

public interface OfferStatus {

  void changeState(Offer offer);

  default boolean isEditable() {
    return false;
  }
}

