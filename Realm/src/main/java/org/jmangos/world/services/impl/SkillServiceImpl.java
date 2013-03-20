/**
 * 
 */
package org.jmangos.world.services.impl;

import java.util.List;

import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.jmangos.world.dao.SkillRaceClassDao;
import org.jmangos.world.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author MinimaJack
 * 
 */
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRaceClassDao skillRaceClassDao;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.test.services.SkillService#getSkillsForRaceClass(org.jmangos.
     * realm.model.enums
     * .Races, org.jmangos.realm.model.enums.Classes)
     */
    @Override
    public List<SkillRaceClassInfoEntity> getSkillsForRaceClass(final Races race,
            final Classes clazz) {
        return this.skillRaceClassDao.readSkillRaceClasses(race, clazz);
    }

}
