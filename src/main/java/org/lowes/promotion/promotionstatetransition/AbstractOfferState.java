package org.lowes.promotion.promotionstatetransition;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

public abstract class AbstractOfferState implements OfferState {
  @Override
  public void enterState(Offer offer) {
    // Default implementation (can be overridden if needed)
  }
}

