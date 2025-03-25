package org.lowes.promotion.promotionstatetransition.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.OfferInvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.promotion.state.StateManager;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Offer {

  private OfferStateType currentState = OfferStateType.DRAFT;
  private LocalDate startDate;
  private LocalDate endDate;
  private boolean active;


  public Offer(LocalDate startDate, LocalDate endDate, boolean active) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.active = active;
    log.info("Offer is now in Draft state.");
  }


  public void changeState(OfferStateType newState) {
    if (!this.currentState.canTransitionTo(newState)) {
      throw new OfferInvalidStateTransitionException(
          "Invalid state transition: " + this.currentState + " → " + newState);
    }
    this.currentState = newState;
    StateManager.getState(newState).enterState(this);
  }


  public boolean isEditable() {
    return StateManager.getState(currentState).isEditable();
  }

}

