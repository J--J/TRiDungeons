public Point getNearestPoint(long id){
		Point MSc = new Point(259, 220);
        ScreenModel[] find = ScreenModels.find(id);
        ArrayList<Integer> distList = new ArrayList<Integer>();
        ArrayList<Point> coordList = new ArrayList<Point>();
        
        if (find.length > 0){
	        for (int i = 0; i < find.length; i++){
                distList.add((int) Math.sqrt(Math.pow(Math.abs(MSc.x - find[i].base_point.x), 2) + Math.pow(Math.abs(MSc.y - find[i].base_point.y), 2)));
                coordList.add(new Point(find[i].base_point.getLocation()));
	        }
	        
	        if (!distList.isEmpty() && !coordList.isEmpty()){
	            int nearest = 1000;
	            int t = 0;
	            
	            for (int i = 0; i < distList.size(); i++){
	                if (distList.get(i) < nearest){
	                    nearest = distList.get(i);
	                    t = i;
	                }
	            }
	
	            return coordList.get(t);
	        }
        }
        
        return null;
    }