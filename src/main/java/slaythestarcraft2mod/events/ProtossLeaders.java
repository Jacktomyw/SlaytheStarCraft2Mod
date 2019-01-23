package slaythestarcraft2mod.events;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.cards.protoss.*;
import slaythestarcraft2mod.characters.Protoss;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.relics.*;

public class ProtossLeaders extends AbstractImageEvent {
	public static final String ID = SlaytheStarCraft2Mod.makeID("ProtossLeaders");
	private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
	private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
	private static final String[] OPTIONS = eventStrings.OPTIONS;
	private static final String NAME = eventStrings.NAME;
	private static final String IMG = ImgInitializer.makePath(ImgInitializer.ProtossLeaders_IMG);
	private final Protoss p = (Protoss) AbstractDungeon.player;
	
	private State state;
	
	private enum State{
		ENTERING,
		LEAVING
	}
	public ProtossLeaders() {
		super(NAME, DESCRIPTIONS[0], IMG);
		
		this.imageEventText.setDialogOption(FontHelper.colorString(OPTIONS[0], "b"));
		this.imageEventText.setDialogOption(FontHelper.colorString(OPTIONS[1], "g")); 
		this.imageEventText.setDialogOption(FontHelper.colorString(OPTIONS[2], "r")); 
		state = State.ENTERING;
		
		if(!p.hasRelic(SlaytheStarCraft2Mod.makeID("HeartofProtoss"))){
			this.body = DESCRIPTIONS[2];
			state = State.LEAVING;
		}else {
			if(p.getRelic(SlaytheStarCraft2Mod.makeID("HeartofProtoss")).usedUp) {
				this.body = DESCRIPTIONS[3];
				state = State.LEAVING;
			}
		}
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	@Override
	protected void buttonEffect(int button) {
		switch(state) {
		case ENTERING: {
			HeartofProtoss r = (HeartofProtoss) p.getRelic(SlaytheStarCraft2Mod.makeID("HeartofProtoss"));
			if(r!=null);
			switch(button) {
			case 0:{
				r.SELECTED_LEADER = "Artanis";
				break;
			}
			case 1:{
				AbstractCard startCard1 = new BladeCharge();
				AbstractCard startCard2 = new ShadowStrike();
				AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(startCard1, (float) (Settings.WIDTH / 2),
						(float) (Settings.HEIGHT / 2)));
				AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(startCard2, (float) (Settings.WIDTH / 2),
						(float) (Settings.HEIGHT / 2)));
				AbstractDungeon.getCurrRoom().spawnRelicAndObtain((float) (Settings.WIDTH / 2),
						(float) (Settings.HEIGHT / 2), new MiniVoidSeeker());
				r.SELECTED_LEADER = "Zeratul";
				break;
			}
			case 2:{
				AbstractCard startCard1 = new OblivionWave();
				AbstractCard startCard2 = new PsionicOppression();
				AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(startCard1, (float) (Settings.WIDTH / 2),
						(float) (Settings.HEIGHT / 2)));
				AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(startCard2, (float) (Settings.WIDTH / 2),
						(float) (Settings.HEIGHT / 2)));
				AbstractDungeon.getCurrRoom().spawnRelicAndObtain((float) (Settings.WIDTH / 2),
						(float) (Settings.HEIGHT / 2), new UpgradingChain());
				r.SELECTED_LEADER = "Alarak";
				break;
			}
			}
			((HeartofProtoss) (p.getRelic(SlaytheStarCraft2Mod.makeID("HeartofProtoss")))).seeLeaders();
			state = State.LEAVING;
			this.imageEventText.updateBodyText(DESCRIPTIONS[1]);
			this.imageEventText.clearAllDialogs();
			this.imageEventText.setDialogOption(OPTIONS[3]);
			AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;
			break;
		}
		case LEAVING: {
			this.imageEventText.clearAllDialogs();
			this.imageEventText.setDialogOption(OPTIONS[3]);
			openMap();
			break;
		}
		}
	}

}
