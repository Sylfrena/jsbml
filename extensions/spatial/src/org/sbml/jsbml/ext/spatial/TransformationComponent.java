/*
 * $Id$
 * $URL$
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 * 
 * Copyright (C) 2009-2014  jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 * 4. The University of California, San Diego, La Jolla, CA, USA
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */
package org.sbml.jsbml.ext.spatial;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

import org.sbml.jsbml.AbstractSBase;
import org.sbml.jsbml.PropertyUndefinedError;
import org.sbml.jsbml.util.StringTools;
import org.sbml.jsbml.util.TreeNodeChangeEvent;


/**
 * @author Alex Thomas
 * @version $Rev$
 * @since 1.0
 * @date Jan 20, 2014
 */
public class TransformationComponent extends AbstractSBase {

  /**
   * 
   */
  private static final long serialVersionUID = -2905551100912455549L;

  private Double[] components;
  private Integer componentsLength;

  public TransformationComponent() {
    super();
  }


  /**
   * @param node
   */
  public TransformationComponent(TransformationComponent tc) {
    super(tc);

    if (tc.isSetComponents()) {
      components = tc.getComponents().clone();
      componentsLength = components.length;
    }

  }


  /**
   * @param level
   * @param version
   */
  public TransformationComponent(int level, int version) {
    super(level, version);
  }


  @Override
  public TransformationComponent clone() {
    return new TransformationComponent(this);
  }


  @Override
  public boolean equals(Object object) {
    boolean equal = super.equals(object);
    if (equal) {
      TransformationComponent tc = (TransformationComponent) object;
      equal &= tc.isSetComponents() == isSetComponents();
      if (equal && isSetComponents()) {
        equal &= tc.getComponents().equals(getComponents());
      }
    }
    return equal;
  }


  /**
   * Returns the value of components
   *
   * @return the value of components
   */
  public Double[] getComponents() {
    if (isSetComponents()) {
      return components;
    }
    // This is necessary if we cannot return null here.
    throw new PropertyUndefinedError(SpatialConstants.components, this);
  }


  /**
   * Returns whether components is set
   *
   * @return whether components is set
   */
  public boolean isSetComponents() {
    return components != null;
  }


  /**
   * Sets the value of components
   */
  public void setComponents(Double[] components) {
    Double[] oldComponents = this.components;
    this.components = components;
    componentsLength = components.length;
    firePropertyChange(SpatialConstants.components, oldComponents, this.components);
    firePropertyChange(SpatialConstants.componentsLength, oldComponents.length, componentsLength);
  }


  /**
   * Unsets the variable components
   *
   * @return {@code true}, if components was set before,
   *         otherwise {@code false}
   */
  public boolean unsetComponents() {
    if (isSetComponents()) {
      Double[] oldComponents = components;
      components = null;
      componentsLength = null;
      firePropertyChange(SpatialConstants.components, oldComponents, components);
      firePropertyChange(SpatialConstants.componentsLength, oldComponents.length, componentsLength);
      return true;
    }
    return false;
  }


  /**
   * Returns the value of componentsLength
   *
   * @return the value of componentsLength
   */
  public int getComponentsLength() {
    if (isSetComponentsLength()) {
      return componentsLength;
    }
    // This is necessary if we cannot return null here.
    throw new PropertyUndefinedError(SpatialConstants.componentsLength, this);
  }


  /**
   * Returns whether componentsLength is set
   *
   * @return whether componentsLength is set
   */
  public boolean isSetComponentsLength() {
    return componentsLength != null;
  }

  @Override
  public int hashCode() {
    final int prime = 983;//Change this prime number
    int hashCode = super.hashCode();
    if (isSetComponents()) {
      hashCode += prime * getComponents().hashCode();
    }
    return hashCode;
  }


  @Override
  public Map<String, String> writeXMLAttributes() {
    Map<String, String> attributes = super.writeXMLAttributes();
    if (isSetComponents()) {
      attributes.remove("components");
      attributes.put(SpatialConstants.shortLabel + ":components", Arrays.toString(getComponents()));
    }

    if (isSetComponentsLength()) {
      attributes.remove("componentsLength");
      attributes.put(SpatialConstants.shortLabel + ":componentsLength",
        String.valueOf(getComponentsLength()));
    }

    if (isSetSBOTerm()) {
      attributes.remove(TreeNodeChangeEvent.sboTerm);
      attributes.put(SpatialConstants.shortLabel + ":" + TreeNodeChangeEvent.sboTerm, getSBOTermID());
    }
    if (isSetMetaId()) {
      attributes.remove(TreeNodeChangeEvent.metaId);
      attributes.put(SpatialConstants.shortLabel + ":" + TreeNodeChangeEvent.metaId, getMetaId());
    }
    return attributes;
  }


  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = (super.readAttribute(attributeName, prefix, value))
        && (SpatialConstants.shortLabel == prefix);
    if (!isAttributeRead) {
      isAttributeRead = true;
      if (attributeName.equals(SpatialConstants.components)) {
        StringTokenizer test = new StringTokenizer(value);
        Double[] componentsTemp = new Double[test.countTokens()];
        int i = 0;
        while(test.hasMoreTokens()) {
          try {
            componentsTemp[i] = StringTools.parseSBMLDouble(test.nextToken());
            i++;
          } catch (Exception e) {
            MessageFormat.format(
              SpatialConstants.bundle.getString("COULD_NOT_READ"), value,
              SpatialConstants.components);
          }
        }
        if (componentsTemp.length > 0) {
          unsetComponents();
          setComponents(componentsTemp);
        }
      }
      else {
        isAttributeRead = false;
      }
    }
    return isAttributeRead;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("TransformationComponent [components=");
    builder.append(Arrays.toString(components));
    builder.append(", componentsLength=");
    builder.append(componentsLength);
    builder.append("]");
    return builder.toString();
  }


}