package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class ConcentratedPower extends AbstractPower {
	public AbstractCreature source;
	
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("ConcentratedPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.CONCENTRATED_POWER);
	
	public ConcentratedPower(final AbstractCreature owner, final AbstractCreature source) {
		this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.img = new Texture(IMG);
        this.description = DESCRIPTIONS[0];
        this.amount = -1;
	}
	
	@Override
	public void atEndOfTurn(boolean isPlayer) {
		if(isPlayer)
			AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, this));
	}
	
	
}
