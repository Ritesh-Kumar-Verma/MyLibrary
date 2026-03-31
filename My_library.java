import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class My_library {

    public boolean is_perfect(int n) {

        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum == n;
    }


    public static List<List<String>> groupAnagram(String[] str) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : str) {
            int ar[] = new int[26];

            for (char c : s.toCharArray()) {
                ar[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i : ar) {
                sb.append(i);
                sb.append('#');
            }
            if (map.containsKey(sb.toString())) {
                map.get(sb.toString()).add(s);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(sb.toString(), temp);
            }
        }

        return new ArrayList<>(map.values());
    }




    //Hint - Find transpose then reverse
    public static void rotateImage(int ar[][]) {
        int m = ar.length;
        int n = ar[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < n; j++) {

                int t = ar[i][j];
                ar[i][j] = ar[j][i];
                ar[j][i] = t;
            }
        }

        int i = 0;
        int j = n - 1;
        

        while (i < j) {
            for (int k = 0; k < m; k++) {
                int t = ar[k][i];
                ar[k][i] = ar[k][j];
                ar[k][j] = t;
            }
            i++;
            j--;
        }

    }




    public int[][] findAllPair(int [] ar ,int target){

        HashMap<Integer,Integer> map = new HashMap<>();


        List<int[]> result = new ArrayList<>();

        for(int i : ar){
            int k = target - i;
            if(!map.containsKey(k)){
                map.put(i,1);
            }
            else{

                int[] temp = new int[]{i,k};

                result.add(temp);

            }
        }


        int [][] res = new int[result.size()][2];

        for(int i = 0 ; i < result.size() ; i++ ){
            res[i] = result.get(i);
        }
        return res;

    }




    public boolean is_strong(int n) { // sum of factorial of its digit is equal to itself

        int a = n;
        int sum = 0;

        while (a > 0) {
            sum += factorial(a % 10);
            a /= 10;
        }
        if (sum == n)
            return true;

        return false;
    }

    public int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public boolean is_Prime(int n) {
        if (n <= 1)
            return false;
        double sqrt_n = Math.sqrt(n);
        for (int i = 2; i <= sqrt_n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public boolean is_Armstrong(int n) {
        int c = count_digit(n);
        int a = n;
        int s = 0;
        while (a > 0) {
            s += Math.pow(a % 10, c);
            a /= 10;
        }
        if (s == n) {
            return true;
        }
        return false;

    }

    public int count_digit(int a) {

        int c = 0;
        if (a == 0) {
            return 1;
        }

        while (a > 0) {
            c += 1;
            a /= 10;
        }
        return c;
    }

    public int[] bubbleSort(int ar[]) {

        int n = ar.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return ar;
    }

    public int[] selectionSort(int ar[]) {
        int size = ar.length;
        if (size <= 0) {
            return new int[size];
        }

        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (ar[j] < ar[min]) {
                    min = j;
                }
            }
            int temp = ar[i];
            ar[i] = ar[min];
            ar[min] = temp;
        }
        return ar;
    }

    public int[] insertionSortWithReturnArray(int ar[]) {
        int size = ar.length;
        if (size <= 1) {
            return ar;
        }

        for (int i = 1; i < size; i++) {
            int key = ar[i];
            int j = i - 1;
            while (j >= 0 && key < ar[j]) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = key;
        }

        return ar;
    }

    public void insertionSort(int ar[]) {
        int size = ar.length;
        if (size <= 1) {
            return;
        }

        for (int i = 1; i < size; i++) {
            int key = ar[i];
            int j = i;
            while (j > 0 && ar[j - 1] > key) {
                ar[j] = ar[j - 1];
                j--;
            }
            ar[j] = key;
        }
    }

    public int binarySearch(int[] ar, int target, int i, int j) {
        if (i <= j) {
            int mid = (i + j) / 2;
            if (ar[mid] == target) {
                return mid;
            } else if (ar[mid] < target) {
                return binarySearch(ar, target, mid + 1, j);
            } else {
                return binarySearch(ar, target, i, mid - 1);
            }
        } else {
            return -1;
        }
    }

    public void printArray(int ar[]) {
        for (int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printArray(char ar[]){
        for(char i : ar){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public void printArray(int ar[][]){
        for(int i[] : ar){
            printArray(i);
        }
    }

    public void mergeSort(int[] ar, int l, int r) {
        if (l < r) {

            int mid = (l + r) / 2;

            mergeSort(ar, l, mid);
            mergeSort(ar, mid + 1, r);

            merge(ar, l, mid, r);

        }
    }

    public void merge(int ar[], int l, int mid, int r) {
        int left = (mid - l + 1);
        int right = r - mid;

        int[] lar = new int[left];
        int[] rar = new int[right];

        int i, j, k;

        for (i = 0; i < left; i++) {
            lar[i] = ar[l + i];
        }
        for (i = 0; i < right; i++) {
            rar[i] = ar[mid + 1 + i];
        }
        i = 0;
        j = 0;
        k = l;
        while (i < left && j < right) {
            if (lar[i] <= rar[j]) {
                ar[k++] = lar[i++];
            } else {
                ar[k++] = rar[j++];
            }
        }

        while (i < left) {
            ar[k++] = lar[i++];
        }
        while (j < right) {
            ar[k++] = rar[j++];
        }

    }

    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // First pass: move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }

        // Second pass: fill remaining positions with zero
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public void quickSort(int ar[], int low, int high) { // Lomuto partition scheme
        if (low >= high) {
            return;
        }

        int i = low - 1;
        int pivotIndex = high;
        int pivot = ar[pivotIndex];

        for (int j = low; j < high; j++) {
            if (ar[j] < pivot) {
                i++;
                // Swap ar[i] and ar[j]
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        // Place pivot in its correct position
        int temp = ar[i + 1];
        ar[i + 1] = ar[high];
        ar[high] = temp;

        int pi = i + 1;

        quickSort(ar, low, pi - 1);
        quickSort(ar, pi + 1, high);
    }

    public StringBuilder inputTillEnter() {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        System.out.println("Enter value (Press Enter without value to stop): ");

        while (true) {

            String inp = sc.nextLine();
            if (inp.isEmpty()) {
                break;
            }
            input.append(inp);

        }
        sc.close();
        return input;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1; // New length of array with unique elements
    }

    public void reverse(int ar[]) {
        if (ar.length == 0 || ar.length == 1) {
            return;
        }
        int i = 0;
        int j = ar.length - 1;
        while (i < j) {
            int t = ar[i];
            ar[i] = ar[j];
            ar[j] = t;
            j--;
            i++;
        }
    }

    public int[] twoSum(int[] ar, int target) {
        int i = 0, j = ar.length - 1;
        if (ar.length <= 1) {
            return null;
        }
        while (i < j) {
            if (ar[j] + ar[i] > target) {
                j--;
            } else if (ar[j] + ar[i] < target) {
                i++;
            } else {
                break;
            }
        }
        int[] result = { i + 1, j + 1 };
        return result;
    }

    public int firstMissingPositive(int ar[]) {
        int size = ar.length;

        for (int i = 0; i < size; i++) {
            if (ar[i] <= 0) {
                ar[i] = size + 1;
            }
        }

        for (int i = 0; i < size; i++) {
            int val = Math.abs(ar[i]);
            if (val <= size && ar[val - 1] > 0) {
                ar[val - 1] *= -1;
            }
        }

        for (int i = 0; i < size; i++) {
            if (ar[i] > 0) return i + 1;
        }

        return size + 1;

    }

    public List<List<Integer>> tripletSum(int ar[]) { // this program handle duplicate (if we use set then
                                                      // handling duplicate will not be required)
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (ar.length < 3) {
            return result;
        }
        int i;
        int j;
        int k = 0;
        int size = ar.length;
        while (k < size - 2) {
            if (k > 0 && ar[k] == ar[k - 1]) {
                k++;
                continue;
            }

            i = k + 1;
            j = size - 1;
            while (i < j) {
                int sum = ar[i] + ar[j] + ar[k];
                if (sum < 0) {
                    i++;

                } else if (sum > 0) {
                    j--;

                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(ar[k]);
                    list.add(ar[i]);
                    list.add(ar[j]);
                    result.add(list);
                }

                while (i < j && ar[i] == ar[i + 1]) {
                    i++;
                }
                while (i < j && ar[j] == ar[j - 1]) {
                    j--;
                }

                i++;
                j--;

            }

            k++;
        }
        return result;
    }
    public int firstUnique(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i < str.length() ; i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else{
                map.put(str.charAt(i),1);
            }
        }
        for(int i = 0 ; i<str.length() ; i++){
            char c = str.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }

    private int longestConsecutive(int[] ar) {

        int m =0;

        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : ar){
            if(!map.containsKey(i)){
                map.put(i,1);
            }
        }
        for(int i : map.keySet()){
            if(!map.containsKey(i-1)){
                int cur = i;
                int ml = 1;
                while(map.containsKey(cur+1)){
                    cur++;
                    ml++;
                }
                m = ml>m ? ml : m;
            }
        }



        return m;
    }

    public boolean validAnagram(String str1 , String str2){
        int ar1[] = new int[26];
        int ar2[] = new int[26];
        for(int i =0 ; i<str1.length() ; i++){
            ar1[str1.charAt(i)-97]++;
        }
        for(int i=0 ; i<str2.length() ;i++){
            ar2[str2.charAt(i)-97]++;
        }
        if(Arrays.equals(ar1,ar2)){
            return true;
        }

        return false;


    }


    public boolean contain(String s, char c, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }


    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int i = 0 ;
        int m = 0 ;

        for(int j = 0 ; j < s.length() ; j++){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
            m = Math.max(m,j-i+1);

        }
        return m;
    }


    private String longestPalindrome(String s) {

        if(s.length() < 2){
            return s;
        }
        String max = "";
        for(int i = 0 ; i < s.length() ; i++){
            String s1 = check(s,i,i);
            String s2 = check(s,i,i+1);
            max = max.length() > s1.length() ? ( max.length() > s2.length() ? max : s2) : (s1.length() > s2.length() ? (s1):(s2));
        }


        return max;
    }

    public static String check(String s , int i , int j){
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        i++;
        j--;
        return s.substring(i,j+1);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] ar = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                ar[k++] = nums1[i++];
            } else {
                ar[k++] = nums2[j++];
            }
        }
        while (i < m) {
            ar[k++] = nums1[i++];
        }
        while (j < n) {
            ar[k++] = nums2[j++];
        }
        if ((m + n) % 2 == 0) {
            double result = ((double) ar[(m + n) / 2] + (double) ar[(m + n) / 2 - 1]) / 2;
            return result;
        } else {
            double result = (double) (ar[(m + n) / 2]);
            return result;
        }

    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }

        return j + 1; // because j is the last valid index
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Only check factors up to √n
        // and skip even numbers by checking 6k ± 1
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    public void reverse(int ar[],int low, int high){

        int i=low,j=high;

        while(i<j){
            int t = ar[i];
            ar[i++] =ar[j];
            ar[j--] =t;
            
        }

    }
    
    public int [] nextPermutation(int ar[]){

        int size = ar.length;
        if(size<=1){
            return ar;
        }
        int j =size-1;
        while(j>0){
            if(ar[j]>ar[j-1]){
                break;
            }
            j--;
        }
        
        reverse(ar,j,size-1);
        
        int i = j--;
        if(j<0){
            return ar;
        }
        while(i<size){
            if(ar[i]>ar[j]){
                int t=ar[i];
                ar[i] = ar[j];
                ar[j] = t;
                break;
            }
            i++;

        }

        return ar;
    }

     public int maxProfit(int ar[]) {

        if(ar.length <2){
            return 0;
        }

        int maxProfit=0;
        int minPrice = ar[0];

        for(int i = 1 ; i<ar.length ; i++){
            int p = ar[i] - minPrice;
            maxProfit = (p<maxProfit)? maxProfit:p;
            minPrice = (minPrice>ar[i])?ar[i]:minPrice;
        }


        return maxProfit;
    }
    
    
    
    public static int myAtoi(String s) {           // string to integer

        int i = 0;
        int n = s.length();
        int sign = 1;
        if(n == 0){
            return 0;
        }
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i++) == '+') ? 1 : -1;

        }

        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';

            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && d > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + d;
            i++;

        }

        return num * sign;
    }


    //Kadane's Algo
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            // Either extend current subarray or start new from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }



    public int threeClosestSum(int ar[] , int target) {

        int size = ar.length;
        int close = 0;
        int diff = Integer.MAX_VALUE;
        for(int k =  0 ; k < size-2 ; k++ ){
            int i = k+1;
            int j = size -1;
            // System.out.println("running : k=" + k + " i = " + i + "j = " + j);
            while(i<j){
                int sum = ar[i] + ar[j] + ar[k];
                if(sum == target ){
                    return sum;
                }
                else if(Math.abs(target - sum) < diff){
                    close = sum;
                    diff = Math.abs(target - sum);
                }
                if(sum < target ){
                    i++;
                }
                else{
                    j--;
                }
            }
        }
        
        return close;

    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0){
            return head;
        } 
        
        ListNode tail = head;
        int length = 1;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        tail.next = head;

        int newTailPos = length - (k%length) - 1 ;
        ListNode newTail = head;
        while(newTailPos-- > 0){
            newTail = newTail.next;
        }
        head = newTail.next;
        newTail.next = null;



        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        ListNode current = head;

        boolean isDuplicate = false;

        while(current != null){
            isDuplicate = false;
            while(current.next != null && current.val == current.next.val){
                isDuplicate = true;
                current = current.next;
            }
            if(isDuplicate){
                prev.next = current.next;
            }
            else{
                prev = prev.next;
            }
            current = current.next;

        }
        

        return dummy.next;

    }

    public int sortColor(int ar[]) {

        int size = ar.length;
        if (size <= 2) {
            return size;
        }

        int i = 2;
        int j = 2;
        while (j < size) {
            if (ar[j] != ar[i - 2]) {
                ar[i] = ar[j];
                i++;
            }
            j++;
        }

        return i;
    }

    public void swap(int ar[], int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    public boolean isPalindrome(String s) {
        int size = s.length();
        if (size <= 1) {
            return true;
        }
        int i = 0;
        int j = size - 1;
        while (i <= j) {
            boolean c1 = Character.isLetterOrDigit(s.charAt(i));
            
            while(i<j && !c1){
                c1 = Character.isLetterOrDigit(s.charAt(++i));
            }
            
            boolean c2 = Character.isLetterOrDigit(s.charAt(j));
            while(i< j && !c2){
            c2 = Character.isLetterOrDigit(s.charAt(--j));
            }
            
            if (i <= j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        if (i < j) {
            return false;
        }
        return true;
    }
    

    //Below both methods do same work the differnece is that 
    //one uses predefined methods and is shorter
    // the other is implemented using logic 
    //************************************************************************* */
    public String reverseWords(String s) {
        // Step 1: Trim and split
        String[] words = s.trim().split("\\s+");
        
        // Step 2: Reverse words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) reversed.append(" ");
        }

        return reversed.toString();
    }


    
    public String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length()-1;

        while(i>=0){
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            if(i<0){
                break;
            }
            int j = i;
            
            while(s.charAt(i)!=' ' && i>=0){
                i--;
            }

            result.append(s,i+1,j+1);
            result.append(' ');

            
        
        }
        if(result.length()-1 >0){
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();
        

    }

    /****************************************************************************** */


    /******************************************************************************** */
    public static String makeCode(String s) {

        int[] ar = new int[26];

        for (char c : s.toCharArray()) {
            ar[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : ar) {
            sb.append(i);
            sb.append('#');
        }

        return sb.toString();
    }

    public static List<Integer> findAnagram(String s, String p) {
        int strSize = s.length();
        int pSize = p.length();
        p = makeCode(p);
        int i = 0;
        List<String> list = new ArrayList();

        while (i <= strSize - pSize) {

            list.add(makeCode(s.substring(i, i + pSize)));
            i++;
        }
        List<Integer> result = new ArrayList();
        int k = 0;
        for (String j : list) {

            if (j.equals(p)) {
                result.add(k);
            }
            k++;
        }

        return result;
    }
    /*****************************************************************************/






    
}