package org.lowes.promotion.promotionstatetransition;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferStatus;

public abstract class AbstractOfferStatus implements OfferStatus {

  @Override
  public void changeStateTo(Offer offer) {
    // Default implementation (can be overridden if needed)
  }
}

