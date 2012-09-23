public boolean findMonsters(){
		Point[] coords = gen.getRoom();
    	Texture[] all = Textures.getAll();

    	for (int i = 0; i < coords.length; i++){
    		for (int j = 0; j < all.length; j++){
    			if (all[j].crc16 == npcID){
	    			Point P = new Point(all[j].x, all[j].y);
	    			if (coords[i].x == P.x && coords[i].y == P.y){
	    				println("Found npc");
	    				return true;
	    			}
    			}
    		}
    	}
    	
    	return false;
	}