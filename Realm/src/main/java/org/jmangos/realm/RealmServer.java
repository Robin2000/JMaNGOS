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
package org.jmangos.realm;

import org.jmangos.commons.network.netty.service.NetworkService;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.realm.utils.ShutdownHook;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The Class RealmServer.
 */
public class RealmServer {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.jmangos.commons", "org.jmangos.realm");
		context.refresh();
		ServiceContent.setContext(context);

		Runtime.getRuntime().addShutdownHook(
				context.getBean(ShutdownHook.class));

		System.gc();
		context.getBean(NetworkService.class).start();
	}
}
