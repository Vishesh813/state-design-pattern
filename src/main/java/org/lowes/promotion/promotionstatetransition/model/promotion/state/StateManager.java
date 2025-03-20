package org.lowes.promotion.promotionstatetransition.model.promotion.state;

import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.OfferState;

import java.util.Map;


public class StateManager {

  private static final Map<OfferStateType, OfferState> stateInstances = Map.of(
      OfferStateType.DRAFT, new DraftState(),
      OfferStateType.PROPOSED, new ProposedState(),
      OfferStateType.APPROVED, new ApprovedState(),
      OfferStateType.APPROVED_LOCKED, new ApprovedLockedState(),
      OfferStateType.LIVE, new LiveState(),
      OfferStateType.DEACTIVATED, new DeactivatedState(),
      OfferStateType.EXPIRED, new ExpiredState()
  );

  public static OfferState getState(OfferStateType type) {
    if (stateInstances.get(type) == null) {
      throw new InvalidStateTransitionException("No state found for type " + type);
    }
    return stateInstances.get(type);
  }
}



