package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import lombok.extern.slf4j.Slf4j;
import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

import java.time.LocalDate;

@Slf4j
public class ApprovedAndLockedState implements OfferState {

  @Override
  public void enterState(Offer offer) {
    log.info("Offer is now in Approved Locked state.");

    if (LocalDate.now().isEqual(offer.getStartDate())) {
      offer.changeState(OfferStateType.LIVE);
    }
    offer.setActive(true);
  }

}
