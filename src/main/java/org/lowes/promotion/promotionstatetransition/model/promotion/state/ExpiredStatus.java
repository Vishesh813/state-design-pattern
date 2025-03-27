package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import lombok.extern.slf4j.Slf4j;
import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStatusType;
import org.lowes.promotion.promotionstatetransition.exception.OfferInvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferStatus;

import java.time.LocalDate;

@Slf4j
public class ExpiredStatus implements OfferStatus {

  @Override
  public void changeStateTo(Offer offer) {
    OfferStatusType currentState = offer.getStatus();
    LocalDate currentDate = LocalDate.now();
    boolean isPromotionExpired = currentDate.isAfter(offer.getEndDate());
    boolean isLivePromotion = currentState.equals(OfferStatusType.LIVE);
    if (isPromotionExpired && isLivePromotion) {
      throw new OfferInvalidStateTransitionException(
          "Invalid state transition from LIVE to EXPIRED");
    }
    offer.setActive(false);
    log.info("Offer got expired Expired.");
  }

}
