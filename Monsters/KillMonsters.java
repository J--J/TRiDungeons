public void killMonsters() {
		Point MSc = new Point(259, 220);
		for (int i = 0; i < FROZEN_MONSTERS.length; i++) {
			ScreenModel[] monsters = ScreenModels.find(FROZEN_MONSTERS[i]);
			if (monsters.length > 0) {
				println("detected monsters");

				int nearest = 1000;
				int best = -1;
				for (int j = 0; j < monsters.length; j++) {
					int distance = Math.abs(monsters[j].base_point.x - MSc.x)
							+ Math.abs(monsters[j].base_point.y - MSc.y);
					if (distance < nearest) {
						nearest = distance;
						best = j;
					}
				}

				if (best != -1) {
					Point MP = new Point(monsters[best].base_point.x + gen.randomRange(-5, 5), monsters[best].base_point.y + gen.randomRange(-5, 5));
					Mouse.move(MP);
					if (Timing.waitUptext("Attack", 500)){
						Mouse.click(1);

						long temp = monsters[best].id;
						int length = ScreenModels.find(temp).length;
						while (ScreenModels.find(temp).length > (length - 1)) {
							sleep(50, 150);
							switch (gen.randomRange(0, 100)) {
							case 0:
								ScreenModel[] find = ScreenModels.find(temp);
								if (find.length > 0) {
									Point TP = find[0].base_point;
									Mouse.move(TP);
									if (Timing.waitUptext("Attack", 500)) {
										Mouse.click(1);
									}
								}
							}
						}
						break;
					}
				}
			}
		}
	}