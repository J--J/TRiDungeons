public boolean walkToMonsters(){
    	Point[] coords = gen.getRoom();
    	Texture[] all = Textures.getAll();
    	ArrayList<Point> npcList = new ArrayList<Point>();
    	Point MMc = new Point(627, 135);

    	for (int i = 0; i < coords.length; i++){
    		for (int j = 0; j < all.length; j++){
    			if (all[j].crc16 == npcID){
	    			Point P = new Point(all[j].x, all[j].y);
	    			if (coords[i].x == P.x && coords[i].y == P.y){
	    				println("Found npc");
	    				npcList.add(P);
	    				break;
	    			}
    			}
    		}
    	}
    	
    	if (!npcList.isEmpty()){
    		Point[] pts = npcList.toArray(new Point[npcList.size()]);
    		Point K = gen.getNearestMM(pts);
    		
    		double dist = Math.abs(K.x - MMc.x) + Math.abs(K.y - MMc.y);
    		if (dist > 15){
	    		Mouse.click(K, 1);
	    		gen.waitUntilNotMoving();
    		}
    		
    		return true;
    	}
    	
    	return false;
    }