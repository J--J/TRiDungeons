public Point rotatePoint(Point P, float angle){
		/*
		 * If you rotate point (px, py) around point (ox, oy) by angle theta you'll get:

			p'x = cos(theta) * (px-ox) - sin(theta) * (py-oy) + ox
			p'y = sin(theta) * (px-ox) + cos(theta) * (py-oy) + oy
        
		 */
		
		Point center = new Point(627, 135);
		double rad = (angle / 360 * 2 * Math.PI);
		double Px = Math.cos(rad) * (P.x - center.x) - Math.sin(rad) * (P.y - center.y); 
		double Py = Math.sin(rad) * (P.x - center.x) + Math.cos(rad) * (P.y - center.y);

		Point PP = new Point(center.x + (int)Px, center.y + (int)Py);
		return PP;

	}