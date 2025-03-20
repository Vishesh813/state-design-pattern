package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

import java.time.LocalDate;

public class LiveState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    System.out.println("Offer is now in Live state.");
    if (!LocalDate.now().isBefore(offer.getEndDate())) {
      offer.changeState(OfferStateType.EXPIRED);
    }
  }

  @Override
  public void deactivate(Offer offer) {
    if (LocalDate.now().isBefore(offer.getEndDate())) {
      offer.changeState(OfferStateType.DEACTIVATED);
      System.out.println("Offer moved from Live to Deactivated.");
    } else {
      throw new InvalidStateTransitionException("Cannot deactivate an offer after the end date.");
    }
  }


  @Override
  public void approve(Offer offer) {

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
  public void delete(Offer offer) {

  }

}
