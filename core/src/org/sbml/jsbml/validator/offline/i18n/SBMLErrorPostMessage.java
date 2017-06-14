/*
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2017 jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 * 4. The University of California, San Diego, La Jolla, CA, USA
 * 5. The Babraham Institute, Cambridge, UK
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */
package org.sbml.jsbml.validator.offline.i18n;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.sbml.jsbml.SBMLError;
import org.sbml.jsbml.validator.offline.factory.SBMLErrorCodes;

/**
 * Contains the post messages for each {@link SBMLError} in the English language.
 * 
 * <p>'post' mean that this is added at the end of the generic error message defined in the {@link SBMLErrorMessage} bundle.
 * This part of the error has, in general, several parameters to be able to customize the message to provide some information
 * about which element contained the error and why the error was raised.</p>
 * 
 * <p>The key for each post message is the integer defined for each {@link SBMLError} in {@link SBMLErrorCodes}.</p>
 * 
 * @see ResourceBundle
 * @author rodrigue
 * @since 1.3
 */
public class SBMLErrorPostMessage extends ResourceBundle {  


  
  /**
   * 
   */
  private static final Map<String, String> contents = new HashMap<String, String>();
  
  static {
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_10214), "The formula ''{0}'' in the math element of the <{1}> uses ''{2}'' which is not a function definition id.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20501), "The <compartment> with id ''{0}'' should not have a ''size'' attribute OR should have a ''spatialDimensions'' attribute that is not set to ''0''.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20502), "The <compartment> with id ''{0}'' should not have a ''units'' attribute OR should have a ''spatialDimensions'' attribute that is not set to ''0''.");
          
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20503), "The <compartment> with id ''{0}'' should have a ''constant'' attribute set to ''true'' OR should have a ''spatialDimensions'' attribute that is not set to ''0''.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20504), "The <compartment> with id ''{0}'' sets the ''outside'' attribute to ''{1}'' which does not exist as a <compartment>.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20505), "Compartment ''{0}'' encloses itself."); // TODO - Several messages depending the error
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20506), "The <compartment> with id ''{0}'' refers to the ''outside'' <compartment> ''{1}'' which does not have ''spatialDimensions'' of ''0''.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20507), "The value of the 'units' attribute on a <compartment> having 'spatialDimensions' of '1' must be either 'length', 'metre', 'dimensionless', or the identifier of a <unitDefinition> based on either 'metre' (with 'exponent' equal to '1') or 'dimensionless'. The <compartment> with id ''{0}'' does not comply.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20508), "The value of the 'units' attribute on a <compartment> having 'spatialDimensions' of '2' must be either 'area', 'dimensionless', or the identifier of a <unitDefinition> based on either 'metre' (with 'exponent' equal to '2') or 'dimensionless'. The <compartment> with id ''{0}'' does not comply.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20509), "The value of the 'units' attribute on a <compartment> having 'spatialDimensions' of '3' must be either 'volume', 'litre', or the identifier of a <unitDefinition> based on either 'litre', 'metre' (with 'exponent' equal to '3'). The <compartment> with id ''{0}'' does not comply.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20510), "The <compartment> with id ''{0}'' refers to the compartmentType ''{1}'' which is not defined. ");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20511), "The <compartment> with id ''{0}'' has undefined units.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20512), "The <compartment> with id ''{0}'' has undefined units.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20513), "The <compartment> with id ''{0}'' has undefined units.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20517), "The <compartment> with id ''{0}'' does not comply."); // TODO - Several messages depending the error
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20518), "The <compartment> ''{0}'' has no discernable units.");
      
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_20903), "The {0} with id ''{1}'' should have a constant value of ''false''.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_80501), "The <compartment> with the id ''{0}'' does not have a ''size'' attribute, nor is its initial value set by an <initialAssignment> or <assignmentRule>.");
      
      contents.put(Integer.toString(SBMLErrorCodes.CORE_80601), "The <species> with the id ''{0}'' does not have an ''initialConcentration'' or ''initialAmount'' attribute, nor is its initial value set by an <initialAssignment> or <assignmentRule>.");
      
  }

  @Override
  protected Object handleGetObject(String key) {

    return contents.get(key);
  }

  @Override
  public Enumeration<String> getKeys() {
    
    return java.util.Collections.enumeration(contents.keySet());
  }

}
