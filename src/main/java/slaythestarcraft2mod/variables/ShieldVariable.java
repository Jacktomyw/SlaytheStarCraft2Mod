package slaythestarcraft2mod.variables;

import com.megacrit.cardcrawl.cards.AbstractCard;
import slaythestarcraft2mod.abstracts.MultipleBasicValueAndShieldCustomCard;

import basemod.abstracts.DynamicVariable;

public class ShieldVariable extends DynamicVariable {
	
	@Override
	public int baseValue(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).baseShield;
	}

	@Override
	public boolean isModified(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).isShieldModified;
	}

	@Override
	public String key() {
		return "SlaytheStarCraft2Mod:S";
	}

	@Override
	public boolean upgraded(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).upgradedShield;
	}

	@Override
	public int value(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).shield;
	}

}
