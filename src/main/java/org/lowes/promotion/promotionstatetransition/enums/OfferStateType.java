package org.lowes.promotion.promotionstatetransition.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.*;

public enum OfferStateType {
  DRAFT,
  PROPOSED,
  APPROVED,
  APPROVED_LOCKED,
  LIVE,
  DEACTIVATED,
  DELETE,
  EXPIRED;

  private static final Map<OfferStateType, Set<OfferStateType>> allowedTransitions = new HashMap<>();

  static {
    allowedTransitions.put(DRAFT, Set.of(PROPOSED));
    allowedTransitions.put(PROPOSED, Set.of(APPROVED, DRAFT));
    allowedTransitions.put(APPROVED, Set.of(APPROVED_LOCKED, LIVE));
    allowedTransitions.put(APPROVED_LOCKED, Set.of(LIVE));
    allowedTransitions.put(LIVE, Set.of(DEACTIVATED, EXPIRED,LIVE));
    allowedTransitions.put(DEACTIVATED, Set.of(LIVE));
    allowedTransitions.put(EXPIRED, Set.of()); // No transitions allowed
  }

  public boolean canTransitionTo(OfferStateType newState) {
    return allowedTransitions.getOrDefault(this, Collections.emptySet()).contains(newState);
  }
}
