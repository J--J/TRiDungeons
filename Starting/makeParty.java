private boolean makeParty(){
		NPCChat.clickContinue(true);
		String name = NPCChat.getName();
		if (name.contains("start")){
			String[] options = NPCChat.getOptions();
			if (options.length > 0)
				for (int i = 0; i < options.length; i++)
					if (options[i].contains("Yes")){
						NPCChat.selectOption("Yes", true);
						sleep(1000, 1500);
						return true;
					}
		}
		return false;
	}