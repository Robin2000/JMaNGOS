package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.SpellEffectEntity;

@Entity
@DiscriminatorValue("64")
public class TriggerSpell extends SpellEffectEntity {

    public TriggerSpell() {

    }

}