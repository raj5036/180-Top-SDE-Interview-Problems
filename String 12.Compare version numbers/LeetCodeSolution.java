class Solution {
    public int compareVersion(String version1, String version2) {
        int s1 = 0;
        int s2 = 0;
        int i1 = getDotIndex(version1, 0);
        int i2 = getDotIndex(version2, 0);
        
        while(s1 < version1.length() || s2 < version2.length()) {
            int v1 = (s1 < version1.length()) ? Integer.parseInt(version1.substring(s1, i1)) : 0;
            int v2 = (s2 < version2.length()) ? Integer.parseInt(version2.substring(s2, i2)) : 0;
            
            if(v1 != v2) {
                return v1 < v2 ? -1 : 1;
            } 
            
            s1 = i1 + 1;
            s2 = i2 + 1;
            i1 = getDotIndex(version1, s1 + 1);
            i2 = getDotIndex(version2, s2 + 1);
        }
        
        return 0;
    }
    

    private int getDotIndex(String version, int startPos) {
        int i = version.indexOf('.', startPos);
        
        if(i < 0) {
            i = version.length();
        }
        
        return i;
    }
}
    
