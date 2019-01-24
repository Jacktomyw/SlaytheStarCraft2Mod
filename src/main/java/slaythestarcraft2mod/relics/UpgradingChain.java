package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import basemod.abstracts.CustomRelic;
import basemod.abstracts.CustomSavable;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.patches.CardTagsEnum;

public class UpgradingChain extends CustomRelic implements CustomSavable<Integer>{
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("UpgradingChain");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.UpgradingChain);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.UpgradingChain_OUTLINE);
    
    private int enemytoSlain = 3;
    
	public UpgradingChain() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.SPECIAL, LandingSound.MAGICAL);
        this.counter = 0;
	}
	public String getUpdatedDescription() {
		return this.DESCRIPTIONS[0];
	}
	@Override
	public void onMonsterDeath(AbstractMonster m) {
		if(AbstractDungeon.player.cardInUse!=null) {
			if(AbstractDungeon.player.cardInUse.hasTag(CardTagsEnum.OVERLOAD)) {
				if((m.isDying || m.currentHealth <= 0) && !m.halfDead
						&& !m.hasPower("Minion")) {
					this.flash();
					if(enemytoSlain==1) {
						enemytoSlain=3;
						++this.counter;
						AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, 1), 1));
					}else {
						enemytoSlain--;
					}
				}
			}
		}
		setCounter(counter);
	}
	public void setCounter(int c) {
		this.counter = c;
		this.description = this.DESCRIPTIONS[0] + " NL " + this.DESCRIPTIONS[1] + enemytoSlain	+ this.DESCRIPTIONS[2];
		this.tips.clear();
		this.tips.add(new PowerTip(this.name, this.description));
		this.initializeTips();
	}
	
	public void atBattleStart() {
		setCounter(counter);
		if (this.counter > 0) {
			this.flash();
			AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player,
					new StrengthPower(AbstractDungeon.player, this.counter), this.counter));
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
		}
	}
	@Override
	public void onLoad(Integer enemytoSlain) {
		SlaytheStarCraft2Mod.logger.info("enemytoSlain "+enemytoSlain+" loaded.");
		this.enemytoSlain = enemytoSlain;
		setCounter(this.counter);
	}
	@Override
	public Integer onSave() {
		SlaytheStarCraft2Mod.logger.info("enemytoSlain "+enemytoSlain+" loaded.");
		return enemytoSlain;
	}
}
