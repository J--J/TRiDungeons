public void planefreezer(){
		long bossID = FROZEN_PLANEFREEZER_LAKHRAHNAZ;
		
		
		ScreenModel[] boss = ScreenModels.find(bossID);
		if (boss.length > 0){
			Point BP = new Point(boss[0].base_point);
			if (gen.randomSelectOptionAt(BP, "freezer", "Attack", 1, 1, 1000)){
				while (distanceToNPC() < 10){
					sleep(50, 150);
				}
				
				
				
			}
			
		}
		
	}