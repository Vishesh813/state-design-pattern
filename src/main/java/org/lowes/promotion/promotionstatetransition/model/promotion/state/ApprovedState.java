package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

public class ApprovedState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    System.out.println("Offer is now in Approved state.");
  }

  @Override
  public void approve(Offer offer) {
    throw new InvalidStateTransitionException("Offer is already Approved.");
  }

  @Override
  public void propose(Offer offer) {

  }

  @Override
  public void cancel(Offer offer) {
    throw new InvalidStateTransitionException("Offer is already Approved.");
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
