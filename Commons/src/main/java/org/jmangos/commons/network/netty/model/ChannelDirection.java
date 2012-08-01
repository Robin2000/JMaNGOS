/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.jmangos.commons.network.netty.model;

// TODO: Auto-generated Javadoc
/**
 * The Enum ChannelDirection.
 */
public enum ChannelDirection {
	  
  	/** The UPSTREAM. */
  	UPSTREAM(1),
	  
  	/** The DOWNSTREAM. */
  	DOWNSTREAM(1 << 1);

	  /** The id. */
  	private int id;

	  /**
  	 * Instantiates a new channel direction.
  	 *
  	 * @param id the id
  	 */
	  ChannelDirection(int id) {
	    this.id = id;
	  }

	  /**
  	 * Gets the id.
  	 *
  	 * @return the id
  	 */
	  public int getId() {
	    return id;
	  }
}