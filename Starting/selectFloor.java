private boolean selectFloor(){
		TextChar[] text = Text.findCharsInArea(221, 59, 80, 12, true);
		String sentence = "";
		if (text.length > 0){
			for (int i = 0; i < text.length; i++)
				sentence = sentence + String.valueOf(text[i].character);
			println(sentence);
			if (sentence.contains("oor")){
				Point CP = new Point(randomRange(177, 243), randomRange(322, 344));
				if (randomSelectOptionAt(CP, "Confirm", "Confirm", 3, 1, 1000)){
					sleep(1000, 1500);
					return true;
				}
			}
		}
		return false;
	}