package slaythestarcraft2mod.cards.protoss;

import java.util.Iterator;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.powers.PsionicPower;

public class MasterGradeWarppingBlade extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("MasterGradeWarppingBlade");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.MASTERGRADEWARPPINGBLADE);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.RARE;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 3;
	private static final int DAMAGE = 1;
	private static final int MAGIC_NUMBER = 3;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER = 2;
	
	public MasterGradeWarppingBlade() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DAMAGE;
		this.baseMagicNumber = this.magicNumber = MAGIC_NUMBER;
		this.exhaust = true;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		this.calculateCardDamage(m);
		for(int i=0;i<3;i++) {
			AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAction(m, new DamageInfo(p,this.damage,this.damageTypeForTurn),
					AbstractGameAction.AttackEffect.SMASH));
		}
	}
	
	public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
		this.isDamageModified = false;
		Iterator<AbstractPower> var9 = player.powers.iterator();

		AbstractPower p;
		while (var9.hasNext()) {
			p = (AbstractPower) var9.next();
			if (p instanceof PsionicPower) {
				if (this.upgraded) {
					tmp = p.atDamageGive(tmp, this.damageTypeForTurn);
					tmp = p.atDamageGive(tmp, this.damageTypeForTurn);
				}

				tmp = p.atDamageGive(tmp, this.damageTypeForTurn);
				tmp = p.atDamageGive(tmp, this.damageTypeForTurn);
			}
			if (this.baseDamage != (int) tmp) {
				this.isDamageModified = true;
			}
		}
		this.damage = MathUtils.floor(tmp);
		return tmp;
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new MasterGradeWarppingBlade();
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
