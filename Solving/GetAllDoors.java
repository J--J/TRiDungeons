public String[] getAllDoors(){
		int[][] data = org.tribot.api.Minimap.getRGBData();
		Color doorColor = new Color(240, 5, 7);
		Point north = new Point(143, 147),
				  east = new Point(172, 175),
				  south = new Point(143, 204),
				  west = new Point(115, 175);
		Point[] directions = {north, east, south, west},
				nextRooms = {new Point(0, -7), new Point(7, 0), new Point(0, 7), new Point(-7, 0)};
		String[] roomNames = {"north", "east", "south", "west"};
		ArrayList<String> found = new ArrayList<String>();

		for (int i = 0; i <= 3; i++){
			for (int j = 0; j <= 3; j++){
				for (int k = 0; k < directions.length; k++){
					// If there is a door the colors match, then check in the direction if there is a door.
					int x = directions[k].x + i*64,
						y = directions[k].y + j*64;
					Color mapColor = new Color(data[x][y]);
					
					if (Screen.coloursMatch(doorColor, mapColor, new Tolerance(10))){
						found.add(roomNames[k]);
						Color nextRoom = new Color(data[x + nextRooms[k].x][y + nextRooms[k].y]);
						if (Screen.coloursMatch(doorColor, nextRoom, new Tolerance(10))){
							println("Found an opened " + roomNames[k] + " door in room (" + i + ", " + j + ")");
						}else{
							println("Found an unopened " + roomNames[k] + " door in room (" + i + ", " + j + ")");
						}
					}
				}
			}
		}
		
		String[] result = found.toArray(new String[found.size()]);
		if (result.length > 0){
			return result;
		}

		return null;
	}