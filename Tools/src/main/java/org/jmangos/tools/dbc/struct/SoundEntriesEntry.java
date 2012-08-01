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
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;


public class SoundEntriesEntry extends DBCStruct<SoundEntriesEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="Type")
    public final Unsigned32 Type = new Unsigned32();
	@XmlAttribute(name="name")
    public final InternalString name = new InternalString();  
	@XmlAttribute(name="FileName")
    public final InternalString[] FileName = array(new InternalString[10]); 
	@XmlAttribute(name="repeatCount")
	public final Unsigned32[] repeatCount = array(new Unsigned32[10]);  
	@XmlAttribute(name="Path")
    public final InternalString Path = new InternalString();  
	@XmlAttribute(name="volumeFloat")
	public final Float32 volumeFloat = new Float32();
	@XmlAttribute(name="flags")
	public final Unsigned32 flags = new Unsigned32();
	@XmlAttribute(name="minDistance")
	public final Float32 minDistance = new Float32();
	@XmlAttribute(name="maxDistance")
	public final Float32 maxDistance = new Float32();
	@XmlAttribute(name="EAXDef")
	public final Unsigned32 EAXDef = new Unsigned32();
	@XmlAttribute(name="unknown")
	public final Unsigned32 unknown = new Unsigned32();
}