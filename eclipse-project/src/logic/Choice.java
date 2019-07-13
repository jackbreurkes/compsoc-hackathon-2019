package logic;

import java.util.Set;

public class Choice {
	private Ongoing defaultOption;
	private Ongoing lockedOption;
	private Ongoing currentOption;
	
	public Choice(Ongoing defaultOption, Ongoing lockedOption) {
		this.defaultOption = defaultOption;
		this.lockedOption = lockedOption;
		currentOption = defaultOption;
	}
	
	public void setOption(Game game, Ongoing option) {
		if (option == defaultOption) {
			currentOption = option;
		}
		else if (option == lockedOption && game.getOngoingActions().contains(lockedOption.getPrerequisite())) {
			currentOption = option;
		}
	}
	
	public Ongoing getCurrentOption() {
		return currentOption;
	}
}
