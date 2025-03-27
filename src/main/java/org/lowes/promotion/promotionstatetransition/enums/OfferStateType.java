package org.lowes.promotion.promotionstatetransition.enums;

import org.lowes.promotion.promotionstatetransition.util.Constants;

import java.util.Collections;

public enum OfferStateType {
  DRAFT,
  PROPOSED,
  APPROVED,
  APPROVED_LOCKED,
  LIVE,
  DEACTIVATED,
  DELETED,
  CANCELLED,
  EXPIRED;


  public boolean canTransitionTo(OfferStateType newState) {
    return Constants.allowedTransitions.getOrDefault(this, Collections.emptySet())
        .contains(newState);
  }
}
