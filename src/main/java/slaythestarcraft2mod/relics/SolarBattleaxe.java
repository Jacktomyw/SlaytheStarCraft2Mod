package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomRelic;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.powers.TornPower;

public class SolarBattleaxe extends CustomRelic {
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("SolarBattleaxe");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.SolarBattleaxe);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.SolarBattleaxe_OUTLINE);
	
    public SolarBattleaxe() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.UNCOMMON, LandingSound.HEAVY);
    }

	public String getUpdatedDescription() {
		return this.DESCRIPTIONS[0];
	}
	
	@Override
	public void atTurnStart() {
		this.flash();
		for(AbstractMonster mo : AbstractDungeon.getMonsters().monsters) {
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, AbstractDungeon.player, new TornPower(mo, 1), 1));
		}
	}
}
