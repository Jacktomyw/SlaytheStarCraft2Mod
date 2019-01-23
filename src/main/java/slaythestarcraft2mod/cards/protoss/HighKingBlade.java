package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.VerticalImpactEffect;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.OverLoadCustomCard;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.patches.AbstractCardEnum;

public class HighKingBlade extends OverLoadCustomCard {

	public static final String ID = SlaytheStarCraft2Mod.makeID("HighKingBlade");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.HIGHKINGBLADE);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.RARE;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 4;
	private static final int DMG = 50;
	private static final int UPGRADE_PLUS_DMG = 15;
	private static final int DMG2 = 25;
	private static final int UPGRADE_PLUS_DMG2 = 7;
	private static final int OVERLOAD = 10;
	
	public HighKingBlade() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DMG;
		this.baseDamage2 = DMG2;
		this.overLoad = OVERLOAD;
	}
	
	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		for(int i=0;i<this.tags.size();i++) {
			SlaytheStarCraft2Mod.logger.info("the card " + this.name + " has tag: "+this.tags.get(i));
		}
		AbstractDungeon.actionManager.addToBottom(
				new VFXAction(new VerticalImpactEffect(m.hb.cX + m.hb.width / 4.0F, m.hb.cY - m.hb.height / 4.0F)));
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAction(m, new DamageInfo(p,this.damage,this.damageTypeForTurn),
				AbstractGameAction.AttackEffect.NONE));		
	}
	
	@Override
	public void triggerOnEndOfTurnForPlayingCard() {
		super.triggerOnEndOfTurnForPlayingCard();
		AbstractMonster m = AbstractDungeon.getRandomMonster();
		AbstractDungeon.actionManager.addToBottom(
				new VFXAction(new VerticalImpactEffect(m.hb.cX + m.hb.width / 4.0F, m.hb.cY - m.hb.height / 4.0F)));
		AbstractDungeon.actionManager.addToTop(new DamageAction(m,
				new DamageInfo(AbstractDungeon.player, this.damage2, DamageType.NORMAL), AttackEffect.NONE));
	}

	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeDamage(UPGRADE_PLUS_DMG);
			this.upgradeDamage2(UPGRADE_PLUS_DMG2);
			this.initializeDescription();
		}
	}

}
