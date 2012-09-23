private boolean needPrestige(){
		int floor = 0;
		int dunglvl = 42;
		TextChar[] prestige = Text.findCharsInArea(640, 410, 22, 13, true);
		String sentence = "";
		
		if (prestige.length > 0){
			for (int i = 0; i < prestige.length; i++)
				sentence = sentence + String.valueOf(prestige[i].character);
			floor = Integer.parseInt(sentence);
			if (floor != 0 && dunglvl != 0)
				if (floor >= (Math.ceil((double)dunglvl/2)))
					return true;
		}
		return false;
	}