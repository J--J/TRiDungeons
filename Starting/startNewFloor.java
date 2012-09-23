private boolean startNewFloor(){
		if (leaveDungeon())
			if (toStairs())
				if (climbStairs())
					if (enterDungeon()){
						if (needParty())
							if (makeParty())
								if (!enterDungeon()){
									println("STOP!!");
								}
									
						if (selectFloor())
							if (selectComplexity(4))
								return true;
					}
		return false;
	}