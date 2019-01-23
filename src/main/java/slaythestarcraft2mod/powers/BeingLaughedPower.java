package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class BeingLaughedPower extends AbstractPower {
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("BeingLaughedPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.BEINGLAUGHED_POWER);
	
	public BeingLaughedPower(AbstractCreature owner) {
		this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.DEBUFF;
        this.img = new Texture(IMG);
        this.description = DESCRIPTIONS[0];
        this.amount = -1;
	}
	
	@Override
	public void onDeath() {
		AbstractPlayer p = AbstractDungeon.player;
		if(!owner.hasPower("Minion")) {
			if(p.hasPower(SlaytheStarCraft2Mod.makeID("LaughingPower"))) {
				AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(p, p, SlaytheStarCraft2Mod.makeID("LaughingPower")));
			}
		}
	}

	@Override
	public void atEndOfTurn(boolean isPlayer) {
		if(isPlayer) {
			AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, this));
		}
	}
	
}
