/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.auth.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javolution.util.FastMap;

import org.apache.log4j.Logger;
import org.jmangos.auth.dao.RealmDAO;
import org.jmangos.auth.model.Realm;
import org.jmangos.commons.service.Service;
import org.springframework.stereotype.Component;

@Component
public class RealmListService implements Service {
	/**
	 * Logger for this class.
	 */
	private static final Logger logger = Logger
			.getLogger(RealmListService.class);

	private static final long UPDATE_INTERVAL = 2000;

	/**
	 * Map with realms
	 */
	private FastMap<Integer, Realm> realms = new FastMap<Integer, Realm>()
			.shared();

	/** The byte size. */
	private int byteSize;

	/** The realm dao. */
	@Inject
	private RealmDAO realmDAO;

	private long nextUpdateTime = 0;

	/**
	 * Gets the worlds.
	 * 
	 * @return the worlds
	 */
	public FastMap<Integer, Realm> getWorlds() {
		return realms;
	}

	public void addFromConnected(Realm newRealm) {
		if (realms.containsKey(newRealm.getId())) {
			logger.debug("Server with this id already connected. Replaced data.");
			realms.remove(newRealm.getId());
			realms.put(newRealm.getId(), newRealm);
		} else {
			realms.put(newRealm.getId(), newRealm);
			byteSize = calculateWorldsSize();
		}
	}

	/**
	 * Loads list of banned ip.
	 */
	@PostConstruct
	public void start() {
		update();
		logger.debug("WorldList loaded " + realms.size() + " realms.");

	}

	/**
	 * Update if need
	 */
	synchronized public void update() {
		if (nextUpdateTime > System.currentTimeMillis()) {
			return;
		}
		nextUpdateTime = System.currentTimeMillis() + UPDATE_INTERVAL;
		FastMap<Integer, Realm> trealms = realmDAO.getAllRealms();
		for (Realm realm : trealms.values()) {
			if (realms.containsKey(realm.getId())) {
				realms.get(realm.getId()).setPopulation(realm.getPopulation());
			} else {
				realms.put(realm.getId(), realm);
			}
		}
		// update byte size all realms
		byteSize = calculateWorldsSize();
	}

	/**
	 * Gets the byte size.
	 * 
	 * @return the byteSize
	 */
	public int getByteSize() {
		return byteSize;
	}

	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public int getRealmCount() {
		return realms.size();
	}

	/**
	 * Calculate worlds size.
	 * 
	 * @return the int
	 */
	public int calculateWorldsSize() {
		int value = 8;
		for (Realm realm : realms.values()) {
			value += realm.getSize();
		}
		return value;
	}

	/**
	 * Gets the amount characters.
	 * 
	 * @param id
	 *            the id
	 * @return the amount characters
	 */
	public FastMap<Integer, Integer> getAmountCharacters(Integer id) {
		return getWorldDAO().getAmountCharacters(id);
	}

	private RealmDAO getWorldDAO() {
		return realmDAO;
	}

	/**
	 * @return the realms
	 */
	public final FastMap<Integer, Realm> getRealms() {
		return realms;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.service.Service#stop()
	 */
	@Override
	public void stop() {
		realms.clear();
	}

}
