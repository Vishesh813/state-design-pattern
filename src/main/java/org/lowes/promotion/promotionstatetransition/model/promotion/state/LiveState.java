package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

import java.time.LocalDate;

public class LiveState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    offer.setActive(true);
    System.out.println("Offer is now in Live state.");
    if (!LocalDate.now().isBefore(offer.getEndDate())) {
      System.out.println("Offer has been expired.");
      offer.setActive(false);
      offer.changeState(OfferStateType.EXPIRED);
    }
  }

}
