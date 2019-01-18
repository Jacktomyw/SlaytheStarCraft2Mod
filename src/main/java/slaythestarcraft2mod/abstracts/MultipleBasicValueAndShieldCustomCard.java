package slaythestarcraft2mod.abstracts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GameDataStringBuilder;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.powers.PsionicPower;

public abstract class MultipleBasicValueAndShieldCustomCard extends CustomCard {
	public int baseDamage2=-1;
	public int baseBlock2=-1;
	public int baseMagicNumber2=-1;
	public int baseShield=-1;
	public int damage2=-1;
	public int block2=-1;
	public int magicNumber2=-1;
	public int shield=-1;
	public boolean isDamage2Modified=false;
	public boolean isBlock2Modified=false;
	public boolean isMagicNumber2Modified=false;
	public boolean isShieldModified=false;
	public boolean upgradedDamage2=false;
	public boolean upgradedBlock2=false;
	public boolean upgradedMagicNumber2=false;
	public boolean upgradedShield=false;
	
	public MultipleBasicValueAndShieldCustomCard(String id, String name, String img, int cost, String rawDescription,
			CardType type, CardColor color, CardRarity rarity, CardTarget target) {
		super(id, name, img, cost, rawDescription, type, color, rarity, target);
	}
	
	public void displayUpgrades() {
		super.displayUpgrades();
		if (this.upgradedDamage2) {
			this.damage2=this.baseDamage2;
			this.isDamage2Modified = true;
		}
		if (this.upgradedBlock2) {
			this.block2=this.baseBlock2;
			this.isDamage2Modified = true;
		}
		if (this.upgradedMagicNumber2) {
			this.magicNumber2=this.baseMagicNumber2;
			this.isDamage2Modified = true;
		}
		if (this.upgradedShield) {
			this.shield=this.baseShield;
			this.isDamage2Modified = true;
		}
	}
	
	protected void upgradeDamage2(int amount) {
		this.baseDamage2 += amount;
		this.upgradedDamage2 = true;
	}
	protected void upgradeBlock2(int amount) {
		this.baseBlock2 += amount;
		this.upgradedBlock2 = true;
	}
	protected void upgradeMagicNumber2(int amount) {
		this.baseMagicNumber2 += amount;
		this.upgradedMagicNumber2 = true;
	}
	protected void upgradeShield(int amount) {
		this.baseShield += amount;
		this.upgradedShield = true;
	}
	
	public MultipleBasicValueAndShieldCustomCard makeStatEquivalentCopy() {
		MultipleBasicValueAndShieldCustomCard card = (MultipleBasicValueAndShieldCustomCard) super.makeStatEquivalentCopy();
		card.baseDamage2=this.baseDamage2;
		card.baseBlock2=this.baseBlock2;
		card.baseMagicNumber2=this.baseMagicNumber2;
		card.baseShield=this.baseShield;
		return card;
	}
	
	public void resetAttributes() {
		super.resetAttributes();
		this.block2 = this.baseBlock2;
		this.isBlock2Modified = false;
		this.damage2 = this.baseDamage2;
		this.isDamage2Modified = false;
		this.magicNumber2 = this.baseMagicNumber2;
		this.isMagicNumber2Modified = false;
		this.shield = this.baseShield;
		this.isShieldModified = false;
	}
	
	public void applyPowers() {
		this.applyPowersToBlock2();
		this.applyPowersToShield();
		AbstractPlayer player = AbstractDungeon.player;
		this.isDamage2Modified = false;
		if (!this.isMultiDamage) {
			float tmp = (float) this.baseDamage2;

			if (AbstractDungeon.player.hasRelic("WristBlade") && (this.costForTurn == 0 || this.freeToPlayOnce)) {
				tmp += 3.0F;
				if (this.baseDamage2 != (int) tmp) {
					this.isDamage2Modified = true;
				}
			}

			Iterator<AbstractPower> var3 = player.powers.iterator();

			AbstractPower p;
			while (var3.hasNext()) {
				p = (AbstractPower) var3.next();

				tmp = p.atDamageGive(tmp, this.damageTypeForTurn);
				if (this.baseDamage2 != (int) tmp) {
					this.isDamage2Modified = true;
				}
			}

			var3 = player.powers.iterator();

			while (var3.hasNext()) {
				p = (AbstractPower) var3.next();
				tmp = p.atDamageFinalGive(tmp, this.damageTypeForTurn);
				if (this.baseDamage2 != (int) tmp) {
					this.isDamage2Modified = true;
				}
			}

			if (tmp < 0.0F) {
				tmp = 0.0F;
			}

			this.damage2 = MathUtils.floor(tmp);
		} else {
			ArrayList<AbstractMonster> m = AbstractDungeon.getCurrRoom().monsters.monsters;
			float[] tmp = new float[m.size()];

			int i;
			for (i = 0; i < tmp.length; ++i) {
				tmp[i] = (float) this.baseDamage2;
			}

			Iterator<AbstractPower> var5;
			AbstractPower p;
			for (i = 0; i < tmp.length; ++i) {
				if (AbstractDungeon.player.hasRelic("WristBlade") && (this.costForTurn == 0 || this.freeToPlayOnce)) {
					tmp[i] += 3.0F;
					if (this.baseDamage2 != (int) tmp[i]) {
						this.isDamage2Modified = true;
					}
				}

				var5 = player.powers.iterator();

				while (var5.hasNext()) {
					p = (AbstractPower) var5.next();
					tmp[i] = p.atDamageGive(tmp[i], this.damageTypeForTurn);
					if (this.baseDamage2 != (int) tmp[i]) {
						this.isDamage2Modified = true;
					}
				}
			}

			for (i = 0; i < tmp.length; ++i) {
				var5 = player.powers.iterator();

				while (var5.hasNext()) {
					p = (AbstractPower) var5.next();
					tmp[i] = p.atDamageFinalGive(tmp[i], this.damageTypeForTurn);
					if (this.baseDamage2 != (int) tmp[i]) {
						this.isDamage2Modified = true;
					}
				}
			}

			for (i = 0; i < tmp.length; ++i) {
				if (tmp[i] < 0.0F) {
					tmp[i] = 0.0F;
				}
			}

			this.multiDamage = new int[tmp.length];

			for (i = 0; i < tmp.length; ++i) {
				this.multiDamage[i] = MathUtils.floor(tmp[i]);
			}

			this.damage2 = this.multiDamage[0];
		}
		super.applyPowers();
	}

	private void applyPowersToBlock2() {
		this.isBlock2Modified = false;
		float tmp = (float) this.baseBlock2;
		Iterator<AbstractPower> var2 = AbstractDungeon.player.powers.iterator();

		while (var2.hasNext()) {
			AbstractPower p = (AbstractPower) var2.next();
			tmp = p.modifyBlock(tmp);
			if (this.baseBlock2 != MathUtils.floor(tmp)) {
				this.isBlock2Modified = true;
			}
		}

		if (tmp < 0.0F) {
			tmp = 0.0F;
		}

		this.block2 = MathUtils.floor(tmp);
		
	}
	
	private void applyPowersToShield() {
		this.isShieldModified = false;
		float tmp = (float) this.baseShield;
		if (AbstractDungeon.player.hasPower(SlaytheStarCraft2Mod.makeID("PsionicPower"))) {
			SlaytheStarCraft2Mod.logger.info("has psionic");
			tmp = ((PsionicPower) AbstractDungeon.player.getPower(SlaytheStarCraft2Mod.makeID("PsionicPower"))).modifyShield(tmp);
			
			if (this.baseShield != MathUtils.floor(tmp)) {
				this.isShieldModified = true;
			}
		}

		if (tmp < 0.0F) {
			tmp = 0.0F;
		}

		this.shield = MathUtils.floor(tmp);
		
	}
	
	public void calculateCardDamage(AbstractMonster mo) {
		SlaytheStarCraft2Mod.logger.info("child invoked");
		this.applyPowersToBlock2();
		this.applyPowersToShield();
		AbstractPlayer player = AbstractDungeon.player;
		this.isDamage2Modified = false;
		if (!this.isMultiDamage && mo != null) {
			float tmp = (float) this.baseDamage2;

			if (AbstractDungeon.player.hasRelic("WristBlade") && (this.costForTurn == 0 || this.freeToPlayOnce)) {
				tmp += 3.0F;
				if (this.baseDamage2 != (int) tmp) {
					this.isDamage2Modified = true;
				}
			}

			Iterator<AbstractPower> var9 = player.powers.iterator();

			AbstractPower p;
			while (var9.hasNext()) {
				p = (AbstractPower) var9.next();

				tmp = p.atDamageGive(tmp, this.damageTypeForTurn);
				if (this.baseDamage2 != (int) tmp) {
					this.isDamage2Modified = true;
				}
			}

			if (mo != null) {
				for (var9 = mo.powers.iterator(); var9
						.hasNext(); tmp = p.atDamageReceive(tmp, this.damageTypeForTurn)) {
					p = (AbstractPower) var9.next();
				}
			}

			var9 = player.powers.iterator();

			while (var9.hasNext()) {
				p = (AbstractPower) var9.next();
				tmp = p.atDamageFinalGive(tmp, this.damageTypeForTurn);
				if (this.baseDamage2 != (int) tmp) {
					this.isDamage2Modified = true;
				}
			}

			if (mo != null) {
				var9 = mo.powers.iterator();

				while (var9.hasNext()) {
					p = (AbstractPower) var9.next();
					tmp = p.atDamageFinalReceive(tmp, this.damageTypeForTurn);
					if (this.baseDamage2 != (int) tmp) {
						this.isDamage2Modified = true;
					}
				}
			}

			if (tmp < 0.0F) {
				tmp = 0.0F;
			}

			this.damage2 = MathUtils.floor(tmp);
		} else {
			ArrayList<AbstractMonster> m = AbstractDungeon.getCurrRoom().monsters.monsters;
			float[] tmp = new float[m.size()];

			int i;
			for (i = 0; i < tmp.length; ++i) {
				tmp[i] = (float) this.baseDamage2;
			}

			Iterator<AbstractPower> var6;
			AbstractPower p;
			for (i = 0; i < tmp.length; ++i) {
				if (AbstractDungeon.player.hasRelic("WristBlade") && (this.costForTurn == 0 || this.freeToPlayOnce)) {
					tmp[i] += 3.0F;
					if (this.baseDamage2 != (int) tmp[i]) {
						this.isDamage2Modified = true;
					}
				}

				var6 = player.powers.iterator();

				while (var6.hasNext()) {
					p = (AbstractPower) var6.next();
					tmp[i] = p.atDamageGive(tmp[i], this.damageTypeForTurn);
					if (this.baseDamage2 != (int) tmp[i]) {
						this.isDamage2Modified = true;
					}
				}
			}

			for (i = 0; i < tmp.length; ++i) {
				var6 = ((AbstractMonster) m.get(i)).powers.iterator();

				while (var6.hasNext()) {
					p = (AbstractPower) var6.next();
					if (!((AbstractMonster) m.get(i)).isDying && !((AbstractMonster) m.get(i)).isEscaping) {
						tmp[i] = p.atDamageReceive(tmp[i], this.damageTypeForTurn);
					}
				}
			}

			for (i = 0; i < tmp.length; ++i) {
				var6 = player.powers.iterator();

				while (var6.hasNext()) {
					p = (AbstractPower) var6.next();
					tmp[i] = p.atDamageFinalGive(tmp[i], this.damageTypeForTurn);
					if (this.baseDamage2 != (int) tmp[i]) {
						this.isDamage2Modified = true;
					}
				}
			}

			for (i = 0; i < tmp.length; ++i) {
				var6 = ((AbstractMonster) m.get(i)).powers.iterator();

				while (var6.hasNext()) {
					p = (AbstractPower) var6.next();
					if (!((AbstractMonster) m.get(i)).isDying && !((AbstractMonster) m.get(i)).isEscaping) {
						tmp[i] = p.atDamageFinalReceive(tmp[i], this.damageTypeForTurn);
					}
				}
			}

			for (i = 0; i < tmp.length; ++i) {
				if (tmp[i] < 0.0F) {
					tmp[i] = 0.0F;
				}
			}

			this.multiDamage = new int[tmp.length];

			for (i = 0; i < tmp.length; ++i) {
				this.multiDamage[i] = MathUtils.floor(tmp[i]);
			}

			this.damage2 = this.multiDamage[0];
		}
		super.calculateCardDamage(mo);
	}
	
	public static String gameDataUploadHeader() {
		GameDataStringBuilder builder = new GameDataStringBuilder();
		builder.addFieldData("name");
		builder.addFieldData("cardID");
		builder.addFieldData("rawDescription");
		builder.addFieldData("assetURL");
		builder.addFieldData("keywords");
		builder.addFieldData("color");
		builder.addFieldData("type");
		builder.addFieldData("rarity");
		builder.addFieldData("cost");
		builder.addFieldData("target");
		builder.addFieldData("damageType");
		builder.addFieldData("baseDamage");
		builder.addFieldData("baseDamage2");
		builder.addFieldData("baseBlock");
		builder.addFieldData("baseBlock2");
		builder.addFieldData("baseHeal");
		builder.addFieldData("baseDraw");
		builder.addFieldData("baseDiscard");
		builder.addFieldData("baseMagicNumber");
		builder.addFieldData("baseMagicNumber2");
		builder.addFieldData("baseShield");
		builder.addFieldData("isMultiDamage");
		return builder.toString();
	}
	
	public String gameDataUploadData() {
		GameDataStringBuilder builder = new GameDataStringBuilder();
		builder.addFieldData(this.name);
		builder.addFieldData(this.cardID);
		builder.addFieldData(this.rawDescription);
		builder.addFieldData(this.assetUrl);
		builder.addFieldData(Arrays.toString(this.keywords.toArray()));
		builder.addFieldData(this.color.name());
		builder.addFieldData(this.type.name());
		builder.addFieldData(this.rarity.name());
		builder.addFieldData(this.cost);
		builder.addFieldData(this.target.name());
		builder.addFieldData(this.damageType.name());
		builder.addFieldData(this.baseDamage);
		builder.addFieldData(this.baseDamage2);
		builder.addFieldData(this.baseBlock);
		builder.addFieldData(this.baseBlock2);
		builder.addFieldData(this.baseHeal);
		builder.addFieldData(this.baseDraw);
		builder.addFieldData(this.baseDiscard);
		builder.addFieldData(this.baseMagicNumber);
		builder.addFieldData(this.baseMagicNumber2);
		builder.addFieldData(this.baseShield);
		builder.addFieldData(this.isMultiDamage);
		return builder.toString();
	}

}
