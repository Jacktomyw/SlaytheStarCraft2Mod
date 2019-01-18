package slaythestarcraft2mod.variables;

import com.megacrit.cardcrawl.cards.AbstractCard;

import basemod.abstracts.DynamicVariable;
import slaythestarcraft2mod.abstracts.MultipleBasicValueAndShieldCustomCard;

public class Block2Variable extends DynamicVariable {
	
	@Override
	public int baseValue(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).baseBlock2;
	}

	@Override
	public boolean isModified(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).isBlock2Modified;
	}

	@Override
	public String key() {
		return "SlaytheStarCraft2Mod:B2";
	}

	@Override
	public boolean upgraded(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).upgradedBlock2;
	}

	@Override
	public int value(AbstractCard card) {
		return ((MultipleBasicValueAndShieldCustomCard)card).block2;
	}
	
}
