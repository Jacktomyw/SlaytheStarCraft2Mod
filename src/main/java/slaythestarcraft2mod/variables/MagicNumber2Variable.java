package slaythestarcraft2mod.variables;

import com.megacrit.cardcrawl.cards.AbstractCard;

import basemod.abstracts.DynamicVariable;
import slaythestarcraft2mod.abstracts.MultipleBasicValueAndShieldCustomCard;

public class MagicNumber2Variable extends DynamicVariable {
	
	@Override
	public int baseValue(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).baseMagicNumber2;
	}

	@Override
	public boolean isModified(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).isMagicNumber2Modified;
	}

	@Override
	public String key() {
		return "SlaytheStarCraft2Mod:M2";
	}

	@Override
	public boolean upgraded(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).upgradedMagicNumber2;
	}

	@Override
	public int value(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).magicNumber2;
	}

}
