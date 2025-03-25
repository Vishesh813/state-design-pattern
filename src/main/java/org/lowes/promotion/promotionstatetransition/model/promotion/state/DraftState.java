package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import lombok.extern.slf4j.Slf4j;
import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

@Slf4j
public class DraftState implements OfferState {

  public void enterState(Offer offer) {
    offer.setActive(false);
    log.info("Offer is now in Draft state.");
  }

  @Override
  public boolean isEditable() {
    return true;
  }
}
