package slaythestarcraft2mod.patches.com.megacrit.cardcrawl.vfx.cardManip.CardGlowBorder;

import java.lang.reflect.Field;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.vfx.cardManip.CardGlowBorder;

import basemod.helpers.SuperclassFinder;
import slaythestarcraft2mod.patches.CardTagsEnum;

@SpirePatch(cls="com.megacrit.cardcrawl.vfx.cardManip.CardGlowBorder",method=SpirePatch.CONSTRUCTOR)

public class ChangeOverloadCardGlowBorderToYellow {
	public static void Postfix(CardGlowBorder __instance, AbstractCard c) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		Field f = SuperclassFinder.getSuperclassField(CardGlowBorder.class, "color");
		f.setAccessible(true);
		if(c.hasTag(CardTagsEnum.OVERLOAD)) {
			f.set(__instance, Color.valueOf("EAF044"));
		}
	}
}
