 # Find Duplicate Element
---

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    public static int findDuplicate(int[] arr){

        Set<Integer> set = new HashSet<>();

        for(int num : arr){

            if(!set.add(num)){
                return num;
            }

        }

        return -1;
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,4,4,5};

        System.out.println(findDuplicate(arr));

    }
}

---
! - If element cannot be added → it already exists → duplicate found
