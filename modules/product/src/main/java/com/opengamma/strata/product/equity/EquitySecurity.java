/**
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.equity;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableSet;
import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.market.ReferenceData;
import com.opengamma.strata.product.ModelledSecurity;
import com.opengamma.strata.product.SecurityId;
import com.opengamma.strata.product.SecurityInfo;
import com.opengamma.strata.product.TradeInfo;

/**
 * A security representing an equity share of a company.
 * <p>
 * An equity represents the concept of a single equity share of a company.
 * For example, a single share of OpenGamma.
 */
@BeanDefinition
public final class EquitySecurity
    implements ModelledSecurity, ImmutableBean, Serializable {

  /**
   * The standard security information.
   * <p>
   * This includes the security identifier.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final SecurityInfo securityInfo;
  /**
   * The currency that the equity is traded in.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final Currency currency;

  //-------------------------------------------------------------------------
  @Override
  public ImmutableSet<SecurityId> getUnderlyingIds() {
    return ImmutableSet.of();
  }

  //-------------------------------------------------------------------------
  @Override
  public Equity createProduct(ReferenceData refData) {
    return new Equity(getSecurityId(), currency);
  }

  @Override
  public EquityTrade createTrade(TradeInfo tradeInfo, long quantity, double tradePrice, ReferenceData refData) {
    return new EquityTrade(tradeInfo, createProduct(refData), quantity, tradePrice);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code EquitySecurity}.
   * @return the meta-bean, not null
   */
  public static EquitySecurity.Meta meta() {
    return EquitySecurity.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(EquitySecurity.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static EquitySecurity.Builder builder() {
    return new EquitySecurity.Builder();
  }

  private EquitySecurity(
      SecurityInfo securityInfo,
      Currency currency) {
    JodaBeanUtils.notNull(securityInfo, "securityInfo");
    JodaBeanUtils.notNull(currency, "currency");
    this.securityInfo = securityInfo;
    this.currency = currency;
  }

  @Override
  public EquitySecurity.Meta metaBean() {
    return EquitySecurity.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the standard security information.
   * <p>
   * This includes the security identifier.
   * @return the value of the property, not null
   */
  @Override
  public SecurityInfo getSecurityInfo() {
    return securityInfo;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency that the equity is traded in.
   * @return the value of the property, not null
   */
  @Override
  public Currency getCurrency() {
    return currency;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      EquitySecurity other = (EquitySecurity) obj;
      return JodaBeanUtils.equal(securityInfo, other.securityInfo) &&
          JodaBeanUtils.equal(currency, other.currency);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(securityInfo);
    hash = hash * 31 + JodaBeanUtils.hashCode(currency);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("EquitySecurity{");
    buf.append("securityInfo").append('=').append(securityInfo).append(',').append(' ');
    buf.append("currency").append('=').append(JodaBeanUtils.toString(currency));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code EquitySecurity}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code securityInfo} property.
     */
    private final MetaProperty<SecurityInfo> securityInfo = DirectMetaProperty.ofImmutable(
        this, "securityInfo", EquitySecurity.class, SecurityInfo.class);
    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<Currency> currency = DirectMetaProperty.ofImmutable(
        this, "currency", EquitySecurity.class, Currency.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "securityInfo",
        "currency");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 807907342:  // securityInfo
          return securityInfo;
        case 575402001:  // currency
          return currency;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public EquitySecurity.Builder builder() {
      return new EquitySecurity.Builder();
    }

    @Override
    public Class<? extends EquitySecurity> beanType() {
      return EquitySecurity.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code securityInfo} property.
     * @return the meta-property, not null
     */
    public MetaProperty<SecurityInfo> securityInfo() {
      return securityInfo;
    }

    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Currency> currency() {
      return currency;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 807907342:  // securityInfo
          return ((EquitySecurity) bean).getSecurityInfo();
        case 575402001:  // currency
          return ((EquitySecurity) bean).getCurrency();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code EquitySecurity}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<EquitySecurity> {

    private SecurityInfo securityInfo;
    private Currency currency;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(EquitySecurity beanToCopy) {
      this.securityInfo = beanToCopy.getSecurityInfo();
      this.currency = beanToCopy.getCurrency();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 807907342:  // securityInfo
          return securityInfo;
        case 575402001:  // currency
          return currency;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 807907342:  // securityInfo
          this.securityInfo = (SecurityInfo) newValue;
          break;
        case 575402001:  // currency
          this.currency = (Currency) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public EquitySecurity build() {
      return new EquitySecurity(
          securityInfo,
          currency);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the standard security information.
     * <p>
     * This includes the security identifier.
     * @param securityInfo  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder securityInfo(SecurityInfo securityInfo) {
      JodaBeanUtils.notNull(securityInfo, "securityInfo");
      this.securityInfo = securityInfo;
      return this;
    }

    /**
     * Sets the currency that the equity is traded in.
     * @param currency  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder currency(Currency currency) {
      JodaBeanUtils.notNull(currency, "currency");
      this.currency = currency;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("EquitySecurity.Builder{");
      buf.append("securityInfo").append('=').append(JodaBeanUtils.toString(securityInfo)).append(',').append(' ');
      buf.append("currency").append('=').append(JodaBeanUtils.toString(currency));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
