package starcraft2thespiremod.events;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;
import starcraft2thespiremod.StarCraft2theSpireMod;
import starcraft2thespiremod.relics.HeartofProtoss;

public class ProtossLeaders extends AbstractImageEvent {
	public static final String ID = StarCraft2theSpireMod.makeID("ProtossLeaders");
	private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
	private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
	private static final String[] OPTIONS = eventStrings.OPTIONS;
	private static final String NAME = eventStrings.NAME;
	private static final String IMG = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.ProtossLeaders_IMG);
	
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
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	@Override
	protected void buttonEffect(int button) {
		switch(state) {
		case ENTERING: {
			switch(button) {
			
			}
			((HeartofProtoss) (AbstractDungeon.player.getRelic(StarCraft2theSpireMod.makeID("HeartofProtoss")))).seeLeaders();
			state = State.LEAVING;
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
