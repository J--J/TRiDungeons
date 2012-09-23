public long getNearestID(long[] ids){
		Point MSc = new Point(259, 220);
        ScreenModel[] find = ScreenModels.find(ids);
        ArrayList<Long> idList = new ArrayList<Long>();
        ArrayList<Integer> distList = new ArrayList<Integer>();
        
        if (find.length > 0){
	        for (int i = 0; i < find.length; i++){
                distList.add((int) Math.sqrt(Math.pow(Math.abs(MSc.x - find[i].base_point.x), 2) + Math.pow(Math.abs(MSc.y - find[i].base_point.y), 2)));
                idList.add(find[i].id);
	        }
	        
	        if (!idList.isEmpty() && !distList.isEmpty()){
	            int nearest = 1000;
	            int t = 0;
	            
	            for (int i = 0; i < distList.size(); i++){
	                if (distList.get(i) < nearest){
	                    nearest = distList.get(i);
	                    t = i;
	                }
	            }
	
	            return idList.get(t);
	        }
        }
        
        return -1;
    }