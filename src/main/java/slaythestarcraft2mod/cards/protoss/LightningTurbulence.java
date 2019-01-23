package slaythestarcraft2mod.cards.protoss;

import java.util.Iterator;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.OverLoadCustomCard;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class LightningTurbulence extends OverLoadCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("LightningTurbulence");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.LIGHTNINGTURBULENCE);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	private static final int DMG = 6;
	private static final int UPGRADE_PLUS_DMG = 2;
	private static final int OVERLOAD = 3;
	
	public LightningTurbulence() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DMG;
		this.isMultiDamage = true;
		this.overLoad = OVERLOAD;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		int count = 0;
		Iterator<AbstractMonster> var4 = AbstractDungeon.getMonsters().monsters.iterator();

		while (var4.hasNext()) {
			AbstractMonster mon = (AbstractMonster) var4.next();
			if (!mon.isDeadOrEscaped()) {
				++count;
		}
	}
		for(AbstractMonster mo : AbstractDungeon.getMonsters().monsters) {
			if(!mo.isDeadOrEscaped())
				AbstractDungeon.effectList.add(new LightningEffect(mo.drawX, mo.drawY));
		}
		CardCrawlGame.sound.play("ORB_LIGHTNING_EVOKE", 0.1F);
		AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(p, multiDamage, this.damageTypeForTurn, AttackEffect.NONE));
		if(count>1) {
			for(AbstractMonster mo : AbstractDungeon.getMonsters().monsters) {
				if(!mo.isDeadOrEscaped())
					AbstractDungeon.effectList.add(new LightningEffect(mo.drawX, mo.drawY));
		}
			CardCrawlGame.sound.play("ORB_LIGHTNING_EVOKE", 0.1F);
			AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(p, multiDamage, this.damageTypeForTurn, AttackEffect.NONE));
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new LightningTurbulence();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeDamage(UPGRADE_PLUS_DMG);
			this.initializeDescription();
		}
	}
	
}
