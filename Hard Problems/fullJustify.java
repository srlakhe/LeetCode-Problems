class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        int totalLength = 0;
        int nwords = 0;
        int len = 0;
        while(i < words.length) {
            j = i;
            len = -1;
            while(i < words.length && len +1+ words[i].length() <= maxWidth) {
                totalLength += words[i].length();
                nwords++;
                len += (words[i].length() + 1);
                i++;
            }
            int remspace = maxWidth - totalLength;
            if(i == words.length) {
                for(int k = j; k < i; k++) {
                    if(k != j)
                        sb.append(' ');
                    sb.append(words[k]);
                }
                while(sb.length() < maxWidth){
                    sb.append(' ');
                }
                result.add(sb.toString());
                return result;
            }
            if(nwords == 1) {
                sb.append(words[j]);
                for(int k = 0; k < remspace; k++)
                    sb.append(' ');
            } else {
                int wordspace = remspace / (nwords-1);
                int addspace = remspace % (nwords-1);
                while(j < i) {
                    sb.append(words[j]);
                    j++;
                    if(j != i) {
                        for(int k = 0; k < wordspace; k++)
                            sb.append(' ');
                        if(addspace != 0) {
                            sb.append(' ');
                            addspace--;
                        }
                    }
                }
            }
            result.add(sb.toString());
            sb.setLength(0);
            nwords = 0;
            totalLength = 0;
        }
        return result;
    }
}
