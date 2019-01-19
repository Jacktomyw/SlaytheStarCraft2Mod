package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import basemod.abstracts.CustomRelic;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.powers.ShieldPower;

public class Khala extends CustomRelic{
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("Khala");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.Khala);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.Khala_OUTLINE);
	
    private CardType type;
    private boolean isSame = true;
    
    public Khala() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.UNCOMMON, LandingSound.CLINK);
    }

	public String getUpdatedDescription() {
		return this.DESCRIPTIONS[0];
	}

	@Override
	public void onUseCard(AbstractCard card, UseCardAction useCardAction) {
		if(type==null) {
			switch(card.type) {
			case ATTACK:
				type = CardType.ATTACK;
				break;
			case POWER:
				type = CardType.POWER;
				break;
			case SKILL:
				type = CardType.SKILL;
				break;
			default:
				break;
			}
		}else {
			if(card.type!=type) {
				this.stopPulse();
				isSame=false;
			}
		}
		if(AbstractDungeon.player.cardsPlayedThisTurn >= 3) {
			this.beginPulse();
		}
	}

	@Override
	public void onPlayerEndTurn() {
		if(isSame && AbstractDungeon.player.cardsPlayedThisTurn >= 3) {
			this.flash();
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShieldPower(AbstractDungeon.player, 15), 15));
		}
		isSame = true;
		type = null;
	}


	
}
