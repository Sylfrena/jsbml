/*
 * $Id: SpeciesReferenceGlyph.java 1464 2013-03-06 10:52:43Z andreas-draeger $
 * $URL: https://jsbml.svn.sourceforge.net/svnroot/jsbml/trunk/extensions/layout/src/org/sbml/jsbml/ext/layout/SpeciesReferenceGlyph.java $
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2013 jointly by the following organizations:
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

import java.text.MessageFormat;
import java.util.Map;

import javax.swing.tree.TreeNode;

/**
 * @author Nicolas Rodriguez
 * @author Sebastian Fr&ouml;lich
 * @author Andreas Dr&auml;ger
 * @since 1.0
 * @version $Rev: 1464 $
 */
public class ReferenceGlyph extends AbstractReferenceGlyph {

	/**
	 * Generated serial version identifier.
	 */
	private static final long serialVersionUID = -8810905237933499989L;

	/**
	 * 
	 */
	private Curve curve;

	/**
	 * 
	 */
	private String role;

	/**
	 * 
	 */
	private String glyph;

	/**
	 * 
	 */
	public ReferenceGlyph() {
		super();
	}

	/**
	 * 
	 * @param level
	 * @param version
	 */
	public ReferenceGlyph(int level, int version) {
		super(level, version);
	}

	/**
	 * 
	 * @param speciesReferenceGlyph
	 */
	public ReferenceGlyph(ReferenceGlyph speciesReferenceGlyph) {
		super(speciesReferenceGlyph);
		if (speciesReferenceGlyph.isSetCurve()) {
			this.curve = speciesReferenceGlyph.getCurve().clone();
		}
		if (speciesReferenceGlyph.isSetRole()) {
			this.role = speciesReferenceGlyph.getRole();
		}
		if (speciesReferenceGlyph.isSetGlyph()) {
			this.glyph = new String(speciesReferenceGlyph.getGlyph());
		}
	}

	/**
	 * 
	 * @param id
	 */
	public ReferenceGlyph(String id) {
		super(id);
	}

	/**
	 * 
	 * @param id
	 * @param level
	 * @param version
	 */
	public ReferenceGlyph(String id, int level, int version) {
		super(id, level, version);
	}

	/* (non-Javadoc)
	 * @see org.sbml.jsbml.ext.layout.GraphicalObject#clone()
	 */
	public ReferenceGlyph clone() {
		return new ReferenceGlyph(this);
	}

	/**
	 * 
	 * @return
	 */
	public Curve createCurve() {
		if (isSetCurve()) {
			unsetCurve();
		}
		setCurve(new Curve(getLevel(), getVersion()));
		return getCurve();
	}

	/* (non-Javadoc)
	 * @see org.sbml.jsbml.AbstractNamedSBase#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		boolean equals = super.equals(object);
		if (equals) {
			ReferenceGlyph s = (ReferenceGlyph) object;
			equals &= s.isSetRole() && isSetRole();
			if (equals && isSetRole()) {
				equals &= s.getRole().equals(getRole());
			}
			equals &= s.isSetGlyph() == isSetGlyph();
			if (equals && isSetGlyph()) {
				equals &= s.getGlyph().equals(getGlyph());
			}
		}
		return equals;
	}

	/* (non-Javadoc)
	 * @see org.sbml.jsbml.ext.layout.GraphicalObject#getChildAt(int)
	 */
	@Override
	public TreeNode getChildAt(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		int count = super.getChildCount(), pos = 0;
		if (index < count) {
			return super.getChildAt(index);
		} else {
			index -= count;
		}
		if (isSetCurve()) {
			if (pos == index) {
				return getCurve();
			}
			pos++;
		}

		throw new IndexOutOfBoundsException(MessageFormat.format(
				"Index {0,number,integer} >= {1,number,integer}",
				index, +((int) Math.min(pos, 0))));
	}

	/* (non-Javadoc)
	 * @see org.sbml.jsbml.ext.layout.GraphicalObject#getChildCount()
	 */
	@Override
	public int getChildCount() {
		int count = super.getChildCount();
		if (isSetCurve()) {
			count++;
		}

		return count;
	}

	/**
	 * 
	 * @return
	 */
	public Curve getCurve() {
		return curve;
	}

	/**
	 * 
	 * @return
	 */
	public String getGlyph() {
		return glyph;
	}


	/**
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/* (non-Javadoc)
	 * @see org.sbml.jsbml.AbstractNamedSBase#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 953;
		int hashCode = super.hashCode();
		if (isSetRole()) {
			hashCode += prime * getRole().hashCode();
		}
		if (isSetGlyph()) {
			hashCode += prime * getGlyph().hashCode();
		}
		return hashCode;
	}

	/**
	 * @return
	 */
	public boolean isSetCurve() {
		return curve != null;
	}

	/**
	 * @return
	 */
	public boolean isSetGlyph() {
		return glyph != null;
	}

	/**
	 * @return
	 */
	public boolean isSetRole() {
		return role != null;
	}

	
	/* (non-Javadoc)
	 * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean readAttribute(String attributeName, String prefix,
			String value) {
		boolean isAttributeRead = super.readAttribute(attributeName, prefix,
				value);

		if (!isAttributeRead) {

			isAttributeRead = true;

			if (attributeName.equals(LayoutConstants.reference))
			{				
				setReference(value);
			}
			else if (attributeName.equals(LayoutConstants.glyph))
			{
				setGlyph(value);
			}
			else if (attributeName.equals(LayoutConstants.role))
			{
					setRole(value);
			}
			else
			{
				return false;
			}
		}

		return isAttributeRead;
	}

	/**
	 * 
	 * @param curve
	 */
	public void setCurve(Curve curve) {
		Curve oldCurve = this.curve;
		this.curve = curve;
		firePropertyChange(LayoutConstants.curve, oldCurve, this.role);
		registerChild(this.curve);
	}

	/**
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		String oldRole = this.role;
		this.role = role;
		firePropertyChange(LayoutConstants.role, oldRole, this.role);
	}

	/**
	 * 
	 * @param glyph
	 */
	public void setGlyph(String glyph) {
		String oldValue = this.glyph;
		this.glyph = glyph;
		firePropertyChange(LayoutConstants.speciesGlyph, oldValue, this.glyph);
	}


	/**
	 * 
	 * @param reference
	 */
	public void setReference(String reference) {
		setReference(reference, LayoutConstants.reference);
	}

	/**
	 * 
	 * @return
	 */
	public boolean unsetCurve() {
		if (isSetCurve()) {
			Curve oldCurve = getCurve();
			this.curve = null;
			oldCurve.fireNodeRemovedEvent();
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.sbml.jsbml.ext.layout.GraphicalObject#writeXMLAttributes()
	 */
	@Override
	public Map<String, String> writeXMLAttributes() {
		Map<String, String> attributes = super.writeXMLAttributes();

		if (isSetGlyph()) {
			attributes.put(LayoutConstants.shortLabel + ':'
					+ LayoutConstants.glyph, glyph);
		}
		if (isSetReference()) {
			attributes.put(LayoutConstants.shortLabel + ':'
					+ LayoutConstants.reference, getReference());
		}
		if (isSetRole()) {
			attributes.put(LayoutConstants.shortLabel + ':'
					+ LayoutConstants.role, role);
		}

		return attributes;
	}

}