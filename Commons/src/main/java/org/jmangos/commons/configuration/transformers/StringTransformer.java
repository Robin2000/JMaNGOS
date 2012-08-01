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
package org.jmangos.commons.configuration.transformers;

import java.lang.reflect.Field;

import org.jmangos.commons.configuration.PropertyTransformer;
import org.jmangos.commons.configuration.TransformationException;

public class StringTransformer implements PropertyTransformer<String>
{
	/**
	 * Shared instance of this transformer. It's thread-safe so no need of multiple instances
	 */
	public static final StringTransformer	SHARED_INSTANCE	= new StringTransformer();

	/**
	 * Just returns value object.
	 *
	 * @param value value that will be transformed
	 * @param field value will be assigned to this field
	 * @return return value object
	 * @throws TransformationException never thrown
	 */
	@Override
	public String transform(String value, Field field) throws TransformationException
	{
		return value;
	}
}