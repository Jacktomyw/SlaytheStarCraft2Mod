package slaythestarcraft2mod.variables;

import com.megacrit.cardcrawl.cards.AbstractCard;

import basemod.abstracts.DynamicVariable;
import slaythestarcraft2mod.abstracts.MultipleBasicValueAndShieldCustomCard;

public class Damage2Variable extends DynamicVariable {
	
	@Override
	public int baseValue(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).baseDamage2;
	}

	@Override
	public boolean isModified(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).isDamage2Modified;
	}

	@Override
	public String key() {
		return "SlaytheStarCraft2Mod:D2";
	}

	@Override
	public boolean upgraded(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).upgradedDamage2;
	}

	@Override
	public int value(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).damage2;
	}

}
