package org.lowes.promotion.promotionstatetransition;

import lombok.extern.slf4j.Slf4j;
import org.lowes.promotion.promotionstatetransition.entity.Offer;
import org.lowes.promotion.promotionstatetransition.enums.OfferStateType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@Slf4j
public class PromotionStateTransitionApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(PromotionStateTransitionApplication.class, args);
  }

  @Override
  public void run(String... args) {
    LocalDate startDate = LocalDate.now().plusDays(1);
    LocalDate endDate = startDate.plusDays(2);
    Offer offer = new Offer(startDate, endDate, false);

    offer.changeState(OfferStateType.PROPOSED);
    offer.changeState(OfferStateType.APPROVED);
    offer.changeState(OfferStateType.APPROVED_LOCKED);

    // Check auto-expiration
    offer.setEndDate(endDate.minusDays(4));
    offer.changeState(OfferStateType.LIVE);
    offer.changeState(OfferStateType.DEACTIVATED);
    offer.changeState(OfferStateType.LIVE);

    //   Try reactivating (should work before end date)
    //offer.changeState(OfferStateType.EXPIRED);

    //   Try to edit (should fail since it's Live)
    log.info("Is offer editable? {} is active ? {}", offer.isEditable(), offer.isActive());
    System.exit(0);
  }
}
