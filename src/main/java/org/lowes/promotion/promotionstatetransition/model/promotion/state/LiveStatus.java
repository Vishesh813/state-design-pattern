package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import lombok.extern.slf4j.Slf4j;
import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.model.OfferStatus;

import java.time.LocalDate;

@Slf4j
public class LiveStatus implements OfferStatus {

  @Override
  public void changeState(Offer offer) {
    LocalDate currentDate = LocalDate.now();
    // System.out.println("currentDate "+ currentDate + " end date " + offer.getEndDate());
    boolean isPromotionExpired = currentDate.isAfter(offer.getEndDate());
    if (isPromotionExpired) {
      offer.setActive(false);
      offer.changeState(OfferStateType.EXPIRED);
      return;
    }
    offer.setActive(true);
    log.info("Offer is now in Live state.");
  }

}
