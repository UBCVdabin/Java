package Lectures.CPSC_225;

// Hash
public class Wk_09 {
    public static int Hash(String s){
        int total = 0;

        if(s.length() < 3){
            for(int i = 0; i < s.length(); i++){
                total += (i+1)*(s.charAt(i));
            }
        }
        else{
            for(int i = 0; i < 3; i++){
                total += (i+1)*(s.charAt(i));
            }
        }

        return total;
    }

    public static int Search(String key, String[] hashTable){
        //boolean found = false;

        int hashCode = Hash(key);
        int hashTableIndex = hashCode % hashTable.length;

        if(hashTable[hashTableIndex].equals(key)){
            return hashTableIndex;
        }
        else{
            int j = hashTableIndex + 1;
            while(j != hashTableIndex){
                if(j >= hashTable.length){
                    j = 0;
                }

                if(hashTable[j].equals(key)){
                    return j;
                }
                j++;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        String[] hashTable = new String[10];

        // assume that this string is uq
        String[] a = {"abcde", "acbde", "pqrs", "pacty"};

        for(int i = 0; i < a.length; i++){
            int hashCode = Hash(a[i]);
            int hashTableIndex = hashCode % hashTable.length;

            if(hashTable[hashTableIndex] == null){
                hashTable[hashTableIndex] = a[i];                
            }
            else{
                // hash collision
                int idx = (hashTableIndex + 1) % hashTable.length;

                while (idx != hashTableIndex) {
                    if (hashTable[idx] == null) {
                        hashTable[idx] = a[i];
                        break;
                    }
                    idx = ++idx % hashTable.length;
                }
            }
        }

        for(int i = 0; i < hashTable.length; i++){
            System.out.println(hashTable[i]);
        }


    }
}
