public Point getMapRoom(){
		Point P = TPS.getRelativePosition();
		//println("Relative position: " + P);
		
		Point firstRoom = new Point(-140, -110);
		int roomSize = 60, roomDistance = 4;
		for (int i = 0; i <= 3; i++){
			for (int j = 0; j <= 3; j++){
				int[] coords = { firstRoom.x + i * (roomSize + roomDistance),
						         firstRoom.y + j * (roomSize + roomDistance),
						         firstRoom.x + i * (roomSize + roomDistance) + roomSize,
						         firstRoom.y + j * (roomSize + roomDistance) + roomSize };
				if (P.x >= coords[0]){
					if (P.x <= coords[2]){
						if (P.y >= coords[1]){
							if (P.y <= coords[3]){
								//int room = (i * 4 + j);
								//println("Room: " + room);
								return new Point(i, j);
							}
						}
					}
				
				}
			}
		}
		
		return null;
	}