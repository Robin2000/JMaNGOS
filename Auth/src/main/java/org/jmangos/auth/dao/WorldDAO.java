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
package org.jmangos.auth.dao;

import org.jmangos.auth.model.World;
import org.jmangos.commons.database.dao.DAO;

import javolution.util.FastMap;

/**
 * The Class WorldDAO.
 * 
 * @author MinimaJack
 * 
 */
public abstract class WorldDAO implements DAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.common.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return WorldDAO.class.getName();
	}

	/**
	 * Gets the all worlds.
	 * 
	 * @return the all worlds
	 */
	public abstract FastMap<Integer, World> getAllWorlds();

	/**
	 * Gets the amount characters.
	 * 
	 * @param id
	 *            the id
	 * @return the amount characters
	 */
	public abstract FastMap<Integer, Integer> getAmountCharacters(
			final Integer id);

}