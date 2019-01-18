package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.MultipleBasicValueAndShieldCustomCard;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class ShadowStrike extends MultipleBasicValueAndShieldCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("ShadowStrike");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.SHADOWSTRIKE);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.SPECIAL;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 2;
	private static final int DAMAGE = 6;
	private static final int DAMAGE2 = 10;
	private static final int UPGRADE_PLUS_DAMAGE2 = 6;
	
	public ShadowStrike() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DAMAGE;
		this.baseDamage2 = this.damage2 = DAMAGE2;
		this.tags.add(CardTags.STRIKE);
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p,this.damage,this.damageTypeForTurn),
				AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
		if(p.hasPower(SlaytheStarCraft2Mod.makeID("ConcentratedPower"))) {
			p.getPower(SlaytheStarCraft2Mod.makeID("ConcentratedPower")).flash();
			AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p,this.damage2,this.damageTypeForTurn), 
					AbstractGameAction.AttackEffect.SLASH_HEAVY));
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new ShadowStrike();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeDamage2(UPGRADE_PLUS_DAMAGE2);
			this.initializeDescription();
		}
	}
	
}
