/*
 * $Id: GroupModel.java 834 2011-10-24 13:10:20Z niko-rodrigue $
 * $URL: https://jsbml.svn.sourceforge.net/svnroot/jsbml/trunk/extensions/groups/src/org/sbml/jsbml/ext/groups/GroupModel.java $
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
package org.sbml.jsbml.ext.groups;

import java.util.Map;

import javax.swing.tree.TreeNode;

import org.sbml.jsbml.ListOf;
import org.sbml.jsbml.Model;
import org.sbml.jsbml.ext.AbstractSBasePlugin;
import org.sbml.jsbml.util.TreeNodeChangeListener;

/**
 * @author Nicolas Rodriguez
 * @since 1.0
 * @version $Rev: 834 $
 */
public class GroupModel extends AbstractSBasePlugin {

	/**
	 * Generated serial version identifier.
	 */
	private static final long serialVersionUID = 3334444867660252255L;
	/**
	 * 
	 */
	protected ListOf<Group> listOfGroups = new ListOf<Group>();
	/**
	 * 
	 */
	protected Model model;
	
	
	/**
	 * 
	 * @param model
	 */
	public GroupModel(Model model) {
		this.model = model;
	}
	
	/**
	 * 
	 * @param group
	 */
	public void addGroup(Group group) {
		
		group.setParentSBMLObject(model);
		
		listOfGroups.add(group);		
	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	public Group getGroup(int i) {
		if ((i >= 0) && (i < listOfGroups.size())) {
			return listOfGroups.get(i);
		}
		
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public ListOf<Group> getListOfGroups() {
		return listOfGroups;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isSetListOfGroups() {
		if ((listOfGroups == null) || listOfGroups.isEmpty()) {
			return false;			
		}		
		return true;
	}

	/**
	 * 
	 * @param listOfGroups
	 */
	public void setListOfGroups(ListOf<Group> listOfGroups) {
		unsetListOfGroups();
		if (listOfGroups == null) {
			this.listOfGroups = new ListOf<Group>();
		} else {
			this.listOfGroups = listOfGroups;
		}
		if ((this.listOfGroups != null) && (this.listOfGroups.getSBaseListType() != ListOf.Type.other)) {
			this.listOfGroups.setSBaseListType(ListOf.Type.other);
		}
		listOfGroups.setParentSBMLObject(model);
	}

	/**
	 * Removes the {@link #listOfGroups} from this {@link Model} and notifies
	 * all registered instances of {@link TreeNodeChangeListener}.
	 * 
	 * @return <code>true</code> if calling this method lead to a change in this
	 *         data structure.
	 */
	public boolean unsetListOfGroups() {
		if (this.listOfGroups != null) {
			ListOf<Group> oldListOfGroups = this.listOfGroups;
			this.listOfGroups = null;
			oldListOfGroups.fireNodeRemovedEvent();
			return true;
		}
		return false;
	}

	@Override
	public GroupModel clone() {
		// TODO 
		return null;
	}

	@Override
	public String toString() {
		// TODO 
		return null;
	}

	public boolean readAttribute(String attributeName, String prefix, String value) {
		// No attribute define on this plugin
		return false;
	}

	public Map<String, String> writeXMLAttributes() {
		// No attribute define on this plugin
		return null;
	}

	public TreeNode getChildAt(int childIndex) {
		if (childIndex < 0 || childIndex >= 1) {
			return null;
		}
		return listOfGroups;
	}

	public int getChildCount() {		
		if (isSetListOfGroups()) {
			return 1;
		}
		return 0;
	}

	public TreeNode getParent() {
		return model;
	}

  /* (non-Javadoc)
   * @see javax.swing.tree.TreeNode#getAllowsChildren()
   */
  public boolean getAllowsChildren() {
    // TODO Auto-generated method stub
    return false;
  }
		
}
