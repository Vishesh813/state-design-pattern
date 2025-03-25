package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

import java.time.LocalDate;

public class ExpiredState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    OfferStateType currentState = offer.getCurrentState();
    LocalDate currentDate = LocalDate.now();
    boolean isPromotionExpired = currentDate.isAfter(offer.getEndDate());
    boolean isLivePromotion = currentState.equals(OfferStateType.LIVE);
    if (isPromotionExpired && isLivePromotion) {
      throw new InvalidStateTransitionException("Invalid state transition from LIVE to EXPIRED");
    }
    offer.setActive(false);
    System.out.println("Offer got expired Expired.");
  }

}
