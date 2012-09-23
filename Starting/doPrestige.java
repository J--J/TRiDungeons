private boolean doPrestige(){
		String[] sentence, options;

		Point PP = new Point(randomRange(683, 728), randomRange(489, 506)); // prestige tab
		Mouse.move(PP);
		if (Timing.waitUptext("Reset", 500)){
			Mouse.click(PP, 1);
			sleep(500, 750);
			
			sentence = NPCChat.getOptions();
			if (sentence.length > 0){
				for (int i = 0; i < sentence.length; i++)
					if (sentence[i].contains("rog")){
						NPCChat.clickContinue(true);
						
						options =  NPCChat.getOptions();
						if (options.length > 0)
							for (int j = 0; j < options.length; j++)
								if (options[j].contains("Yes")){
									NPCChat.selectOption("Yes", true);
									sleep(500, 1000);
									return true;
								}
					}
			}
		}
		return false;
	}