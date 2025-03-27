package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.OfferInvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferStatus;

import java.util.Map;


public class StateManager {

  private static final Map<OfferStateType, OfferStatus> stateInstances = Map.of(
      OfferStateType.DRAFT, new DraftStatus(),
      OfferStateType.PROPOSED, new ProposedStatus(),
      OfferStateType.APPROVED, new ApprovedStatus(),
      OfferStateType.APPROVED_LOCKED, new ApprovedAndLockedStatus(),
      OfferStateType.LIVE, new LiveStatus(),
      OfferStateType.DEACTIVATED, new DeactivatedStatus(),
      OfferStateType.EXPIRED, new ExpiredStatus(),
      OfferStateType.DELETED, new DeletedStatus()
  );

  public static OfferStatus getState(OfferStateType type) {
    if (stateInstances.get(type) == null) {
      throw new OfferInvalidStateTransitionException("No state found for type " + type);
    }
    return stateInstances.get(type);
  }
}



