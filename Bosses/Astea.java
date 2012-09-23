public void astea(){
		long bossID = FROZEN_ASTEA_FROSTWEB,
			 spider = 1253199262L,
			 ice = FROZEN_ASTEA_ICE;
		
		ScreenModel[] boss = ScreenModels.find(bossID);
		if (boss.length > 0){
			Point BP = new Point(boss[0].base_point);
			if (gen.randomSelectOptionAt(BP, "Astea", "Attack", 2, 1, 1000)){
				while(ScreenModels.find(bossID).length > 0){
					
					// Check if astea is praying melee
					while (!detectProtection("melee") && ScreenModels.find(ice).length == 0 && ScreenModels.find(bossID).length > 0){
						println("sleeping");
						sleep(50, 150);
					}
					
					ScreenModel[] iceblock = ScreenModels.find(ice);
					if (iceblock.length > 0){
						println("We need to attack astea again");
					}
					
					if (detectProtection("melee")){
						Point P = gen.getNearestPoint(spider);
						println("P: " + P);
						if (P != null){
							if (gen.randomSelectOptionAt(BP, "spider", "Attack", 1, 0, 1000)){
								int length = ScreenModels.find(spider).length;
								long max = System.currentTimeMillis() + gen.randomRange(4000, 6000);
								while (ScreenModels.find(spider).length == length && System.currentTimeMillis() < max && detectProtection("melee")){
									println("Astea is praying, killing spiders");
									sleep(50, 150);
								}
							}
						}
					}
				}
			}
		}
	}