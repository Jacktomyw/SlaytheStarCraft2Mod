package slaythestarcraft2mod.patches.com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;

@SpirePatch(cls="com.megacrit.cardcrawl.dungeons.AbstractDungeon",method="generateMap")

public class NewGenerateMap {
	public static void Postfix() {
		SlaytheStarCraft2Mod.receivePostGenerateMap();
	}
}
