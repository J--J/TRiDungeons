public Point mmDoor(String location){
		String[] locations = {"north", "east", "south", "west"};
		int loc = -1;
		for (int i = 0; i < locations.length; i++){
			if (locations[i].equals(location)){
				loc = i;
				break;
			}
		}
		
		println("Loc: " + loc);
		
		if (loc != -1){
			Point[] coords = gen.getRoom();
			float angle = Minimap.getRotationAngle();
			Point[] rcoords = new Point[coords.length];

			for (int i = 0; i < coords.length; i++){
				rcoords[i] = rotatePoint(coords[i], angle);
			}
			
			Point temp = new Point(627, 135);
			for (int i = 0; i < rcoords.length; i++){
				switch(loc){
					case 0: if (rcoords[i].y < temp.y){
								temp.y = rcoords[i].y;
				   			}
				   			break;
				    case 1: if (rcoords[i].x > temp.x){
						        temp.x = rcoords[i].x;
			   			    }
				   		    break;
				    case 2: if (rcoords[i].y > temp.y){
					   		    temp.y = rcoords[i].y;
					        }
				            break;
				    case 3: if (rcoords[i].x < temp.x){
					   			temp.x = rcoords[i].x;
					        }
				            break;
			    }
		    }
	
			ArrayList<Point> pts = new ArrayList<Point>();
			for (int j = 0; j < rcoords.length; j++){
				switch(loc){
					case 0: case 2: if (Math.abs(rcoords[j].y - temp.y) <= 5){
										pts.add(coords[j]);
									}
									break;
					case 1: case 3: if (Math.abs(rcoords[j].x - temp.x) <= 5){
										pts.add(coords[j]);
									}
									break;
				}
			}
			
			int size = pts.size(),
			    sumX = 0, 
			    sumY = 0;
			
			for (int k = 0; k < size; k++){
				sumX = sumX + pts.get(k).x;
				sumY = sumY + pts.get(k).y;
			}

			//println("SumX: " + sumX);
			//println("SumY: " + sumY);
			//println("Size: " + size);
			
			Point d = new Point(sumX / size, sumY / size);
			return d;
		}	
		
		return null;
	}