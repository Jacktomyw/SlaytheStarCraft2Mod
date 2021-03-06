package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.MindblastEffect;

import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.patches.CardTagsEnum;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class VoidPowerCannon extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("VoidPowerCannon");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.VOIDPOWERCANNON);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.UNCOMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	private static final int DAMAGE = 9;
	private static final int UPGRADE_PLUS_DMG = 3;
	
	public VoidPowerCannon() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DAMAGE;
		this.retain = true;
		this.tags.add(CardTagsEnum.NOPSIONIC);
	}
	
	public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
		if(!player.hasPower(SlaytheStarCraft2Mod.makeID("PsionicPower"))) {
			return tmp;
		}
		return tmp-(float)(player.getPower(SlaytheStarCraft2Mod.makeID("PsionicPower")).amount);
	}

	@Override
	public void atTurnStart() {
		this.retain = true;
	}

	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager
				.addToBottom(new VFXAction(p, new MindblastEffect(p.dialogX, p.dialogY, p.flipHorizontal), 0.1F));
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAction(m, new DamageInfo(p,this.damage,this.damageTypeForTurn),
				AbstractGameAction.AttackEffect.NONE));
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new VoidPowerCannon();
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
