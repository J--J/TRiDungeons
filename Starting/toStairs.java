private boolean toStairs(){
		int lowest = 2000;
		Point SP = new Point(0, 0);
		ColourPoint[] upstairs = Screen.findColours(new Color(65, 65, 65), 585, 110, 650, 160, new Tolerance(10));
		
		if (upstairs.length > 0){
			for (int i = 0; i < upstairs.length; i++){
				int sum = upstairs[i].point.x + upstairs[i].point.y;
				if (sum < lowest){
					lowest = sum;
					SP = new Point(upstairs[i].point.x + randomRange(-5, 5), upstairs[i].point.y + randomRange(-5, 5));
				}
			}
			
			if (SP != new Point(0, 0)){
				Mouse.move(SP);
				Mouse.click(1);
				waitUntilNotMoving();
				sleep(300, 600);
				return true;
			}
		}
		return false;
	}