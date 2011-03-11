/*
 * $Id$
 * $URL$
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2011 jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */

package org.sbml.jsbml.ext.layout;

import org.sbml.jsbml.AbstractNamedSBase;

/**
 * @author
 * @since 0.8
 * @version $Rev$
 */
public class TextGlyph extends AbstractNamedSBase {

	/**
	 * Generated serial version identifier.
	 */
	private static final long serialVersionUID = -2582985174711830815L;
	/**
	 * 
	 */
	private GraphicalObject graphicalObject;
	/**
	 * 
	 */
	private String text;
	/**
	 * 
	 */
	private String originOfText;

	/**
	 * 
	 */
	public TextGlyph() {
		super();
	}
	
	public TextGlyph(String id) {
		super(id);
	}

	/**
	 * 
	 * @param level
	 * @param version
	 */
	public TextGlyph(int level, int version) {
		super(level, version);
	}

	/**
	 * 
	 * @param textGlyph
	 */
	public TextGlyph(TextGlyph textGlyph) {
		super(textGlyph);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.AbstractSBase#clone()
	 */
	@Override
	public TextGlyph clone() {
		return new TextGlyph(this);
	}

	/**
	 * 
	 * @return
	 */
	public GraphicalObject getGraphicalObject() {
		return graphicalObject;
	}

	/**
	 * 
	 * @return
	 */
	public String getOriginOfText() {
		return originOfText;
	}

	/**
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param graphicalObject
	 */
	public void setGraphicalObject(GraphicalObject graphicalObject) {
		this.graphicalObject = graphicalObject;
	}

	/**
	 * 
	 * @param originOfText
	 */
	public void setOriginOfText(String originOfText) {
		this.originOfText = originOfText;
	}

	/**
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
