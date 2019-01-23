package slaythestarcraft2mod.abstracts;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import slaythestarcraft2mod.patches.CardTagsEnum;

public abstract class OverLoadCustomCard extends MultipleBasicValueAndShieldCustomCard {

	//	public boolean isUsing = false;
	public int overLoad = 0;
	
	public OverLoadCustomCard(String id, String name, String img, int cost, String rawDescription, CardType type,
			CardColor color, CardRarity rarity, CardTarget target) {
		super(id, name, img, cost, rawDescription, type, color, rarity, target);
		this.tags.add(CardTagsEnum.OVERLOAD);
		
//		= new BorderFlashEffect(Color.YELLOW);
	}

//	@Override
//	public void renderOuterGlow(SpriteBatch sb) {
//		if (AbstractDungeon.player != null) {
//			if (!Settings.hideCards) {
//				float drawX = this.current_x - 256.0F;
//				float drawY = this.current_y - 256.0F;
////				renderHelper(sb, AbstractDungeon.player.getCardRenderColor(), this.getCardBg(), drawX, drawY,
////						1.0F + this.tintColor.a / 5.0F);
//				Color tintColor = null;
//				try {
//					tintColor = (Color) SuperclassFinder.getSuperclassField(Color.class, "tintColor").get(Color.class);
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				} catch (NoSuchFieldException e) {
//					e.printStackTrace();
//				}
//				SlaytheStarCraft2Mod.logger.info("outerglow");
//				sb.setColor(Color.YELLOW);
//				sb.draw(this.getCardBg(), drawX, drawY, 256.0F, 256.0F, 512.0F, 512.0F, this.drawScale * Settings.scale * (tintColor.a),
//						this.drawScale * Settings.scale * (tintColor.a), this.angle, 0, 0, 512, 512, false, false);
//			
//			}
//
//		}
//	}

//	@Override
//	public void use(AbstractPlayer var1, AbstractMonster var2) {
//		if(overLoad!=0) {
//			this.flash();
//			AbstractDungeon.actionManager.addToTop(new DamageAction(AbstractDungeon.player,
//					new DamageInfo(AbstractDungeon.player, overLoad, DamageType.THORNS), AttackEffect.FIRE));
//		}
//	}

	@Override
	public void triggerOnEndOfTurnForPlayingCard() {
		if(overLoad!=0) {
			this.superFlash(Color.RED);
			AbstractDungeon.actionManager.addToTop(new DamageAction(AbstractDungeon.player,
					new DamageInfo(AbstractDungeon.player, overLoad, DamageType.THORNS), AttackEffect.FIRE));
		}
		super.triggerOnEndOfTurnForPlayingCard();
	}

}
