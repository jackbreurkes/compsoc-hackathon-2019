package logic;

import java.util.Set;

public class Choice {
	private String name;
	private Ongoing defaultOption;
	private Ongoing lockedOption;
	private Ongoing currentOption;
	
	public Choice(String name, Ongoing defaultOption, Ongoing lockedOption) {
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	
	public Ongoing getDefaultOption() {
		return defaultOption;
	}
	
	public Ongoing getLockedOption() {
		return lockedOption;
	}
	
	public Ongoing getCurrentOption() {
		return currentOption;
	}
}
