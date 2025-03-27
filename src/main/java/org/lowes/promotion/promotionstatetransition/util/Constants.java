package org.lowes.promotion.promotionstatetransition.util;

import lombok.experimental.UtilityClass;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.APPROVED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.APPROVED_LOCKED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.CANCELLED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.DEACTIVATED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.DELETED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.DRAFT;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.EXPIRED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.LIVE;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStateType.PROPOSED;

@UtilityClass
public class Constants {

  public static final Map<OfferStateType, Set<OfferStateType>> allowedTransitions = new HashMap<>();

  static {
    allowedTransitions.put(DRAFT, Set.of(PROPOSED));
    allowedTransitions.put(PROPOSED, Set.of(APPROVED, DRAFT, DELETED, CANCELLED));
    allowedTransitions.put(APPROVED, Set.of(APPROVED_LOCKED, CANCELLED));
    allowedTransitions.put(APPROVED_LOCKED, Set.of(LIVE, CANCELLED));
    allowedTransitions.put(LIVE, Set.of(DEACTIVATED, EXPIRED, LIVE));
    allowedTransitions.put(DEACTIVATED, Set.of(LIVE));
    allowedTransitions.put(CANCELLED, Set.of(DRAFT, PROPOSED));
    allowedTransitions.put(EXPIRED, Set.of());
    allowedTransitions.put(DELETED, Set.of());
  }


}
