/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
/**
 * 
 */
package org.jmangos.tools.dbc;

import org.jmangos.tools.dbc.service.impl.DbcStorages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MinimaJack
 * 
 */
public class DbcConverter {

    /**
     * @param args
     */
    @SuppressWarnings("resource")
    public static void main(final String[] args) {

        final ApplicationContext appContext =
                new ClassPathXmlApplicationContext(
                        new String[] { "classpath:/META-INF/applicationContext.xml" });
        appContext.getBean(DbcStorages.class).encode();
    }

}
