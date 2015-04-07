/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.pricer.impl.rate.swap;

import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.currency.CurrencyAmount;
import com.opengamma.strata.basics.currency.MultiCurrencyAmount;
import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.finance.rate.swap.ExpandedSwap;
import com.opengamma.strata.finance.rate.swap.SwapTrade;
import com.opengamma.strata.pricer.PricingEnvironment;
import com.opengamma.strata.pricer.rate.swap.SwapProductPricerFn;
import com.opengamma.strata.pricer.rate.swap.SwapTradePricerFn;

/**
 * Pricer implementation for swap trades.
 * <p>
 * The swap trade is priced by by expanding it.
 */
public class ExpandingSwapTradePricerFn
    implements SwapTradePricerFn {

  /**
   * Default implementation.
   */
  public static final ExpandingSwapTradePricerFn DEFAULT = new ExpandingSwapTradePricerFn(
      DefaultExpandedSwapPricerFn.DEFAULT);

  /**
   * Pricer for {@link ExpandedSwap}.
   */
  private final SwapProductPricerFn<ExpandedSwap> expandedSwapPricerFn;

  /**
   * Creates an instance.
   * 
   * @param expandedSwapPricerFn  the pricer for {@link ExpandedSwap}
   */
  public ExpandingSwapTradePricerFn(
      SwapProductPricerFn<ExpandedSwap> expandedSwapPricerFn) {
    this.expandedSwapPricerFn = ArgChecker.notNull(expandedSwapPricerFn, "expandedSwapPricerFn");
  }

  //-------------------------------------------------------------------------
  @Override
  public CurrencyAmount presentValue(PricingEnvironment env, SwapTrade trade, Currency currency) {
    return expandedSwapPricerFn.presentValue(env, trade.getProduct().expand(), currency);
  }

  @Override
  public MultiCurrencyAmount presentValue(PricingEnvironment env, SwapTrade trade) {
    return expandedSwapPricerFn.presentValue(env, trade.getProduct().expand());
  }

  @Override
  public MultiCurrencyAmount futureValue(PricingEnvironment env, SwapTrade trade) {
    return expandedSwapPricerFn.futureValue(env, trade.getProduct().expand());
  }

}