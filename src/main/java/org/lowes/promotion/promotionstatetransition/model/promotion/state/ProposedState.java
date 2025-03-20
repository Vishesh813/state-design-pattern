package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

public class ProposedState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    offer.setActive(true);
    System.out.println("Offer is now in Proposed state.");
  }

}
