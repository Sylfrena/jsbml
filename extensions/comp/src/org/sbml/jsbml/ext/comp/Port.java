/*
 * $Id$
 * $URL$
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2013 jointly by the following organizations:
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
package org.sbml.jsbml.ext.comp;

import org.sbml.jsbml.LevelVersionError;
import org.sbml.jsbml.UniqueNamedSBase;

/**
 * 
 * @author Nicolas Rodriguez
 * @version $Rev$
 * @since 1.0
 */
public class Port extends AbstractNamedSBaseRef implements UniqueNamedSBase {
	// TODO - Port have their own namespace of ids so we have to treat them separately. 
	// We will do that once the new methods and interface to deal with registration of ids are in place.
	
	/**
	 * Generated serial version identifier.
	 */
	private static final long serialVersionUID = -301236222127386488L;

	/**
	 * Creates an Port instance 
	 */
	public Port() {
		super();
		initDefaults();
	}

	/**
	 * Creates a Port instance with an id. 
	 * 
	 * @param id
	 */
	public Port(String id) {
		super(id);
		initDefaults();
	}

	/**
	 * Creates a Port instance with a level and version. 
	 * 
	 * @param level
	 * @param version
	 */
	public Port(int level, int version) {
		this(null, null, level, version);
	}

	/**
	 * Creates a Port instance with an id, level, and version. 
	 * 
	 * @param id
	 * @param level
	 * @param version
	 */
	public Port(String id, int level, int version) {
		this(id, null, level, version);
	}

	/**
	 * Creates a Port instance with an id, name, level, and version. 
	 * 
	 * @param id
	 * @param name
	 * @param level
	 * @param version
	 */
	public Port(String id, String name, int level, int version) {
		super(id, name, level, version);
		if (getLevelAndVersion().compareTo(
				Integer.valueOf(CompConstant.MIN_SBML_LEVEL),
				Integer.valueOf(CompConstant.MIN_SBML_VERSION)) < 0) {
			throw new LevelVersionError(getElementName(), level, version);
		}
		initDefaults();
	}

	/**
	 * Clone constructor
	 */
	public Port(Port obj) {
		super(obj);
	}

	/**
	 * Initializes the default values using the namespace.
	 */
	public void initDefaults() {
		addNamespace(CompConstant.namespaceURI);
	}


	public boolean isIdMandatory() {
		return true;
	}

	/**
	 * clones this class
	 */
	public Port clone() {
		return new Port(this);
	}

}