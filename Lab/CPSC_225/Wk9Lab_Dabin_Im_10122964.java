package Lab.CPSC_225;

import java.util.Scanner;

public class Wk9Lab_Dabin_Im_10122964 {
    public static int GetHashCode(String s){
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

    public static boolean Hash(String key, String[] hashTable){
        if(Search(key, hashTable) != -1){
            System.out.println(key + " already exists in the table.");
            return true;
        }

        int hashCode = GetHashCode(key);
        int hashTableIndex = hashCode % hashTable.length;
        int collissionCount = 0;
        if(hashTable[hashTableIndex] == null){
            hashTable[hashTableIndex] = key;
            System.out.println("While inserting " + key + " collission count: " + collissionCount); 
            return true;               
        }
        else{
            collissionCount++;
            //System.out.println("Hash colission. Table already has data. Item of concern = " + key + ". Linear probing to resolve collission resolution." );
            for(int i = (hashTableIndex + 1) % hashTable.length; i != hashTableIndex; i = (i+1) % hashTable.length){
                if(hashTable[i] == null){
                    hashTable[i] = key;
                    System.out.println("While inserting " + key + " collission count: " + collissionCount);
                    return true;
                }
                else{
                    collissionCount++;
                }
            }

            System.out.println("While inserting " + key + " collission count: " + collissionCount);
            return false;
        }
    }

    public static int Search(String key, String[] hashTable){
        int hashCode = GetHashCode(key);
        int hashTableIndex = hashCode % hashTable.length;

        if(hashTable[hashTableIndex] != null && hashTable[hashTableIndex].equals(key)){
            return hashTableIndex;
        }
        else{
            // linear probing to search the rest of the table
            for(int i = (hashTableIndex + 1) % hashTable.length; i != hashTableIndex; i = (i+1) % hashTable.length){
                if(hashTable[i] != null && hashTable[i].equals(key)){
                    return i;
                }
            }

            return -1;
        }

    }

    public static String[] ReHash(String[] oldHashTable){
        String[] newHashTable = new String[oldHashTable.length * 2];
        for(int i = 0; i < oldHashTable.length; i++){
            Hash(oldHashTable[i], newHashTable);
        }
        return newHashTable;
    }

    public static void Show(String[] hashTable){
        System.out.println("Current Hashtable:");
        for(int i = 0; i < hashTable.length; i++){
            System.out.println(hashTable[i]);
        }
        System.out.println("==============");
    }
    public static void main(String[] args) {
        /*
        * Wk9Lab - ReHash
        * 
        * Start with a hashtable of size 2.
        * Ask user to input a string.
        * Place the string in its appropriate place in the hashtable (using linear 
        * probing to resolve collisions).
        * **Output the whole hash table
        * **Output collission count
        * 
        * If hashtable is full, double the size of the hash table, re-hash values
        * from previous hash table into the new one. Insert new string into the new hash table
        * and continue.
        * 
        * 
        * Program stops when user inputs the string end.
        */
        Scanner s = new Scanner(System.in);
        String[] hashTable = new String[2];

        System.out.print("Enter a string (type end to end this program): ");
        String userInput = s.nextLine();

        while(!userInput.equals("end")){
            if(!Hash(userInput, hashTable)){
                System.out.println("Table full while trying to insert " + userInput + ". Rehashing.");
                hashTable = ReHash(hashTable);
                Hash(userInput, hashTable);
            }
            Show(hashTable);
            System.out.print("Enter a string (type end to end this program): ");
            userInput = s.nextLine();
        }

        s.close();
    }
}




