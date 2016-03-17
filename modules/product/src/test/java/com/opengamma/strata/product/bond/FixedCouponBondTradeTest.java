/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.bond;

import static com.opengamma.strata.collect.TestHelper.assertSerialization;
import static com.opengamma.strata.collect.TestHelper.coverBeanEquals;
import static com.opengamma.strata.collect.TestHelper.coverImmutableBean;
import static org.testng.Assert.assertEquals;

import java.time.LocalDate;

import org.testng.annotations.Test;

import com.opengamma.strata.basics.market.ReferenceData;
import com.opengamma.strata.product.TradeInfo;

/**
 * Test {@link FixedCouponBondTrade}.
 */
@Test
public class FixedCouponBondTradeTest {

  private static final ReferenceData REF_DATA = ReferenceData.standard();
  private static final LocalDate TRADE_DATE = LocalDate.of(2015, 3, 25);
  private static final LocalDate SETTLEMENT_DATE = LocalDate.of(2015, 3, 30);
  private static final TradeInfo TRADE_INFO = TradeInfo.builder()
      .tradeDate(TRADE_DATE)
      .settlementDate(SETTLEMENT_DATE)
      .build();
  private static final long QUANTITY = 10;
  private static final double PRICE = 123;
  private static final double PRICE2 = 200;
  private static final FixedCouponBond PRODUCT = FixedCouponBondTest.sut();
  private static final FixedCouponBond PRODUCT2 = FixedCouponBondTest.sut2();

  //-------------------------------------------------------------------------
  public void test_builder_resolved() {
    FixedCouponBondTrade test = sut();
    assertEquals(test.getProduct(), PRODUCT);
    assertEquals(test.getTradeInfo(), TRADE_INFO);
    assertEquals(test.getQuantity(), QUANTITY);
    assertEquals(test.getPrice(), PRICE);
  }

  //-------------------------------------------------------------------------
  public void test_resolve() {
    ResolvedFixedCouponBondTrade expected = ResolvedFixedCouponBondTrade.builder()
        .tradeInfo(TRADE_INFO)
        .product(PRODUCT.resolve(REF_DATA))
        .quantity(QUANTITY)
        .price(PRICE)
        .build();
    assertEquals(sut().resolve(REF_DATA), expected);
  }

  //-------------------------------------------------------------------------
  public void coverage() {
    coverImmutableBean(sut());
    coverBeanEquals(sut(), sut2());
  }

  public void test_serialization() {
    assertSerialization(sut());
  }

  //-------------------------------------------------------------------------
  static FixedCouponBondTrade sut() {
    return FixedCouponBondTrade.builder()
        .tradeInfo(TRADE_INFO)
        .product(PRODUCT)
        .quantity(QUANTITY)
        .price(PRICE)
        .build();
  }

  static FixedCouponBondTrade sut2() {
    return FixedCouponBondTrade.builder()
        .product(PRODUCT2)
        .quantity(100L)
        .price(PRICE2)
        .build();
  }

}
