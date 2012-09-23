private boolean selectComplexity(int complexity){
		TextChar[] text = Text.findCharsInArea(202, 59, 114, 12, true);
		String sentence = "";
		if (text.length > 0){
			for (int i = 0; i < text.length; i++)
				sentence = sentence + String.valueOf(text[i].character);
			println(sentence);
			if (sentence.contains("lex")){
				Point CP = new Point(randomRange(37 + ((complexity-1) * 38), 46 + ((complexity-1) * 38)), randomRange(97, 104));
				Mouse.move(CP);
				if (Timing.waitUptext("complexity", 500)){
					Mouse.click(1);
					sleep(500, 1000);
					Point FP = new Point(randomRange(177, 243), randomRange(322, 344));
					if (randomSelectOptionAt(FP, "Confirm", "Confirm", 3, 1, 1000)){
						sleep(2000, 3000);
						return true;
					}
						
				}
			}
		}
		return false;
	}