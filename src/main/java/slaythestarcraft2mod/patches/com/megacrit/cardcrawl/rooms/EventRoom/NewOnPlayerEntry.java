package slaythestarcraft2mod.patches.com.megacrit.cardcrawl.rooms.EventRoom;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.random.Random;
import com.megacrit.cardcrawl.rooms.EventRoom;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.events.ProtossLeaders;

@SpirePatch(cls="com.megacrit.cardcrawl.rooms.EventRoom",method="onPlayerEntry")
public class NewOnPlayerEntry {
	public static void Replace(EventRoom __instance) {
		if(AbstractDungeon.currMapNode.y==0 &&
				AbstractDungeon.id.equals("Exordium") &&
				AbstractDungeon.player.hasRelic(SlaytheStarCraft2Mod.makeID("HeartofProtoss"))) {
			SlaytheStarCraft2Mod.logger.info("SELECT EVENT: PROTOSS LEADERS");
			AbstractDungeon.overlayMenu.proceedButton.hide();
			__instance.event = new ProtossLeaders();
			__instance.event.onEnterRoom();
		}else {
			AbstractDungeon.overlayMenu.proceedButton.hide();
			Random eventRngDuplicate = new Random(Settings.seed, AbstractDungeon.eventRng.counter);
			__instance.event = AbstractDungeon.generateEvent(eventRngDuplicate);
			__instance.event.onEnterRoom();
		}
	}
}
