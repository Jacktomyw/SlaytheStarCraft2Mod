package starcraft2thespiremod.patches.com.megacrit.cardcrawl.helpers.EventHelper;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.EventHelper.RoomResult;
import com.megacrit.cardcrawl.random.Random;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import starcraft2thespiremod.StarCraft2theSpireMod;

@SpirePatch(cls="com.megacrit.cardcrawl.helpers.EventHelper",method = "roll",paramtypez= {
		Random.class
})
public class NewRoll {
	public static RoomResult Postfix(RoomResult __result,Random random) {
		if(AbstractDungeon.currMapNode.y==-1 && AbstractDungeon.id.equals("Exordium") && AbstractDungeon.player.hasRelic(StarCraft2theSpireMod.makeID("HeartofProtoss"))) {StarCraft2theSpireMod.logger.info("GENERATING ROOM: PROTOSS LEADERS");
			return RoomResult.EVENT;
		}else {
			StarCraft2theSpireMod.logger.info(AbstractDungeon.currMapNode.y+ "\r\n" + AbstractDungeon.id + "\r\n");
			for(AbstractRelic r : AbstractDungeon.player.relics) {
				StarCraft2theSpireMod.logger.info(r.name);
			}
			
			return __result;
		}
	}
}
