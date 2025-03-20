package org.lowes.promotion.promotionstatetransition.entity;

import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.lowes.promotion.promotionstatetransition.exception.InvalidStateTransitionException;
import org.lowes.promotion.promotionstatetransition.model.promotion.state.StateManager;

import java.time.LocalDate;

public class Offer {

  private OfferStateType currentState = OfferStateType.DRAFT;
  private LocalDate startDate;
  private LocalDate endDate;
  private LocalDate promotionDeadline;
  private boolean active;

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Offer(LocalDate startDate, LocalDate endDate,
      LocalDate promotionDeadline, boolean active) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.promotionDeadline = promotionDeadline;
    this.active = active;
    System.out.println("Offer is now in Draft state.");
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

