public int getTexture(String which){
		String[] options = {"Npc", "Item"};
		int choice = -1;
		for (int i = 0; i < options.length; i++){
			if (options[i].equals(which)){
				choice = i;
				break;
			}
		}
		
		Color color = new Color(0, 0, 0);		
		switch(choice){
			case 0: color = new Color(235, 235, 10); break;
			case 1: color = new Color(230, 0, 0); break;
		}
		
		Point[] coords = getRoom();
		Texture[] all = Textures.getAll();
		
		for (int i = 0; i < coords.length; i++) {
			int x = coords[i].x,
			    y = coords[i].y;
			ColourPoint[] find = Screen.findColours(color, x, y, x, y, new Tolerance(25));
			if (find.length > 0) {
				for (int j = 0; j < all.length; j++){
					double dist = Math.abs(all[j].x - x) + Math.abs(all[j].y - y);
					if (dist < 5){
						return all[j].crc16;
					}
				}
			}
		}
		
		return -1;
	}