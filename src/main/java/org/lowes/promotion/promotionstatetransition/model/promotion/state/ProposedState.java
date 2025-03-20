package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

public class ProposedState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    System.out.println("Offer is now in Proposed state.");
  }

  @Override
  public void approve(Offer offer) {
    offer.changeState(OfferStateType.PROPOSED);
    System.out.println("Offer moved from Proposed to Approved.");
  }

  @Override
  public void propose(Offer offer) {

  }

  @Override
  public void cancel(Offer offer) {

  }

  @Override
  public void expire(Offer offer) {

  }

  @Override
  public void deactivate(Offer offer) {

  }

  @Override
  public void delete(Offer offer) {

  }

}
