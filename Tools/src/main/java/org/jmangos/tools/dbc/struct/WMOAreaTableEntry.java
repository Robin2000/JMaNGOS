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

public class WMOAreaTableEntry extends DBCStruct<WMOAreaTableEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name = "wmoId", required=true)
	public final Signed32 wmoId = new Signed32();
	@XmlAttribute(name = "NameSetID")
	public final Signed32 NameSetID = new Signed32();
	@XmlAttribute(name = "WMOGroupID", required=true)
	public final Signed32 WMOGroupID = new Signed32();
	@XmlAttribute(name = "SoundProviderPref")
	public final Signed32 SoundProviderPref = new Signed32();
	@XmlAttribute(name = "SoundProviderPrefUnderwater")
	public final Signed32 SoundProviderPrefUnderwater = new Signed32();
	@XmlAttribute(name = "AmbienceID")
	public final Unsigned32 AmbienceID = new Unsigned32();
	@XmlAttribute(name = "ZoneMusic")
	public final Unsigned32 ZoneMusic = new Unsigned32();
	@XmlAttribute(name = "IntroSound")
	public final Unsigned32 IntroSound = new Unsigned32();
	@XmlAttribute(name = "flags", required=true)
	public final Unsigned32 flags = new Unsigned32();
	@XmlAttribute(name = "AreaTableID", required=true)
	public final Unsigned32 AreaTableID = new Unsigned32();
	@XmlAttribute(name = "name", required=true)
	public final MultiInternalString name = new MultiInternalString();
}