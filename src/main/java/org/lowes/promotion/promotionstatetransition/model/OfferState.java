package org.lowes.promotion.promotionstatetransition.model;

import org.lowes.promotion.promotionstatetransition.entity.Offer;

public interface OfferState {

  void enterState(Offer offer); // Called when entering this state


  void approve(Offer offer);

  void propose(Offer offer);

  void cancel(Offer offer);

  void expire(Offer offer);

  void deactivate(Offer offer);

  void delete(Offer offer);

  default boolean isEditable() {
    return false;
  }
}

