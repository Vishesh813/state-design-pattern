package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

public class CancelState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    offer.setActive(true);
    System.out.println("Offer is now in Cancel state.");
  }

  @Override
  public boolean isEditable(){
   return true;
  }
}
