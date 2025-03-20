package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

import java.time.LocalDate;

public class DeactivatedState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    System.out.println("Offer is now in Deactivated state.");
  }

  @Override
  public void approve(Offer offer) {
    if (LocalDate.now().isBefore(offer.getEndDate())) {
      offer.changeState(OfferStateType.LIVE);
      System.out.println("Offer reactivated from Deactivated to Live.");
    } else {
      throw new InvalidStateTransitionException("Cannot reactivate an expired offer.");
    }
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
