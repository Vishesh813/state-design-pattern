package org.lowes.promotion.promotionstatetransition.util;

import lombok.experimental.UtilityClass;
import org.lowes.promotion.promotionstatetransition.enums.OfferStatusType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.APPROVED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.APPROVED_LOCKED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.CANCELLED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.DEACTIVATED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.DELETED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.DRAFT;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.EXPIRED;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.LIVE;
import static org.lowes.promotion.promotionstatetransition.enums.OfferStatusType.PROPOSED;

@UtilityClass
public class Constants {

  public static final Map<OfferStatusType, Set<OfferStatusType>> allowedTransitions = new HashMap<>();

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
