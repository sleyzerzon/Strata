/**
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.index;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableDefaults;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.market.ReferenceData;
import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.product.ResolvedTrade;
import com.opengamma.strata.product.TradeInfo;

/**
 * A trade in an option on a futures contract based on an Ibor index, resolved for pricing.
 * <p>
 * This is the resolved form of {@link IborFutureOptionTrade} and is the primary input to the pricers.
 * Applications will typically create a {@code ResolvedIborFutureOptionTrade} from a {@code IborFutureOptionTrade}
 * using {@link IborFutureOptionTrade#resolve(ReferenceData)}.
 * <p>
 * A {@code ResolvedIborFutureOptionTrade} is bound to data that changes over time, such as holiday calendars.
 * If the data changes, such as the addition of a new holiday, the resolved form will not be updated.
 * Care must be taken when placing the resolved form in a cache or persistence layer.
 */
@BeanDefinition(constructorScope = "package")
public final class ResolvedIborFutureOptionTrade
    implements ResolvedTrade, ImmutableBean, Serializable {

  /**
   * The additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   */
  @PropertyDefinition(overrideGet = true)
  private final TradeInfo tradeInfo;
  /**
   * The option that was traded.
   * <p>
   * The product captures the contracted financial details of the trade.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final ResolvedIborFutureOption product;
  /**
   * The quantity that was traded.
   * <p>
   * This is the number of contracts that were traded.
   * This will be positive if buying and negative if selling.
   */
  @PropertyDefinition
  private final long quantity;
  /**
   * The price that was traded, in decimal form.
   * <p>
   * This is the price agreed when the trade occurred.
   */
  @PropertyDefinition(validate = "ArgChecker.notNegative")
  private final double price;

  //-------------------------------------------------------------------------
  @ImmutableDefaults
  private static void applyDefaults(Builder builder) {
    builder.tradeInfo = TradeInfo.EMPTY;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ResolvedIborFutureOptionTrade}.
   * @return the meta-bean, not null
   */
  public static ResolvedIborFutureOptionTrade.Meta meta() {
    return ResolvedIborFutureOptionTrade.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ResolvedIborFutureOptionTrade.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ResolvedIborFutureOptionTrade.Builder builder() {
    return new ResolvedIborFutureOptionTrade.Builder();
  }

  /**
   * Creates an instance.
   * @param tradeInfo  the value of the property
   * @param product  the value of the property, not null
   * @param quantity  the value of the property
   * @param price  the value of the property
   */
  ResolvedIborFutureOptionTrade(
      TradeInfo tradeInfo,
      ResolvedIborFutureOption product,
      long quantity,
      double price) {
    JodaBeanUtils.notNull(product, "product");
    ArgChecker.notNegative(price, "price");
    this.tradeInfo = tradeInfo;
    this.product = product;
    this.quantity = quantity;
    this.price = price;
  }

  @Override
  public ResolvedIborFutureOptionTrade.Meta metaBean() {
    return ResolvedIborFutureOptionTrade.Meta.INSTANCE;
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
   * Gets the additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   * @return the value of the property
   */
  @Override
  public TradeInfo getTradeInfo() {
    return tradeInfo;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the option that was traded.
   * <p>
   * The product captures the contracted financial details of the trade.
   * @return the value of the property, not null
   */
  @Override
  public ResolvedIborFutureOption getProduct() {
    return product;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the quantity that was traded.
   * <p>
   * This is the number of contracts that were traded.
   * This will be positive if buying and negative if selling.
   * @return the value of the property
   */
  public long getQuantity() {
    return quantity;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the price that was traded, in decimal form.
   * <p>
   * This is the price agreed when the trade occurred.
   * @return the value of the property
   */
  public double getPrice() {
    return price;
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
      ResolvedIborFutureOptionTrade other = (ResolvedIborFutureOptionTrade) obj;
      return JodaBeanUtils.equal(tradeInfo, other.tradeInfo) &&
          JodaBeanUtils.equal(product, other.product) &&
          (quantity == other.quantity) &&
          JodaBeanUtils.equal(price, other.price);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(tradeInfo);
    hash = hash * 31 + JodaBeanUtils.hashCode(product);
    hash = hash * 31 + JodaBeanUtils.hashCode(quantity);
    hash = hash * 31 + JodaBeanUtils.hashCode(price);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("ResolvedIborFutureOptionTrade{");
    buf.append("tradeInfo").append('=').append(tradeInfo).append(',').append(' ');
    buf.append("product").append('=').append(product).append(',').append(' ');
    buf.append("quantity").append('=').append(quantity).append(',').append(' ');
    buf.append("price").append('=').append(JodaBeanUtils.toString(price));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ResolvedIborFutureOptionTrade}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code tradeInfo} property.
     */
    private final MetaProperty<TradeInfo> tradeInfo = DirectMetaProperty.ofImmutable(
        this, "tradeInfo", ResolvedIborFutureOptionTrade.class, TradeInfo.class);
    /**
     * The meta-property for the {@code product} property.
     */
    private final MetaProperty<ResolvedIborFutureOption> product = DirectMetaProperty.ofImmutable(
        this, "product", ResolvedIborFutureOptionTrade.class, ResolvedIborFutureOption.class);
    /**
     * The meta-property for the {@code quantity} property.
     */
    private final MetaProperty<Long> quantity = DirectMetaProperty.ofImmutable(
        this, "quantity", ResolvedIborFutureOptionTrade.class, Long.TYPE);
    /**
     * The meta-property for the {@code price} property.
     */
    private final MetaProperty<Double> price = DirectMetaProperty.ofImmutable(
        this, "price", ResolvedIborFutureOptionTrade.class, Double.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "tradeInfo",
        "product",
        "quantity",
        "price");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 752580658:  // tradeInfo
          return tradeInfo;
        case -309474065:  // product
          return product;
        case -1285004149:  // quantity
          return quantity;
        case 106934601:  // price
          return price;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ResolvedIborFutureOptionTrade.Builder builder() {
      return new ResolvedIborFutureOptionTrade.Builder();
    }

    @Override
    public Class<? extends ResolvedIborFutureOptionTrade> beanType() {
      return ResolvedIborFutureOptionTrade.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code tradeInfo} property.
     * @return the meta-property, not null
     */
    public MetaProperty<TradeInfo> tradeInfo() {
      return tradeInfo;
    }

    /**
     * The meta-property for the {@code product} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ResolvedIborFutureOption> product() {
      return product;
    }

    /**
     * The meta-property for the {@code quantity} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Long> quantity() {
      return quantity;
    }

    /**
     * The meta-property for the {@code price} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> price() {
      return price;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 752580658:  // tradeInfo
          return ((ResolvedIborFutureOptionTrade) bean).getTradeInfo();
        case -309474065:  // product
          return ((ResolvedIborFutureOptionTrade) bean).getProduct();
        case -1285004149:  // quantity
          return ((ResolvedIborFutureOptionTrade) bean).getQuantity();
        case 106934601:  // price
          return ((ResolvedIborFutureOptionTrade) bean).getPrice();
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
   * The bean-builder for {@code ResolvedIborFutureOptionTrade}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<ResolvedIborFutureOptionTrade> {

    private TradeInfo tradeInfo;
    private ResolvedIborFutureOption product;
    private long quantity;
    private double price;

    /**
     * Restricted constructor.
     */
    private Builder() {
      applyDefaults(this);
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(ResolvedIborFutureOptionTrade beanToCopy) {
      this.tradeInfo = beanToCopy.getTradeInfo();
      this.product = beanToCopy.getProduct();
      this.quantity = beanToCopy.getQuantity();
      this.price = beanToCopy.getPrice();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 752580658:  // tradeInfo
          return tradeInfo;
        case -309474065:  // product
          return product;
        case -1285004149:  // quantity
          return quantity;
        case 106934601:  // price
          return price;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 752580658:  // tradeInfo
          this.tradeInfo = (TradeInfo) newValue;
          break;
        case -309474065:  // product
          this.product = (ResolvedIborFutureOption) newValue;
          break;
        case -1285004149:  // quantity
          this.quantity = (Long) newValue;
          break;
        case 106934601:  // price
          this.price = (Double) newValue;
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
    public ResolvedIborFutureOptionTrade build() {
      return new ResolvedIborFutureOptionTrade(
          tradeInfo,
          product,
          quantity,
          price);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the additional trade information, defaulted to an empty instance.
     * <p>
     * This allows additional information to be attached to the trade.
     * @param tradeInfo  the new value
     * @return this, for chaining, not null
     */
    public Builder tradeInfo(TradeInfo tradeInfo) {
      this.tradeInfo = tradeInfo;
      return this;
    }

    /**
     * Sets the option that was traded.
     * <p>
     * The product captures the contracted financial details of the trade.
     * @param product  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder product(ResolvedIborFutureOption product) {
      JodaBeanUtils.notNull(product, "product");
      this.product = product;
      return this;
    }

    /**
     * Sets the quantity that was traded.
     * <p>
     * This is the number of contracts that were traded.
     * This will be positive if buying and negative if selling.
     * @param quantity  the new value
     * @return this, for chaining, not null
     */
    public Builder quantity(long quantity) {
      this.quantity = quantity;
      return this;
    }

    /**
     * Sets the price that was traded, in decimal form.
     * <p>
     * This is the price agreed when the trade occurred.
     * @param price  the new value
     * @return this, for chaining, not null
     */
    public Builder price(double price) {
      ArgChecker.notNegative(price, "price");
      this.price = price;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("ResolvedIborFutureOptionTrade.Builder{");
      buf.append("tradeInfo").append('=').append(JodaBeanUtils.toString(tradeInfo)).append(',').append(' ');
      buf.append("product").append('=').append(JodaBeanUtils.toString(product)).append(',').append(' ');
      buf.append("quantity").append('=').append(JodaBeanUtils.toString(quantity)).append(',').append(' ');
      buf.append("price").append('=').append(JodaBeanUtils.toString(price));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
