package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

public class DraftState implements OfferState {

  public void enterState(Offer offer) {
    System.out.println("Offer is now in Draft state.");
  }

  @Override
  public boolean isEditable() {
    return true;
  }
}
