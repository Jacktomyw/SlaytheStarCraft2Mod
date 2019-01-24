package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
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

public class StretchLightning extends OverLoadCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("StretchLightning");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.STRETCHLIGHTNING);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String[] EXTENDED_DESCRIPTION = cardStrings.EXTENDED_DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 2;
	
	private static final int DMG = 10;
	private static final int MAGIC_NUMBER = 150;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER = 50;
	private static final int OVERLOAD = 2;
	public StretchLightning() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage=DMG;
		this.baseMagicNumber = this.magicNumber = MAGIC_NUMBER;
		this.overLoad=OVERLOAD;
	}
	
	@Override
	public void calculateCardDamage(AbstractMonster mo) {
		super.calculateCardDamage(mo);
		this.rawDescription = DESCRIPTION;
		this.rawDescription = this.rawDescription + EXTENDED_DESCRIPTION[0] + (int)((float)this.damage*(float)this.magicNumber/100f) +EXTENDED_DESCRIPTION[1];
		this.initializeDescription();
	}
	
	public void applyPowers() {
		super.applyPowers();
		this.rawDescription = DESCRIPTION;
		this.rawDescription = this.rawDescription + EXTENDED_DESCRIPTION[0] + (int)((float)this.damage*(float)this.magicNumber/100f) +EXTENDED_DESCRIPTION[1];
		this.initializeDescription();
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.effectList.add(new LightningEffect(m.drawX, m.drawY));
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AttackEffect.NONE));
		CardCrawlGame.sound.play("ORB_LIGHTNING_EVOKE", 0.1F);
		for(AbstractMonster mo : AbstractDungeon.getMonsters().monsters) {
			if(mo != m && !mo.isDeadOrEscaped()) {
				AbstractDungeon.effectList.add(new LightningEffect(mo.drawX, mo.drawY));
				AbstractDungeon.actionManager.addToBottom(new DamageAction(mo, new DamageInfo(p, (int) (this.damage*((float)this.magicNumber/100f)), this.damageTypeForTurn), AttackEffect.NONE));
			}
		}
		CardCrawlGame.sound.play("ORB_LIGHTNING_EVOKE", 0.1F);
	}
	
	public void onMoveToDiscard() {
		this.rawDescription = DESCRIPTION;
		this.initializeDescription();
	}
	@Override
	public AbstractCard makeCopy() {
		return new StretchLightning();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeMagicNumber(UPGRADE_PLUS_MAGIC_NUMBER);
			this.initializeDescription();
		}
	}
	
}