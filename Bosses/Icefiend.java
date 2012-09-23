public void icefiend(){
		long bossID = FROZEN_LUMINESCENT_ICEFIEND,
			 particle = FROZEN_ICEFIEND_ICE_PARTICLE,
			 frozen = FROZEN_ICEFIEND_IN_ICE;
		
		//gen.walkToMiddle();
		
		ScreenModel[] boss = ScreenModels.find(bossID);
		if (boss.length > 0){
			Point BP = new Point(boss[0].base_point);
			if (gen.randomSelectOptionAt(BP, "icefiend", "Attack", 1, 1, 1000)){
				while(ScreenModels.find(particle).length < 3 && ScreenModels.find(frozen).length == 0){
					println("sleeping");
					sleep(50, 100);
				}
				
				while (gen.waitFindID(particle, 100) || gen.waitFindID(frozen, 100)){
					particleRun();
				}
			}
		}
	}