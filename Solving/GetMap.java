public boolean getMap(){
		// Checking if the map is open
		Color mapColor = new Color(154, 138, 103);
		Tolerance mapTolerance = new Tolerance(10);
		int mapCount = Screen.findColours(mapColor, 122, 79, 401, 358, mapTolerance).length;
		if (mapCount < 10000){
			Point MP = new Point(gen.randomRange(531, 553), gen.randomRange(181, 201));
			Mouse.move(MP);
			if (Timing.waitUptext("Map", 500)){
				Mouse.click(1);
				int wait = 0;
				while (Screen.findColours(mapColor, 122, 79, 401, 358, mapTolerance).length < 10000 && wait <= 10){
					sleep(50, 100);
					wait++;
				}
				sleep(100, 200);
			}else{
				println("Failed to open the map");
				return false;
			}
		}
		
		// Making a debug image
		smallMap = paint.getMapImage();
	
		// Setting up multiple DTM's 
		DTMPoint DTM_PT_0 = new DTMPoint(new Color(210, 199, 111), new Tolerance(20, 20, 20));
		DTMSubPoint [] DTM_PTS_0 = { new DTMSubPoint(new ColourPoint(new Point(5, -4), new Color( 226, 223, 163)), new Tolerance(20, 20, 20),2), new DTMSubPoint(new ColourPoint(new Point(10, -1), new Color( 200, 185, 114)), new Tolerance(20, 20, 20),2), new DTMSubPoint(new ColourPoint(new Point(5, 6), new Color( 218, 207, 124)), new Tolerance(30, 30, 30),2)};
		DTM unknown = new DTM(DTM_PT_0, DTM_PTS_0);

		DTMPoint DTM_PT_1 = new DTMPoint(new Color(149, 145, 105), new Tolerance(5, 5, 5));
		DTMSubPoint [] DTM_PTS_1 = { new DTMSubPoint(new ColourPoint(new Point(-6, 2), new Color( 51, 39, 21)), new Tolerance(5, 5, 5),1), new DTMSubPoint(new ColourPoint(new Point(1, -6), new Color( 51, 39, 21)), new Tolerance(5, 5, 5),1), new DTMSubPoint(new ColourPoint(new Point(3, 4), new Color( 74, 53, 24)), new Tolerance(5, 5, 5),1)};
		DTM stairs = new DTM(DTM_PT_1, DTM_PTS_1);
		
		DTMPoint DTM_PT_2 = new DTMPoint(new Color(135, 34, 0), new Tolerance(5, 5, 5));
		DTMSubPoint [] DTM_PTS_2 = { new DTMSubPoint(new ColourPoint(new Point(-2, -1), new Color( 135, 34, 0)), new Tolerance(5, 5, 5),1), new DTMSubPoint(new ColourPoint(new Point(0, 2), new Color( 135, 34, 0)), new Tolerance(5, 5, 5),1), new DTMSubPoint(new ColourPoint(new Point(2, -1), new Color( 135, 34, 0)), new Tolerance(5, 5, 5),1)};
		DTM player = new DTM(DTM_PT_2, DTM_PTS_2);
		
		DTMPoint DTM_PT_3 = new DTMPoint(new Color(63, 20, 13), new Tolerance(5, 5, 5));
		DTMSubPoint [] DTM_PTS_3 = { new DTMSubPoint(new ColourPoint(new Point(-5, 3), new Color( 88, 27, 18)), new Tolerance(5, 5, 5),1), new DTMSubPoint(new ColourPoint(new Point(1, 13), new Color( 88, 27, 18)), new Tolerance(5, 5, 5),1), new DTMSubPoint(new ColourPoint(new Point(6, 2), new Color( 102, 31, 21)), new Tolerance(5, 5, 5),1)};
		DTM boss = new DTM(DTM_PT_3, DTM_PTS_3);
		
		DTM[] specifics = {unknown, stairs, player, boss};
		
		// Gathering all boxes were rooms are
		Point firstMapRoom = new Point(199, 156);
		int roomSize = 27, roomDistance = 5;
		int[][] roomsMap = new int[16][];
		for (int i = 0; i <= 3; i++){
	        for (int j = 0; j <= 3; j++){
	        	roomsMap[(i*4) + j] = new int[] {firstMapRoom.x + i * (roomSize + roomDistance),
						        			  	firstMapRoom.y + j * (roomSize + roomDistance),
						        			  	firstMapRoom.x + i * (roomSize + roomDistance) + roomSize,
						        			  	firstMapRoom.y + j * (roomSize + roomDistance) + roomSize};
	        }
        }

		// Checking if there is something special about the room
		Color roomColor = new Color(168, 129, 56);
		Tolerance roomTolerance = new Tolerance(14, 17, 11);
		int check = 0;
		for (int i = 0; i < roomsMap.length; i++){
			int x1 = roomsMap[i][0],y1 = roomsMap[i][1],x2 = roomsMap[i][2],y2 = roomsMap[i][3];
			int identify = 0;
			for (int j = 0; j < specifics.length; j++){
				Point[] detect = DTMs.find_simple(specifics[j], x1, y1, x2, y2);
				if (detect.length > 0){
					identify++;
					check++;
					Point room = new Point(i / 4, i - ((i / 4) + 1));
					switch(j){
						case 0: println("Room (" + room.x + ", " + room.y + ") = Unknown"); break;
						case 1: println("Room (" + room.x + ", " + room.y + ") Stairs room"); break;
						case 2: println("Room (" + room.x + ", " + room.y + ") Player room"); break;
						case 3: println("Room (" + room.x + ", " + room.y + ") Boss room"); break;
					}
				}else{
					if (identify == 0){
						if (j == (specifics.length - 1)){
							ColourPoint[] colors = Screen.findColours(roomColor, x1, y1, x2, y2, roomTolerance);
							if (colors.length > 50){
								check++;
								println("Room " + i + " = Normal room");
							}
						}
					}
				}
			}
		}
		
		if (check > 0){
			Point CM = new Point(gen.randomRange(409, 422), gen.randomRange(69, 82));
			Mouse.move(CM);
			if (Timing.waitUptext("Close", 500)){
				Mouse.click(1);
				sleep(500, 1000);
				return true;
			}
		}
		
		return false;
	}