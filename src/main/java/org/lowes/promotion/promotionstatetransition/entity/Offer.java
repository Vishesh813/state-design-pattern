package org.lowes.promotion.promotionstatetransition.entity;

import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.promotion.state.StateManager;

import java.time.LocalDate;

public class Offer {

  private OfferStateType currentState;
  private LocalDate startDate;
  private LocalDate endDate;
  private LocalDate promotionDeadline;

  public Offer(LocalDate startDate, LocalDate endDate, LocalDate promotionDeadline) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.promotionDeadline = promotionDeadline;
    System.out.println("Offer is now in Draft state.");
    this.currentState = OfferStateType.DRAFT;
  }

  public OfferStateType getCurrentState() {
    return currentState;
  }

  public void setCurrentState(
      OfferStateType currentState) {
    this.currentState = currentState;
  }

  public LocalDate getPromotionDeadline() {
    return promotionDeadline;
  }

  public void setPromotionDeadline(LocalDate promotionDeadline) {
    this.promotionDeadline = promotionDeadline;
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

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }
}

