package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

public class DeletedState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    offer.setActive(false);
    System.out.println("Delete state");
  }

  @Override
  public boolean isEditable() {
    return OfferState.super.isEditable();
  }
}
