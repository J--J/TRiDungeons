private boolean leaveDungeon(){
		Point DP = new Point(randomRange(617, 638), randomRange(225, 250)); // Dung tab
		Mouse.move(DP);
		if (Timing.waitUptext("Party", 500)){
			Mouse.click(DP, 1);
			sleep(250, 500);
		
			Point LP = new Point(randomRange(555, 728), randomRange(369, 394));
			Mouse.move(LP);
			if (Timing.waitUptext("Leave-party", 500)){
				Mouse.click(LP, 1);
				sleep(500, 1000);

				NPCChat.clickContinue(true);
				
				String[] options = NPCChat.getOptions();
					if (options.length > 0)
						for (int i = 0; i < options.length; i++)
							if (options[i].contains("Yes")){
								NPCChat.selectOption("Yes", true);
								sleep(2000, 3000);
								return true;
							}
			}
		}
		return false;
	}