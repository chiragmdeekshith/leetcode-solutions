package medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str.length());
            stringBuilder.append("#");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> stringList = new ArrayList<>();
        char[] array = str.toCharArray();
        String tempstring = "";
        int tempnum = 0;
        for (int i = 0; i < array.length; ) {
            while (array[i] != '#') {
                tempstring += array[i++];
            }
            tempnum = Integer.valueOf(tempstring);
            tempstring = "";
            while (tempnum > 0) {
                tempstring += String.valueOf(array[i++]);
                tempnum--;
            }
            stringList.add(tempstring);
            tempstring = "";
        }
        return stringList;
    }
}
