public String[] randomDoors(){
		String[] locations = {"north", "east", "south", "west"};
    	ArrayList<String> options = new ArrayList<String>();
    	for (int i = 0; i < locations.length; i++){
    		Point room = getMapRoom();
    		if (getDoors(room, locations[i])){
    			options.add(locations[i]);
    		}
    	}
    	
    	if (!options.isEmpty()){
    		int size = options.size();
	    	String[] randomOrder = new String[size];
	    	for (int i = 0; i < randomOrder.length; i++){
	    		boolean match = false;
	    		int random = gen.randomRange(0, size-1);
	    		String option = options.get(random);
	    		
	    		for (int j = 0; j < randomOrder.length; j++){
	    			if (randomOrder[j] == option){
	   	    			i--;
	    				match = true;
	    				break;
	    			}
	    		}
	    		
	    		if (!match){
	    			randomOrder[i] = option;
	    		}
	    	}
	    	
	    	/*
	    	for (int i = 0; i < randomOrder.length; i++){
	    		println(i + ": " + randomOrder[i]);
	    	}
	    	 */
	
	    	return randomOrder;
    	}
    	return null;
	}