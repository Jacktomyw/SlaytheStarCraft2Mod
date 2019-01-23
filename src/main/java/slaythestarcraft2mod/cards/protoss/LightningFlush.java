package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
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

public class LightningFlush extends OverLoadCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("LightningFlush");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.LIGHTNINGFLUSH);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.UNCOMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	private static final int DMG = 8;
	private static final int UPGRADE_DMG = 3;
	private static final int OVERLOAD = 1;
	
	public LightningFlush() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage=DMG;
		this.overLoad=OVERLOAD;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.effectList.add(new LightningEffect(m.drawX, m.drawY));
		CardCrawlGame.sound.play("ORB_LIGHTNING_EVOKE", 0.1F);
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p,this.damage,this.damageTypeForTurn), AttackEffect.NONE));
		if(p.drawPile.findCardById(SlaytheStarCraft2Mod.makeID("LightningFlush"))!=null&&!m.isDeadOrEscaped()) {
			AbstractDungeon.effectList.add(new LightningEffect(m.drawX, m.drawY));
			CardCrawlGame.sound.play("ORB_LIGHTNING_EVOKE", 0.1F);
			AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p,this.damage,this.damageTypeForTurn), AttackEffect.NONE));
		}
	}
	
	@Override
	public void triggerOnEndOfTurnForPlayingCard() {
		super.triggerOnEndOfTurnForPlayingCard();
		AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), 1));
	}

	@Override
	public AbstractCard makeCopy() {
		return new LightningFlush();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeDamage(UPGRADE_DMG);
			this.initializeDescription();
		}
	}
	
}
