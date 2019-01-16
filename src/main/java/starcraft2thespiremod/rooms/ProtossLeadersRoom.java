package starcraft2thespiremod.rooms;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.EventHelper;

import basemod.CustomEventRoom;
import starcraft2thespiremod.StarCraft2theSpireMod;
import starcraft2thespiremod.events.ProtossLeaders;

public class ProtossLeadersRoom extends CustomEventRoom{
	public void onPlayerEntry() {
		AbstractDungeon.overlayMenu.proceedButton.hide();
		int eventIndex = 0;
		for(int i = 0;i<AbstractDungeon.eventList.size();i++) {
			if(AbstractDungeon.eventList.get(i).equals(StarCraft2theSpireMod.makeID("ProtossLeaders"))) {
				eventIndex = i;
			}
		}
		String eventName = (String) AbstractDungeon.eventList.remove(eventIndex);
		this.event = EventHelper.getEvent(eventName);
		StarCraft2theSpireMod.logger.info("the index is "+eventIndex+" === the name is "+eventName);
		this.event.onEnterRoom();
	}
}
