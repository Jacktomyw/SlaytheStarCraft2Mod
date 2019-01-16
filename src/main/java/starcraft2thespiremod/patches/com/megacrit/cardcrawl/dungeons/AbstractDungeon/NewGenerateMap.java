package starcraft2thespiremod.patches.com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import starcraft2thespiremod.StarCraft2theSpireMod;

@SpirePatch(cls="com.megacrit.cardcrawl.dungeons.AbstractDungeon",method="generateMap")

public class NewGenerateMap {
	public static void Postfix() {
		StarCraft2theSpireMod.receivePostGenerateMap();
	}
}
