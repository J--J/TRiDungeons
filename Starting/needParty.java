private boolean needParty(){
		String[] text = NPCChat.getOptions();
		if (text.length > 0)
			for (int i = 0; i < text.length; i++)
				if (text[i].contains("must be in a party"))
					return true;
		return false;
	}