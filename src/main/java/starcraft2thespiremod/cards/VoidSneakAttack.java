package starcraft2thespiremod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import starcraft2thespiremod.StarCraft2theSpireMod;
import starcraft2thespiremod.patches.AbstractCardEnum;

public class VoidSneakAttack extends CustomCard{

	
	public static final String ID = starcraft2thespiremod.StarCraft2theSpireMod.makeID("VoidSneakAttack");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.VoidSneakAttack);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.;
	private static final CardTarget TARGET = CardTarget.;
	private static final CardType TYPE = CardType.;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = ;
	private static final int DAMAGE = ;
	private static final int UPGRADE_PLUS_DMG = ;
	
	public VoidSneakAttack() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DAMAGE;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAction(m, new DamageInfo(p,this.damage,this.damageTypeForTurn),
				AbstractGameAction.AttackEffect.BLUNT_LIGHT));
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new VoidSneakAttack();
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
