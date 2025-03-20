package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

import java.time.LocalDate;

public class ApprovedLockedState implements OfferState {
  @Override
  public void enterState(Offer offer) {
    System.out.println("Offer is now in Approved Locked state.");

    if (LocalDate.now().isEqual(offer.getStartDate())) {
      offer.changeState(OfferStateType.LIVE);
    }
  }

  @Override
  public void approve(Offer offer) {
    throw new InvalidStateTransitionException("Locked offers cannot be approved again.");
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
