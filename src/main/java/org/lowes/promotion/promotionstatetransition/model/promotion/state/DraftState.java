package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

public class DraftState implements OfferState {

  @Override
  public void approve(Offer offer) {
    offer.changeState(OfferStateType.APPROVED);
    System.out.println("Offer moved from Draft to Approved.");
  }

  public void enterState(Offer offer) {
    System.out.println("Offer is now in Draft state.");
  }

  @Override
  public void propose(Offer offer) {
    offer.changeState(OfferStateType.PROPOSED);
    System.out.println("Offer moved from Draft to Proposed.");
  }

  @Override
  public void cancel(Offer offer) {
    throw new InvalidStateTransitionException("Draft offers cannot be canceled.");
  }

  @Override
  public void expire(Offer offer) {
    throw new InvalidStateTransitionException("Draft offers cannot be expired.");
  }

  @Override
  public void deactivate(Offer offer) {
    throw new InvalidStateTransitionException("Draft offers cannot be deactivated.");
  }

  @Override
  public void delete(Offer offer) {
    offer.changeState(OfferStateType.DELETE);
    System.out.println("Offer moved from Draft to Deleted.");
  }

  @Override
  public boolean isEditable() {
    return true;
  }
}
