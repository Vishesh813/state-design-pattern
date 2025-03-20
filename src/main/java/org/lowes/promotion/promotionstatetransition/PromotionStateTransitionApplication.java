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
    Offer offer = new Offer(LocalDate.now(), LocalDate.now().plusDays(1),
        LocalDate.now().plusDays(5));

    // ✅ Move to Proposed
    offer.changeState(OfferStateType.PROPOSED);

    // ✅ Move to Approved
    offer.changeState(OfferStateType.APPROVED);

    // ✅ Move to Approved Locked (should auto-move to Live if today == startDate)
    offer.changeState(OfferStateType.APPROVED_LOCKED);

    // ✅ Check auto-expiration
    System.out.println("---- Check auto-expiration ---");
    offer.changeState(OfferStateType.LIVE);

    // ✅ Move to Deactivated
    offer.changeState(OfferStateType.DEACTIVATED);

    // ✅ Try reactivating (should work before end date)
    offer.changeState(OfferStateType.LIVE);

    // ✅ Try to edit (should fail since it's Live)
    System.out.println("Is offer editable? " + offer.isEditable());
  }
}
