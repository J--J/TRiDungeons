public boolean detectKeys(){
		// Looping through the results to know what keys have been found.
		for (int i = 0; i < KEYS.length; i++){
			ScreenModel[] keySearch = ScreenModels.find(KEYS[i]);
			if (keySearch.length > 0){
				println("Found " + keyNames[i] + " key");
				return true;
			}
		}
		return false;
	}