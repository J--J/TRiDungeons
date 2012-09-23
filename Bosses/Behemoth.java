public void behemoth(){
	long bossID = 2081911231L, foodSourceID = 1561638623L;
	Point MSC = new Point(259, 220);

	while (ScreenModels.find(bossID).length > 0){
		ScreenModel[] boss = ScreenModels.find(bossID);
		ScreenModel[] food = ScreenModels.find(foodSourceID);
		if (food.length > 0){
			int foodDist = Math.abs(MSC.x - food[0].base_point.x) + Math.abs(MSC.y - food[0].base_point.y);
			println("Food dist: " + foodDist);
			if (foodDist < 110){
				Point BP = new Point(boss[0].points[0]);
				Mouse.move(BP);
				if (Timing.waitUptext("behemoth", 500)){
					Mouse.click(BP, 1);
					sleep(5000, 10000);
				}
			}else{
				println("We need to move near the food source!");
				Point FP = new Point(food[0].base_point);
				Point FPS = southOf(FP);
				Mouse.move(FPS);
				Mouse.click(1);
				gen.waitUntilNotMoving();
			}
		}
	}
}