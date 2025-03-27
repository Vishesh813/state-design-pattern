package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.enums.OfferStatusType;
import org.lowes.promotion.promotionstatetransition.exception.OfferInvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferStatus;

import java.util.Map;


public class StateManager {

  private static final Map<OfferStatusType, OfferStatus> statusInstances = Map.of(
      OfferStatusType.DRAFT, new DraftStatus(),
      OfferStatusType.PROPOSED, new ProposedStatus(),
      OfferStatusType.APPROVED, new ApprovedStatus(),
      OfferStatusType.APPROVED_LOCKED, new ApprovedAndLockedStatus(),
      OfferStatusType.LIVE, new LiveStatus(),
      OfferStatusType.DEACTIVATED, new DeactivatedStatus(),
      OfferStatusType.EXPIRED, new ExpiredStatus(),
      OfferStatusType.DELETED, new DeletedStatus()
  );

  public static OfferStatus getStatus(OfferStatusType type) {
    if (statusInstances.get(type) == null) {
      throw new OfferInvalidStateTransitionException("No state found for type " + type);
    }
    return statusInstances.get(type);
  }
}



