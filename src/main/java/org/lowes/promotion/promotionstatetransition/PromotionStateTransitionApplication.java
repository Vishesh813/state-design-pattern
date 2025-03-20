package org.lowes.promotion.promotionstatetransition;

import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PromotionStateTransitionApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(PromotionStateTransitionApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // Creating an offer with start date = today and end date = tomorrow
    LocalDate startDate = LocalDate.now();
    LocalDate endDate = startDate.plusDays(1);

    Offer offer = new Offer(startDate, endDate, startDate.plusDays(5),false);

    //   Move to Proposed
    offer.changeState(OfferStateType.PROPOSED);

    //offer.changeState(OfferStateType.DELETE);

    //   Move to Approved
    offer.changeState(OfferStateType.APPROVED);

    //   Move to Approved Locked (should auto-move to Live if today == startDate)
    offer.changeState(OfferStateType.APPROVED_LOCKED);

    //   Check auto-expiration
    System.out.println("---- Check auto-expiration ---");
    //offer.setEndDate(endDate.minusDays(4));
    offer.changeState(OfferStateType.LIVE);

    //   Move to Deactivated
    offer.changeState(OfferStateType.DEACTIVATED);

    //   Try reactivating (should work before end date)
    offer.changeState(OfferStateType.LIVE);

    //   Try to edit (should fail since it's Live)
    System.out.println("Is offer editable? " + offer.isEditable() + " is active ? " + offer.isActive());
    System.exit(0);
  }
}
