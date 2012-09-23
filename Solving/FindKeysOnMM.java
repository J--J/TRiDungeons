public boolean findKeysOnMM(){
    	Point[] coords = gen.getRoom();
    	Texture[] all = Textures.getAll();
    	boolean found = false;
    	Point P = null;
    	
    	for (int i = 0; i < coords.length; i++){
    		if (!found){
	    		for (int j = 0; j < all.length; j++){
	    			if (all[j].crc16 == itemID){
		    			P = new Point(all[j].x, all[j].y);
		    			if (coords[i].x == P.x && coords[i].y == P.y){
		    				println("Found key");
		    				found = true;
		    				break;
		    			}
	    			}
	    		}
    		}
    	}
    	
    	if (found){
    		P = new Point(P.x + gen.randomRange(-3, 3), P.y + gen.randomRange(-3, 3));
    		Mouse.click(P, 1);
    		gen.waitUntilNotMoving();
    		return true;
    	}
    	
    	return false;
    }