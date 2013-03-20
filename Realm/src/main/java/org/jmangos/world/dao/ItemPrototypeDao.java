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
package org.jmangos.world.dao;

import java.util.List;

import org.jmangos.commons.entities.ItemPrototype;

public interface ItemPrototypeDao {

    public ItemPrototype readItemPrototype(Integer id);

    public List<ItemPrototype> readItemPrototypes();

    public Integer createOrUpdateItemPrototype(ItemPrototype itemPrototype);

    public void deleteItemPrototype(ItemPrototype itemPrototype);

}
