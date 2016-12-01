/*
 *
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 * 
 * Copyright (C) 2009-2016 jointly by the following organizations:
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
package org.sbml.jsbml.xml.parsers;

import java.util.List;

import org.apache.log4j.Logger;
import org.mangosdk.spi.ProviderFor;
import org.sbml.jsbml.ASTNode;
import org.sbml.jsbml.ListOf;
import org.sbml.jsbml.SBase;
import org.sbml.jsbml.ext.ASTNodePlugin;
import org.sbml.jsbml.ext.SBasePlugin;
import org.sbml.jsbml.ext.layout.BoundingBox;
import org.sbml.jsbml.ext.layout.Layout;
import org.sbml.jsbml.ext.layout.LayoutConstants;
import org.sbml.jsbml.ext.layout.LayoutModelPlugin;
import org.sbml.jsbml.ext.render.ColorDefinition;
import org.sbml.jsbml.ext.render.RenderCurve;
import org.sbml.jsbml.ext.render.GlobalRenderInformation;
import org.sbml.jsbml.ext.render.GradientBase;
import org.sbml.jsbml.ext.render.GradientStop;
import org.sbml.jsbml.ext.render.RenderGroup;
import org.sbml.jsbml.ext.render.LineEnding;
import org.sbml.jsbml.ext.render.LocalRenderInformation;
import org.sbml.jsbml.ext.render.LocalStyle;
import org.sbml.jsbml.ext.render.Polygon;
import org.sbml.jsbml.ext.render.RenderConstants;
import org.sbml.jsbml.ext.render.RenderInformationBase;
import org.sbml.jsbml.ext.render.RenderLayoutPlugin;
import org.sbml.jsbml.ext.render.RenderListOfLayoutsPlugin;
import org.sbml.jsbml.ext.render.RenderPoint;
import org.sbml.jsbml.ext.render.Style;

/**
 * @author Alexander Diamantikos
 * @author Jakob Matthes
 * @author Eugen Netz
 * @author Jan Rudolph
 * @since 1.0
 */
@ProviderFor(ReadingParser.class)
public class RenderParser extends AbstractReaderWriter  implements PackageParser {

  /**
   * The logger for this RenderParser
   */
  private static final transient Logger logger = Logger.getLogger(RenderParser.class);

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getShortLabel()
   */
  @Override
  public String getShortLabel() {
    return RenderConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getNamespaceURI() {
    return RenderConstants.namespaceURI;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#processStartElement(java.lang.String, java.lang.String, boolean, boolean, java.lang.Object)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Object processStartElement(String elementName, String uri, String prefix,
    boolean hasAttributes, boolean hasNamespaces, Object contextObject) 
  {
    logger.debug("logger called, " + prefix + ":" + elementName + " in context of: " + contextObject.toString());
    
    if (contextObject instanceof LayoutModelPlugin) {
      LayoutModelPlugin layoutModel = (LayoutModelPlugin) contextObject;
      
      // TODO not sure if necessary to check if listOfLayouts != null
      ListOf<Layout> listOfLayouts = layoutModel.getListOfLayouts();
      SBase newElement = null;

      if (elementName.equals(RenderConstants.listOfGlobalRenderInformation)) {
        RenderListOfLayoutsPlugin renderPlugin = new RenderListOfLayoutsPlugin(listOfLayouts);
        listOfLayouts.addExtension(RenderConstants.namespaceURI, renderPlugin);
        newElement = renderPlugin.getListOfGlobalRenderInformation();
      }

      if (newElement != null) {
        return newElement;
      }
    }
    else if (contextObject instanceof Layout) {
      Layout layout = (Layout) contextObject;
      SBase newElement = null;

      // JSBML used "listOfLocalRenderInformation" for a few years so we are keeping the test using "listOfLocalRenderInformation"
      // here to be able to read any incorrect files with JSBML
      if (elementName.equals(RenderConstants.listOfLocalRenderInformation) || 
          elementName.equals("listOfLocalRenderInformation"))
      {
        RenderLayoutPlugin renderPlugin = new RenderLayoutPlugin(layout);
        layout.addExtension(RenderConstants.namespaceURI, renderPlugin);
        newElement = renderPlugin.getListOfLocalRenderInformation();
      }
      if (newElement != null) {
        return newElement;
      }
    }
    else if (contextObject instanceof RenderInformationBase) {
      RenderInformationBase renderInformation = (RenderInformationBase) contextObject;
      SBase newElement = null;

      if (elementName.equals(RenderConstants.listOfGradientDefinitions)) {
        newElement = renderInformation.getListOfGradientDefinitions();
      }
      if (elementName.equals(RenderConstants.listOfColorDefinitions)) {
        newElement = renderInformation.getListOfColorDefinitions();
      }
      if (elementName.equals(RenderConstants.listOfLineEndings)) {
        newElement = renderInformation.getListOfLineEndings();
      }

      if (renderInformation instanceof GlobalRenderInformation) {
        GlobalRenderInformation globalRenderInformation =
            (GlobalRenderInformation) renderInformation;
        
        if (elementName.equals(RenderConstants.listOfStyles)) {
          newElement = globalRenderInformation.getListOfStyles();
        }
      }

      if (renderInformation instanceof LocalRenderInformation) {
        LocalRenderInformation localRenderInformation =
            (LocalRenderInformation) renderInformation;
        
        // JSBML used "listOfLocalStyles" for a few years so we are keeping the test using "listOfLocalStyles"
        // here to be able to read any incorrect files with JSBML.
        if (elementName.equals(RenderConstants.listOfLocalStyles)
            || elementName.equals("listOfLocalStyles"))
        {
          newElement = localRenderInformation.getListOfLocalStyles();
        }
      }


      if (newElement != null) {
        return newElement;
      }
    }
    else if (contextObject instanceof Style) 
    {
      Style style = (Style) contextObject;
      
      if (elementName.equals(RenderConstants.group)) {
        RenderGroup g = new RenderGroup();
        style.setGroup(g);

        return g;
      }
    }

    else if (contextObject instanceof Polygon) {
      Polygon polygon = (Polygon) contextObject;
      SBase newElement = null;
      
      if (elementName.equals(RenderConstants.listOfElements)) {  // TODO "listOfRenderPoints" + list-of-elements
        newElement = polygon.getListOfElements();
      }
      if (newElement != null) {
        return newElement;
      }
    }

    else if (contextObject instanceof LineEnding) {
      LineEnding lineEnding = (LineEnding) contextObject;
      
      if (elementName.equals(RenderConstants.boundingBox)) {
        BoundingBox bbox = new BoundingBox();
        lineEnding.setBoundingBox(bbox);

        return bbox;
      }
      else if (elementName.equals(RenderConstants.group)) {
        RenderGroup g = new RenderGroup();
        lineEnding.setGroup(g);

        return g;
      }
    }

    else if (contextObject instanceof RenderCurve) {
      RenderCurve curve = (RenderCurve) contextObject;
      SBase newElement = null;

      // JSBML used "list-of-elements" for a few years so we are keeping the test using "list-of-elements"
      // here to be able to read any incorrect files with JSBML.
      if (elementName.equals(RenderConstants.listOfElements)
          || elementName.equals(RenderConstants.list_of_elements)) // TODO - listOfRenderPoints as well ?
      {
        newElement = curve.getListOfElements();
      }

      if (newElement != null) {
        return newElement;
      }
    }

    else if (contextObject instanceof GradientBase) {
      GradientBase gradientBase = (GradientBase) contextObject;
      SBase newElement = null;

      if (elementName.equals(RenderConstants.listOfGradientStops)) {
        newElement = gradientBase.getListOfGradientStops();
      }

      if (newElement != null) {
        return newElement;
      }
    }
    /**
     * parsing lists
     */
    else if (contextObject instanceof ListOf<?>) {
      ListOf<SBase> listOf = (ListOf<SBase>) contextObject;
      SBase newElement = null;

      if (elementName.equals(RenderConstants.renderPoint)) { // TODO - old name as well
        newElement = new RenderPoint(); // TODO - RenderCubicBezier old name as well + here, it can be either RenderPoint or RenderCubicBezier depending of the xsi attribute...
      }
      else if (elementName.equals(RenderConstants.style)) { 
     // we have to check the context to know if we create a LocalStyle or a GlobalStyle (Style)
        if (listOf.getElementName().equals(RenderConstants.listOfLocalStyles)) { // TODO - we need to check the parent of the listOf !
          newElement = new LocalStyle();
        } else {
          newElement = new Style();
        }
      }
      // JSBML used "localStyle" for a few years so we are keeping the test using "localStyle"
      // here to be able to read any incorrect files with JSBML.
      else if (elementName.equals("localStyle")) {
        newElement = new LocalStyle();
      }
      else if (elementName.equals(RenderConstants.gradientStop)) {
        newElement = new GradientStop();
      }
      else if (elementName.equals(RenderConstants.colorDefiniton)) {
        newElement = new ColorDefinition();
      }
      else if (elementName.equals(RenderConstants.gradientBase)) {
        newElement = new GradientBase();
      }
      else if (elementName.equals(RenderConstants.lineEnding)) {
        newElement = new LineEnding();
      }
      else if (elementName.equals(RenderConstants.renderInformation)) 
      {
        // we have to check the context to know if we create a Local or a Global element
        if (listOf.getElementName().equals(RenderConstants.listOfLocalRenderInformation)) {
          newElement = new LocalRenderInformation();
        } else {
          newElement = new GlobalRenderInformation();
        }
      }
      // JSBML used "localRenderInformation" for a few years so we are keeping the test using "localRenderInformation"
      // here to be able to read any incorrect files with JSBML.
      else if (elementName.equals("localRenderInformation")) 
      {
        newElement = new LocalRenderInformation();
      }
      // JSBML used "globalRenderInformation" for a few years so we are keeping the test using "globalRenderInformation"
      // here to be able to read any incorrect files with JSBML.
      else if (elementName.equals("globalRenderInformation")) 
      {
        newElement = new GlobalRenderInformation();
      }


      if (newElement != null) {
        // listOf.registerChild(newElement); // registerChild is called when adding the element to the list
        listOf.add(newElement);
      }

      return newElement;
    }
    return contextObject;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#getNamespaces()
   */
  @Override
  public List<String> getNamespaces() {
    return RenderConstants.namespaces_L3;
  }

  @SuppressWarnings("unchecked")
  @Override
  public SBasePlugin createPluginFor(SBase sbase) {

    if (sbase != null) {
      if (sbase instanceof Layout) {
        return new RenderLayoutPlugin((Layout) sbase);
      } else if (sbase instanceof ListOf<?>) {
        if (sbase.getElementName().equals(LayoutConstants.listOfLayouts)) {
          return new RenderListOfLayoutsPlugin((ListOf<Layout>) sbase);
        }
      }
      // TODO - libsbml seems to have a Plugin for GraphicalObject as well RenderGraphicalObjectPlugin !!
    }

    return null;
  }

  @Override
  public String getNamespaceFor(int level, int version, int packageVersion) {

    if (level == 3 && version == 1 && packageVersion == 1) {
      return RenderConstants.namespaceURI_L3V1V1;
    }

    return null;
  }

  @Override
  public List<String> getPackageNamespaces() {
    return RenderConstants.namespaces_L3;
  }

  @Override
  public String getPackageName() {
    return getShortLabel();
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public ASTNodePlugin createPluginFor(ASTNode astNode) {
    // This package does not extends ASTNode
    return null;
  }

}
