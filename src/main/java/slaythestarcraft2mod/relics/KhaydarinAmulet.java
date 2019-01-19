package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.CardGroup.CardGroupType;
import com.megacrit.cardcrawl.cards.colorless.Finesse;
import com.megacrit.cardcrawl.cards.colorless.FlashOfSteel;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

import basemod.abstracts.CustomRelic;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class KhaydarinAmulet extends CustomRelic {
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("KhaydarinAmulet");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.KhaydarinAmulet);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.KhaydarinAmulet_OUTLINE);
	private boolean cardSelected = false;
	
    public KhaydarinAmulet() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.COMMON, LandingSound.SOLID);
    }

	public String getUpdatedDescription() {
		return this.DESCRIPTIONS[0];
	}
	
	@Override
	public void onEquip() {
		this.cardSelected  = false;
		if (AbstractDungeon.isScreenUp) {
			AbstractDungeon.dynamicBanner.hide();
			AbstractDungeon.overlayMenu.cancelButton.hide();
			AbstractDungeon.previousScreen = AbstractDungeon.screen;
		}

		AbstractDungeon.getCurrRoom().phase = RoomPhase.INCOMPLETE;
		CardGroup group = new CardGroup(CardGroupType.UNSPECIFIED);

			AbstractCard attack = new FlashOfSteel();
			AbstractCard skill = new Finesse();
			if (AbstractDungeon.player.hasRelic("Molten Egg 2")) {
				attack.upgrade();
			}
			if (AbstractDungeon.player.hasRelic("Toxic Egg 2")) {
				skill.upgrade();
			}
			
			group.addToBottom(attack);
			group.addToBottom(skill);
			UnlockTracker.markCardAsSeen(attack.cardID);
			UnlockTracker.markCardAsSeen(skill.cardID);
			AbstractDungeon.gridSelectScreen.open(group, 1, this.DESCRIPTIONS[1], false, false, false, false);
	}
	@Override
	public void update() {
		super.update();
		if (!this.cardSelected && AbstractDungeon.gridSelectScreen.selectedCards.size() == 1) {
			this.cardSelected = true;
			AbstractDungeon.topLevelEffects.add(
					new ShowCardAndObtainEffect((AbstractCard) AbstractDungeon.gridSelectScreen.selectedCards.get(0),
							(float) Settings.WIDTH / 2.0F - 30.0F * Settings.scale - AbstractCard.IMG_WIDTH / 2.0F,
							(float) Settings.HEIGHT / 2.0F));
//			AbstractCard card = (AbstractCard) AbstractDungeon.gridSelectScreen.selectedCards.iterator().next();
//			AbstractDungeon.player.masterDeck.addToTop(card);

			AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;
			AbstractDungeon.gridSelectScreen.selectedCards.clear();
		}
//		super.update();
//		if (this.pickCard && !AbstractDungeon.isScreenUp && !AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
//			AbstractCard c = ((AbstractCard) AbstractDungeon.gridSelectScreen.selectedCards.get(0)).makeCopy();
//			AbstractDungeon.effectList
//					.add(new ShowCardAndObtainEffect(c, (float) Settings.WIDTH / 2.0F, (float) Settings.HEIGHT / 2.0F));
//		}
	}
}
