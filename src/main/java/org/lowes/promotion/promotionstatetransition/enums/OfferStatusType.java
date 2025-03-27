package org.lowes.promotion.promotionstatetransition.enums;

import org.lowes.promotion.promotionstatetransition.util.Constants;

import java.util.Collections;

public enum OfferStatusType {
  DRAFT,
  PROPOSED,
  APPROVED,
  APPROVED_LOCKED,
  LIVE,
  DEACTIVATED,
  DELETED,
  CANCELLED,
  EXPIRED;


  public boolean canTransitionTo(OfferStatusType newState) {
    return Constants.allowedTransitions.getOrDefault(this, Collections.emptySet())
        .contains(newState);
  }
}
