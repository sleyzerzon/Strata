/*
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.curve;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.index.Index;
import com.opengamma.strata.collect.Messages;

/**
 * A single entry in the curve group definition.
 * <p>
 * Each entry stores the definition of a single curve and how it is to be used.
 * This structure allows the curve itself to be used for multiple purposes.
 * <p>
 * The currencies are used to specify that the curve is to be used as a discount curve.
 * The indices are used to specify that the curve is to be used as a forward curve.
 */
@BeanDefinition
public final class CurveGroupEntry
    implements ImmutableBean, Serializable {

  /**
   * The curve name.
   */
  @PropertyDefinition(validate = "notNull")
  private final CurveName curveName;
  /**
   * The currencies for which the curve provides discount rates.
   * This is empty if the curve is not used for Ibor rates.
   */
  @PropertyDefinition(validate = "notNull")
  private final ImmutableSet<Currency> discountCurrencies;
  /**
   * The indices for which the curve provides forward rates.
   * This is empty if the curve is not used for forward rates.
   */
  @PropertyDefinition(validate = "notNull")
  private final ImmutableSet<Index> indices;

  //-------------------------------------------------------------------------
  /**
   * Merges the specified entry with this entry, returning a new entry.
   * <p>
   * The two entries must have the same curve name.
   * 
   * @param newEntry  the new entry
   * @return the merged entry
   */
  CurveGroupEntry merge(CurveGroupEntry newEntry) {
    if (!curveName.equals(newEntry.curveName)) {
      throw new IllegalArgumentException(
          Messages.format(
              "A CurveGroupEntry can only be merged with an entry with the same curve name. name: {}, other name: {}",
              curveName,
              newEntry.curveName));
    }
    return CurveGroupEntry.builder()
        .curveName(curveName)
        .discountCurrencies(Sets.union(discountCurrencies, newEntry.discountCurrencies))
        .indices(Sets.union(indices, newEntry.indices))
        .build();
  }

  //------------------------- AUTOGENERATED START -------------------------
  /**
   * The meta-bean for {@code CurveGroupEntry}.
   * @return the meta-bean, not null
   */
  public static CurveGroupEntry.Meta meta() {
    return CurveGroupEntry.Meta.INSTANCE;
  }

  static {
    MetaBean.register(CurveGroupEntry.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static CurveGroupEntry.Builder builder() {
    return new CurveGroupEntry.Builder();
  }

  private CurveGroupEntry(
      CurveName curveName,
      Set<Currency> discountCurrencies,
      Set<Index> indices) {
    JodaBeanUtils.notNull(curveName, "curveName");
    JodaBeanUtils.notNull(discountCurrencies, "discountCurrencies");
    JodaBeanUtils.notNull(indices, "indices");
    this.curveName = curveName;
    this.discountCurrencies = ImmutableSet.copyOf(discountCurrencies);
    this.indices = ImmutableSet.copyOf(indices);
  }

  @Override
  public CurveGroupEntry.Meta metaBean() {
    return CurveGroupEntry.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the curve name.
   * @return the value of the property, not null
   */
  public CurveName getCurveName() {
    return curveName;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currencies for which the curve provides discount rates.
   * This is empty if the curve is not used for Ibor rates.
   * @return the value of the property, not null
   */
  public ImmutableSet<Currency> getDiscountCurrencies() {
    return discountCurrencies;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the indices for which the curve provides forward rates.
   * This is empty if the curve is not used for forward rates.
   * @return the value of the property, not null
   */
  public ImmutableSet<Index> getIndices() {
    return indices;
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
      CurveGroupEntry other = (CurveGroupEntry) obj;
      return JodaBeanUtils.equal(curveName, other.curveName) &&
          JodaBeanUtils.equal(discountCurrencies, other.discountCurrencies) &&
          JodaBeanUtils.equal(indices, other.indices);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(curveName);
    hash = hash * 31 + JodaBeanUtils.hashCode(discountCurrencies);
    hash = hash * 31 + JodaBeanUtils.hashCode(indices);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("CurveGroupEntry{");
    buf.append("curveName").append('=').append(curveName).append(',').append(' ');
    buf.append("discountCurrencies").append('=').append(discountCurrencies).append(',').append(' ');
    buf.append("indices").append('=').append(JodaBeanUtils.toString(indices));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CurveGroupEntry}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code curveName} property.
     */
    private final MetaProperty<CurveName> curveName = DirectMetaProperty.ofImmutable(
        this, "curveName", CurveGroupEntry.class, CurveName.class);
    /**
     * The meta-property for the {@code discountCurrencies} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<ImmutableSet<Currency>> discountCurrencies = DirectMetaProperty.ofImmutable(
        this, "discountCurrencies", CurveGroupEntry.class, (Class) ImmutableSet.class);
    /**
     * The meta-property for the {@code indices} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<ImmutableSet<Index>> indices = DirectMetaProperty.ofImmutable(
        this, "indices", CurveGroupEntry.class, (Class) ImmutableSet.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "curveName",
        "discountCurrencies",
        "indices");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 771153946:  // curveName
          return curveName;
        case -538086256:  // discountCurrencies
          return discountCurrencies;
        case 1943391143:  // indices
          return indices;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public CurveGroupEntry.Builder builder() {
      return new CurveGroupEntry.Builder();
    }

    @Override
    public Class<? extends CurveGroupEntry> beanType() {
      return CurveGroupEntry.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code curveName} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CurveName> curveName() {
      return curveName;
    }

    /**
     * The meta-property for the {@code discountCurrencies} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ImmutableSet<Currency>> discountCurrencies() {
      return discountCurrencies;
    }

    /**
     * The meta-property for the {@code indices} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ImmutableSet<Index>> indices() {
      return indices;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 771153946:  // curveName
          return ((CurveGroupEntry) bean).getCurveName();
        case -538086256:  // discountCurrencies
          return ((CurveGroupEntry) bean).getDiscountCurrencies();
        case 1943391143:  // indices
          return ((CurveGroupEntry) bean).getIndices();
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
   * The bean-builder for {@code CurveGroupEntry}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<CurveGroupEntry> {

    private CurveName curveName;
    private Set<Currency> discountCurrencies = ImmutableSet.of();
    private Set<Index> indices = ImmutableSet.of();

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(CurveGroupEntry beanToCopy) {
      this.curveName = beanToCopy.getCurveName();
      this.discountCurrencies = beanToCopy.getDiscountCurrencies();
      this.indices = beanToCopy.getIndices();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 771153946:  // curveName
          return curveName;
        case -538086256:  // discountCurrencies
          return discountCurrencies;
        case 1943391143:  // indices
          return indices;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 771153946:  // curveName
          this.curveName = (CurveName) newValue;
          break;
        case -538086256:  // discountCurrencies
          this.discountCurrencies = (Set<Currency>) newValue;
          break;
        case 1943391143:  // indices
          this.indices = (Set<Index>) newValue;
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
    public CurveGroupEntry build() {
      return new CurveGroupEntry(
          curveName,
          discountCurrencies,
          indices);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the curve name.
     * @param curveName  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder curveName(CurveName curveName) {
      JodaBeanUtils.notNull(curveName, "curveName");
      this.curveName = curveName;
      return this;
    }

    /**
     * Sets the currencies for which the curve provides discount rates.
     * This is empty if the curve is not used for Ibor rates.
     * @param discountCurrencies  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder discountCurrencies(Set<Currency> discountCurrencies) {
      JodaBeanUtils.notNull(discountCurrencies, "discountCurrencies");
      this.discountCurrencies = discountCurrencies;
      return this;
    }

    /**
     * Sets the {@code discountCurrencies} property in the builder
     * from an array of objects.
     * @param discountCurrencies  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder discountCurrencies(Currency... discountCurrencies) {
      return discountCurrencies(ImmutableSet.copyOf(discountCurrencies));
    }

    /**
     * Sets the indices for which the curve provides forward rates.
     * This is empty if the curve is not used for forward rates.
     * @param indices  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder indices(Set<Index> indices) {
      JodaBeanUtils.notNull(indices, "indices");
      this.indices = indices;
      return this;
    }

    /**
     * Sets the {@code indices} property in the builder
     * from an array of objects.
     * @param indices  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder indices(Index... indices) {
      return indices(ImmutableSet.copyOf(indices));
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("CurveGroupEntry.Builder{");
      buf.append("curveName").append('=').append(JodaBeanUtils.toString(curveName)).append(',').append(' ');
      buf.append("discountCurrencies").append('=').append(JodaBeanUtils.toString(discountCurrencies)).append(',').append(' ');
      buf.append("indices").append('=').append(JodaBeanUtils.toString(indices));
      buf.append('}');
      return buf.toString();
    }

  }

  //-------------------------- AUTOGENERATED END --------------------------
}
