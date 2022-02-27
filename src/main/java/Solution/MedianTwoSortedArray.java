package Solution;

public class MedianTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smallerArray;
        if (nums1.length > nums2.length){
            smallerArray = nums2;
            nums2 = nums1;
            nums1 = smallerArray;
        }
        int oneNumStart = 0;
        int twoNumStart = 0;
        int oneNumEnd = nums1.length;
        int twoNumEnd = nums2.length;

        boolean isEven = (oneNumEnd + twoNumEnd) % 2 == 0;

        int oneNumMedian = nums1.length / 2;
        int twoNumMedian = nums2.length / 2;

        if (oneNumEnd == 0){
            return medianSelector(nums2[twoNumMedian - 1], nums2[twoNumMedian], isEven);
        }

        while (oneNumEnd - oneNumStart > 2 && twoNumEnd - twoNumStart > 2) {
            System.out.println();
            System.out.println(oneNumStart + ":" + oneNumMedian + ":" + oneNumEnd);
            System.out.println(twoNumStart + ":" + twoNumMedian + ":" + twoNumEnd);
            if (nums1[oneNumMedian] > nums2[twoNumMedian]) {
                oneNumEnd = oneNumMedian;
                twoNumStart = twoNumMedian;
            } else {
                oneNumStart = oneNumMedian;
                twoNumEnd = twoNumMedian;
            }
            oneNumMedian = oneNumStart + (oneNumEnd - oneNumStart) / 2;
            twoNumMedian = twoNumStart + (twoNumEnd - twoNumStart) / 2;
        }

        if (oneNumEnd - oneNumStart <= 2){
            if (twoNumEnd - twoNumStart <= 2){
                int[] firstArray = new int[oneNumEnd - oneNumStart];
                int[] secondArray = new int[twoNumEnd - twoNumStart];
                int count = 0;
                for (int i = oneNumStart; i < oneNumEnd; i++){
                    firstArray[count] = nums1[i];
                    count++;
                }
                count = 0;
                for (int i = twoNumStart; i < twoNumEnd; i++){
                    secondArray[count] = nums2[i];
                    count++;
                }

                return findMedianSortedArraysON(firstArray, secondArray);
            } else {
                System.out.println(nums1[oneNumStart] + ":" + nums2[twoNumMedian] + ":" + nums2[twoNumMedian + 1]);
                if (nums2[twoNumMedian] <= nums1[oneNumStart]){
                    if (isEven){
                        if (nums2[twoNumMedian + 1] <= nums1[oneNumStart]){
                            return medianSelector(nums2[twoNumMedian], nums2[twoNumMedian + 1], true);
                        } else {
                            return medianSelector(nums2[twoNumMedian], nums1[oneNumStart], true);
                        }
                    } else {
                        return Math.min(nums2[twoNumMedian + 1], nums1[oneNumStart]);
                    }
                } else {
                    if (isEven){
                        if (nums2[twoNumMedian - 1] >= nums1[oneNumStart]){
                            return medianSelector(nums2[twoNumMedian], nums2[twoNumMedian - 1], true);
                        } else {
                            return medianSelector(nums2[twoNumMedian], nums1[oneNumStart], true);
                        }
                    } else {
//                        System.out.println(nums2[twoNumMedian - 1], nums1[oneNumStart]);
                        return Math.max(nums2[twoNumMedian], nums1[oneNumStart]);
                    }
                }
            }
        }

        System.out.println(oneNumStart + ":" + oneNumEnd);
//        System.out.println();
        System.out.println(twoNumStart + ":" + twoNumEnd);
//        System.out.println();


        int numOneLen = nums1.length;
        int numTwoLen = nums2.length;
        return 0;
    }

//    private double sort

    private double findMedianBetweenThree(int first, int second, int third){
        int bigger = Math.max(first, second);
        if (bigger > third){
            return third;
        } else {
            return bigger;
        }
    }

    private double medianSelector(int firstMedian, int secondMedian, boolean isEven){
        if (isEven){
            return ((double) firstMedian + (double) secondMedian) / 2.0;
        } else {
            return secondMedian;
        }
    }

    public double findMedianSortedArraysON(int[] nums1, int[] nums2) {
        int numOneLen = nums1.length;
        int numTwoLen = nums2.length;

        int medianLen = (numOneLen + numTwoLen) / 2;
        boolean isEven = (numOneLen + numTwoLen) % 2 == 0;

        int oneIndex = 0;
        int twoIndex = 0;
        int medianIndex = 0;

        int medianValuePrev = 0;
        int medianValue = 0;

        while (oneIndex < numOneLen || twoIndex < numTwoLen) {
            if (medianIndex == (medianLen + 1)) {
                break;
            }
            medianIndex++;
            medianValuePrev = medianValue;
            if (oneIndex >= numOneLen) {
                medianValue = nums2[twoIndex];
                twoIndex++;
            } else if (twoIndex >= numTwoLen) {
                medianValue = nums1[oneIndex];
                oneIndex++;
            } else {
                int curValOne = nums1[oneIndex];
                int curValTwo = nums2[twoIndex];
                if (curValOne < curValTwo) {
                    oneIndex++;
                    medianValue = curValOne;
                } else {
                    twoIndex++;
                    medianValue = curValTwo;
                }
            }
        }

        if (isEven) {
            double curDouble = ((double) medianValue + (double) medianValuePrev);
            return curDouble / 2.0;
        } else {
            return medianValue;
        }
    }

//    https://www.interviewbit.com/blog/median-of-two-sorted-arrays/
    public double findMedianSortedArraysInterviewBit(int A[], int B[],
                         int n, int m)
    {
        int i = 0;
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        if ((m + n) % 2 == 1)
        {
            for(count = 0;
                count <= (n + m) / 2;
                count++)
            {
                if (i != n && j != m)
                {
                    m1 = (A[i] > B[j]) ?
                            B[j++] : A[i++];
                }
                else if (i < n)
                {
                    m1 = A[i++];
                }
                else
                {
                    m1 = B[j++];
                }
            }
            return m1;
        }
        else
        {
            for(count = 0;
                count <= (n + m) / 2;
                count++)
            {
                m2 = m1;
                if (i != n && j != m)
                {
                    m1 = (A[i] > B[j]) ?
                            B[j++] : A[i++];
                }
                else if (i < n)
                {
                    m1 = A[i++];
                }
                else
                {
                    m1 = B[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 4, 5};
//        int[] nums2 = {6, 7, 8, 9, 10, 11, 12, 13};
//
//        MedianTwoSortedArray mtsa = new MedianTwoSortedArray();
//        double result = mtsa.findMedianSortedArraysON(nums1, nums2);
//        System.out.println(result);
//
//
//        int[] nums1Two = {1, 3};
//        int[] nums2Two = {2};
//
//        double resultTwo = mtsa.findMedianSortedArraysON(nums1Two, nums2Two);
//        System.out.println(resultTwo);

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {4, 5, 6, 7, 8};
//        {1, 2, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9}

        MedianTwoSortedArray mtsa = new MedianTwoSortedArray();
        double result = mtsa.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);


//        int[] nums1Two = {1, 3};
//        int[] nums2Two = {2};
//
//        double resultTwo = mtsa.findMedianSortedArraysON(nums1Two, nums2Two);
//        System.out.println(resultTwo);

//        {1,2,3,4,5}
//        {6,7,8,9,10}

//        {1,2,3,4,5}
//        {1,2,3,4,5}
    }
}
