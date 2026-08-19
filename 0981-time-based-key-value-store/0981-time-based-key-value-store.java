class Data {
    int timestamp;
    String value;

    Data(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    HashMap<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {

        List<Data> l = map.get(key);

        if(l == null){
            return "";
        }

        int left = 0;
        int right = l.size() - 1;
        String answer = "";

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(l.get(mid).timestamp <= timestamp){
                answer = l.get(mid).value;
                left = mid+1;
            } else {
                right = mid-1;
            }

        }

        return answer;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */