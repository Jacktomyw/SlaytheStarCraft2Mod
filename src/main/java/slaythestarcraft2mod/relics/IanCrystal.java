package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import basemod.abstracts.CustomRelic;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.powers.PsionicPower;

public class IanCrystal extends CustomRelic{
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("IanCrystal");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.IanCrystal);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.IanCrystal_OUTLINE);
	
    public IanCrystal() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.COMMON, LandingSound.SOLID);
    }

	public String getUpdatedDescription() {
		return this.DESCRIPTIONS[0];
	}
	
	@Override
	public void atTurnStart() {
		this.flash();
		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new PsionicPower(AbstractDungeon.player, 2),2));
	}
}
