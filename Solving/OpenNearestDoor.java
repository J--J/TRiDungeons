public boolean openNearestDoor(){
		//long[][] doorIDs = {FROZEN_DOORS, FROZEN_LOCKED_DOORS, FROZEN_KEY_DOORS};
		int length1 = FROZEN_DOORS.length,
			length2 = FROZEN_LOCKED_DOORS.length,
			length3 = FROZEN_KEY_DOORS.length,
			totalLength = length1 + length2 + length3;

		long[] doorIDs = new long[totalLength];
		for (int i = 0; i < length1; i++){
			doorIDs[i] = FROZEN_DOORS[i];
		}
		for (int i = 0; i < length2; i++){
			doorIDs[i+length1] = FROZEN_LOCKED_DOORS[i];
		}
		for (int i = 0; i < length3; i++){
			doorIDs[i+length1+length2] = FROZEN_KEY_DOORS[i];
		}

		long ID = gen.getNearestID(doorIDs);
		
		for (int i = 0; i < FROZEN_LOCKED_DOORS.length; i++){
			if (ID == FROZEN_LOCKED_DOORS[i]){
				println("locked door");
				if (openLockedDoor()){
					if (openKeyDoor()){
						return true;
					}
				}
			}
		}
		
		for (int i =0; i < FROZEN_KEY_DOORS.length; i++){
			if (ID == FROZEN_KEY_DOORS[i]){
				println("Key door");
				if (openKeyDoor()){
					return true;
				}
			}
			
		}
		
		for (int i = 0; i < FROZEN_DOORS.length; i++){
			if (ID == FROZEN_DOORS[i]){
				println("Normal door");
				if (openDoor()){
					return true;
				}
			}
		}
	
		return false;
	}