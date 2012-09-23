public boolean openLockedDoor(){
		long[] doorIDs = FROZEN_LOCKED_DOORS;
		
		// Checking if we have the right key
		for (int i = 0; i < doorIDs.length; i++){
			ScreenModel[] doorSearch = ScreenModels.find(doorIDs[i]);
			if (doorSearch.length > 0){
				for (int j = 0; j < doorSearch.length; j++){
					println("Detected locked" + keyDoorNames[i] + " door");

					int key = -1;
					switch(i){
						case 3: key = 0; break;
						case 5: key = 1; break;
						case 7: key = 2; break;
						case 9: key = 3; break;
						case 11: key = 4; break;
						case 13: key = 5; break;
						case 15: key = 6; break;
						case 17: key = 7; break;
					}
					
					println(key);
					println(grabbedKeys[5]);
					
					if (key != -1){
						if (grabbedKeys[key] > 0){
							println("We can open it");
							Point DP = new Point(doorSearch[j].points[0]);
							if (gen.randomSelectOptionAt(DP, "Unlock", "Unlock", 0, 1, 1000)){
								return true;
							}else{
								openLockedDoor();
							}
						}else{
							println("We cant open it");
						}
					}
				}
			}
		}

		return false;
	}