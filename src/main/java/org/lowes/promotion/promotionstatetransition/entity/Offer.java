package org.lowes.promotion.promotionstatetransition.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.promotion.state.StateManager;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {

  private OfferStateType currentState = OfferStateType.DRAFT;
  private LocalDate startDate;
  @Setter
  private LocalDate endDate;
  private LocalDate promotionDeadline;
  private boolean active;


  public Offer(LocalDate startDate, LocalDate endDate,
      LocalDate promotionDeadline, boolean active) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.promotionDeadline = promotionDeadline;
    this.active = active;
    System.out.println("Offer is now in Draft state.");
  }


  public void changeState(OfferStateType newState) {
    if (!this.currentState.canTransitionTo(newState)) {
      throw new InvalidStateTransitionException(
          "Invalid transition: " + this.currentState + " → " + newState);
    }
    this.currentState = newState;
    StateManager.getState(newState).enterState(this);
  }


  public boolean isEditable() {
    return StateManager.getState(currentState).isEditable();
  }

}

