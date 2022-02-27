package Contest;

public class CountingWordsWithAGivenPrefix {
    public static int prefixCount(String[] words, String pref) {
        int wordCount = 0;
        for (String word: words){
            int count = 0;
//            System.out.println();
            for(Character wordChar: word.toCharArray()){
                    Character curChar = pref.charAt(count);
//                    System.out.println(curChar+":"+wordChar +":"+count +":"+pref.length());
                    if (!curChar.equals(wordChar)){
                        break;
                    } else {
                        count++;
                    }

                if (count >= pref.length()){
                    wordCount++;

                    break;
                }


            }
        }
        return wordCount;
    }

    public static void main(String[] args) {
//        [        "sxyjellhlh"
        String[] word = new String[]{"sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","vbx","fsi","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","gqira","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh"};
        String pref = "sxyjellhlh";
        System.out.println(prefixCount(word, pref));

        String[] word2 = new String[]{"leetcode","win","loops","success"};
        String pref2 = "code";
        System.out.println(prefixCount(word2, pref2));

        String[] word3 = new String[]{"krbov"};
        String pref3 = "a";
        System.out.println(prefixCount(word3, pref3));

//        [

        String[] word4 = new String[]{"udt","ipbjt","itjbniqf","iwcsd","iv","ezljsxgrv","ixkxv","iwcyrwi","ig","iwrkov","izm","imuusv","iphigkdxxs","g","ildeyvbz","ibywdj","ifctnctguw","ipqnn","td","iscvdjx","ebsy","cl","ik","ik","ionapx","ikhbyzyjq","iuib","ijobcngoob","io","iyvcuronb","ivopadcf","iw","isd","iiv","xzxsfcgz","ikusrhkqc","sywa","iw","my","ivojahjdl","imxyhpttr","ivpdleigq","is","iyxmbyssga","igvjeuxnmf","ircdd","irz","iwjlvbrunc","yefbv","ipcs","wxvhccv","ihythcmyj","iwgvdonax","irxozbyu","vwtees","ithdg","izhlb","kb","ieejxccn","byaf","ixip","cao","ipajauzv","iqxns","iqpjkrpy","iu","puehsn","iqxcavuat","ycqewlca","iaj"};
        String pref4 = "i";
        System.out.println(prefixCount(word4, pref4));
    }
}
