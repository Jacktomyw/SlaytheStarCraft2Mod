package slaythestarcraft2mod.patches.com.megacrit.cardcrawl.helpers.EventHelper;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.EventHelper.RoomResult;
import com.megacrit.cardcrawl.random.Random;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;

@SpirePatch(cls="com.megacrit.cardcrawl.helpers.EventHelper",method = "roll",paramtypez= {
		Random.class
})
public class NewRoll {
	public static RoomResult Postfix(RoomResult __result,Random random) {
		if(AbstractDungeon.currMapNode.y==-1 && AbstractDungeon.id.equals("Exordium") && AbstractDungeon.player.hasRelic(SlaytheStarCraft2Mod.makeID("HeartofProtoss"))) {SlaytheStarCraft2Mod.logger.info("GENERATING ROOM: PROTOSS LEADERS");
			return RoomResult.EVENT;
		}else {
			SlaytheStarCraft2Mod.logger.info(AbstractDungeon.currMapNode.y+ "\r\n" + AbstractDungeon.id + "\r\n");
			for(AbstractRelic r : AbstractDungeon.player.relics) {
				SlaytheStarCraft2Mod.logger.info(r.name);
			}
			
			return __result;
		}
	}
}
