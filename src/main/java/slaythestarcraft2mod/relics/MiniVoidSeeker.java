package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClass;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;

import basemod.abstracts.CustomRelic;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.powers.ConcentratedPower;;

public class MiniVoidSeeker extends CustomRelic {
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("MiniVoidSeeker");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.MiniVoidSeeker);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.MiniVoidSeeker_OUTLINE);

	private boolean firstTurn = false;
	private boolean notDealDamageLastTurn = true;
	private boolean notReceiveDamageLastTurn = true;
	
    public MiniVoidSeeker() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.SPECIAL, LandingSound.FLAT);
    }

	public String getUpdatedDescription() {
		return AbstractDungeon.player != null
				? this.setDescription(AbstractDungeon.player.chosenClass)
				: this.setDescription((PlayerClass) null);
	}
	
    private String setDescription(PlayerClass c) {
		return this.DESCRIPTIONS[0] + this.DESCRIPTIONS[1];
	}

	public void updateDescription(PlayerClass c) {
		this.description = this.setDescription(c);
		this.tips.clear();
		this.tips.add(new PowerTip(this.name, this.description));
		this.initializeTips();
	}
	
	public void atPreBattle() {
		this.flash();
		this.firstTurn = true;
		if (!this.pulse) {
			this.beginPulse();
			this.pulse = true;
		}
	}
	
    @Override
	public int onAttacked(DamageInfo info, int damageAmount) {
    	if (info.type != DamageType.HP_LOSS && info.owner != null && damageAmount > 0 && !AbstractDungeon.player.hasPower("Buffer")) {
    		if(AbstractDungeon.player.hasPower(SlaytheStarCraft2Mod.makeID("ShieldPower"))) {
    			if(AbstractDungeon.player.getPower(SlaytheStarCraft2Mod.makeID("ShieldPower")).amount>=damageAmount)
    				return damageAmount;
    		}
			notReceiveDamageLastTurn = false;
			this.stopPulse();
		}
		return damageAmount;
	}
	
	@Override
	public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
		if (damageAmount > 0 && info.type != DamageType.THORNS) {
			notDealDamageLastTurn = false;
		}
	}

	@Override
	public void atTurnStart() {
		if(!firstTurn) {
			if(notReceiveDamageLastTurn || notDealDamageLastTurn) {
				this.flash();
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ConcentratedPower(AbstractDungeon.player, AbstractDungeon.player)));
				AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(1));
			}
		}
		firstTurn=false;
		notReceiveDamageLastTurn=true;
		notDealDamageLastTurn=true;
		this.beginPulse();
	}
}
