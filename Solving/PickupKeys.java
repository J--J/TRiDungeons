public boolean pickUpKeys(){
		for (int i = 0; i < KEYS.length; i++){
			ScreenModel[] keySearch = ScreenModels.find(KEYS[i]);
			if (keySearch.length > 0){
				gen.fixRightClick();
				Point KP = new Point(keySearch[0].base_point.x + gen.randomRange(-5, 5), keySearch[0].base_point.y + gen.randomRange(-5, 5));
				if (gen.rightClicktAt(KP, "key", 1000)){
					grabbedKeys[i]++;
					gen.waitUntilNotMoving();
					return true;
				}else{
					pickUpKeys();
				}
			}
		}
		return false;
	}