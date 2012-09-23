public Point[] getPath(Point endRoom){
		Point startRoom = getMapRoom(),
		      tempPos = startRoom,
			  testPos = startRoom;
		String[] directions = {"north", "east", "south", "west"};
		Point[] mod = {new Point(0, -1), new Point(1, 0),
				       new Point(0, 1), new Point(-1, 0)};

		//println("Start room: " + startRoom);
		//println("End room: " + endRoom);
		
		ArrayList<Point> route = new ArrayList<Point>();
		ArrayList<Point> checked = new ArrayList<Point>();
		ArrayList<Integer> doors  = new ArrayList<Integer>();
		checked.add(startRoom);
		while (!(tempPos.x == endRoom.x && tempPos.y == endRoom.y)){
			// Check where the doors are
			doors.clear();
			for (int i = 0; i < directions.length; i++){
				if (getDoors(tempPos, directions[i])){
					doors.add(i);
				}
			}
			
			//sleep(2000);
			//println("Found doors: " + doors.size());
			//println("Checked size: " + checked.size());
			
			// Check if there are any doors
			if (!doors.isEmpty()){
				for (int j = 0; j < doors.size(); j++){
					boolean beenBefore = false,
							stuck = false;
					int direction = doors.get(j);
					
					println("Temp pos: " + tempPos);
					
					testPos = new Point(tempPos.x + mod[direction].x, tempPos.y + mod[direction].y);
					
					if (checked.size() > 0){
						for (int k = 0; k < checked.size(); k++){
							if (checked.get(k).x == testPos.x && checked.get(k).y == testPos.y){
								beenBefore = true;
								if (j == doors.size()-1){
									stuck = true;
									int last = route.size()-1;
									if (last >= 0){
										tempPos = route.get(last-1);
										route.remove(last);
									}else{
										tempPos = startRoom;
										route.clear();
									}
								break;
								}
							}
						}
					}
					
					if (stuck){
						break;
					}
					
					if (beenBefore){
						continue;
					}
					
					tempPos = testPos;
					checked.add(tempPos);
					route.add(tempPos);
					break;
				}
			}else{
				return null;
			}
		}
		
		
		println("The correct path to get from (" + startRoom.x + ", " + startRoom.y + ") to (" + endRoom.x + ", " + endRoom.y + ")");
		Point[] path = route.toArray(new Point[route.size()]);
		
		if (path.length > 0){
			for (int i = 0; i < path.length; i++){
				println(path[i]);
			}
		}
		
		return path;
	}