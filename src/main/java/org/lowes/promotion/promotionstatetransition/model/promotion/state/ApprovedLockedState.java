package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
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

}
