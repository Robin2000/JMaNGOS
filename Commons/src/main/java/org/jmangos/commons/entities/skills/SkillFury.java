/**
 * 
 */
package org.jmangos.commons.entities.skills;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "256")
public class SkillFury extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5167473156056975951L;

}