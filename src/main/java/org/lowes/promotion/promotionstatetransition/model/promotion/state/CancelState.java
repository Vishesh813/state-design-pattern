package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import lombok.extern.slf4j.Slf4j;
import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

@Slf4j
public class CancelState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    offer.setActive(false);
    log.info("Offer cancelled");
  }

}
