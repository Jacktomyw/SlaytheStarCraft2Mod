package slaythestarcraft2mod.cards.protoss;

import java.util.Iterator;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.OverLoadCustomCard;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.powers.BeingLaughedPower;
import slaythestarcraft2mod.powers.LaughingPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class LaughtoTheEnd extends OverLoadCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("LaughtoTheEnd");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.LAUGHTOTHEEND);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.RARE;
	private static final CardTarget TARGET = CardTarget.SELF;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 0;
	private static final int BLOCK = 500;
	private static final int UPGRADE_PLUS_BLOCK = 499;
	private static final int OVERLOAD = 1;
	
	public LaughtoTheEnd() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseBlock = BLOCK;
		this.overLoad = OVERLOAD;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new LaughingPower(p), 1));
		Iterator<AbstractMonster> i = AbstractDungeon.getMonsters().monsters.iterator();
		while(i.hasNext()) {
			AbstractMonster mo = i.next();
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, mo, new BeingLaughedPower(mo), 1));
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new LaughtoTheEnd();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeBlock(UPGRADE_PLUS_BLOCK);
			this.initializeDescription();
		}
	}
	
}
