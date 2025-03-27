package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import lombok.extern.slf4j.Slf4j;
import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.model.OfferStatus;

@Slf4j
public class DeactivatedStatus implements OfferStatus {

  @Override
  public void changeStateTo(Offer offer) {
    offer.setActive(false);
    log.info("Offer is now in Deactivated state.");
  }
}
