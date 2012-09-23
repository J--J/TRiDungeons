public void icyBones(){
		long bossID = FROZEN_ICY_BONES;
		
		//gen.walkToMiddle();
		
		ScreenModel[] boss = ScreenModels.find(bossID);
		if (boss.length > 0){
			Point BP = new Point(boss[0].base_point);
			if (gen.randomSelectOptionAt(BP, "Icy bones", "attack", 1, 1, 1000)){
				while(ScreenModels.find(bossID).length > 0){
					sleep(50, 100);
					switch(gen.randomRange(0, 50)){
						case 0: Point PP = ScreenModels.find(bossID)[0].base_point;
								Mouse.move(PP);
								break;
					}
					
				}
			}
		}
	}