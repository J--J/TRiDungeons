private boolean enterDungeon(){
		ScreenModel[] entrance = ScreenModels.find(dungeonID);
		if (entrance.length > 0){
			Point DP = new Point(entrance[0].base_point.x + randomRange(-5, 5), entrance[0].base_point.y + randomRange(-5, 5));
			if (randomSelectOptionAt(DP, "Climb-down", "Climb-down", 5, 2, 1000)){
				waitUntilNotMoving();
				return true;
			}
		}
		return false;
	}