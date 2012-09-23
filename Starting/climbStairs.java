private boolean climbStairs(){
		ScreenModel[] stairs = ScreenModels.find(stairsID);
		if (stairs.length > 0){
			Point SP = new Point(stairs[0].points[0].x + randomRange(10, 20), stairs[0].points[0].y - randomRange(5, 15));
			if (randomSelectOptionAt(SP, "Jump-down", "Jump-down", 5, 2, 1000)){
				waitUntilNotMoving();
				sleep(500, 1000);
				return true;
			}
		}
		return false;
	}