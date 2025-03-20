package org.lowes.promotion.promotionstatetransition.model;

import org.lowes.promotion.promotionstatetransition.entity.Offer;

public interface OfferState {

  void enterState(Offer offer);

  default boolean isEditable() {
    return false;
  }
}

