/*
 * Copyright (c) 2020-2022 Radialbog9/TheJoeCoder and contributors.
 * You are allowed to use this code under the GPL3 license, which allows
 * commercial use, distribution, modification, and licensed works,
 * providing that you distribute your code under the same or similar license.
 */

package uk.radialbog9.spigot.manhunt.scenario.ldisscenarios;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import uk.radialbog9.spigot.manhunt.game.GameManager;
import uk.radialbog9.spigot.manhunt.scenario.*;
import uk.radialbog9.spigot.manhunt.utils.DependencySupport;
import uk.radialbog9.spigot.manhunt.utils.Utils;

@Scenario(ScenarioType.HUNTER_RANDOM_MOB_DISGUISE)
@ScenarioRunnable
@SuppressWarnings({"unused"})
public class RandHunterMobDisgScenario extends BukkitRunnable {
    @Override
    public void run() {
        if(
                DependencySupport.isLibsDisguisesEnabled() &&
                GameManager.getGame().isGameStarted() &&
                GameManager.getGame().getActiveScenarios().contains(ScenarioType.HUNTER_RANDOM_MOB_DISGUISE)
        ) {
            for(Player p : GameManager.getGame().getHunters()) {
                boolean isMobYet = false;
                DisguiseType disguisetype = null;
                while (!isMobYet) {
                    int dis = Utils.getRandomInt(0, DisguiseType.values().length - 1);
                    disguisetype = DisguiseType.values()[dis];
                    isMobYet = disguisetype.isMob();
                }
                Disguise disguise = new MobDisguise(disguisetype);
                DisguiseAPI.disguiseEntity(p, disguise);
                p.sendMessage("You are now a " + disguisetype.toReadable());
            }
        } else {
            this.cancel();
        }
    }
}
