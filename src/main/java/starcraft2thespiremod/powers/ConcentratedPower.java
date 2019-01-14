package starcraft2thespiremod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.patches.bothInterfaces.OnReceivePowerPatch.ApplyPower;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;

import starcraft2thespiremod.StarCraft2theSpireMod;

public class ConcentratedPower extends AbstractPower {
	public AbstractCreature source;
	
	public static final String POWER_ID = starcraft2thespiremod.StarCraft2theSpireMod.makeID("ConcentratedPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.CONCENTRATED_POWER);
	
	public ConcentratedPower(final AbstractCreature owner, final AbstractCreature source) {
		this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.isTurnBased = false;
        this.img = new Texture(IMG);
        this.source = source;
        
	}

	@Override
	public void atEndOfTurn(boolean isPlayer) {
		AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, "ConcentratedPower"));
	}
	
	
}
