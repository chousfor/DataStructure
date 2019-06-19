package cn.structure;

public class Sort {
    //冒泡排序
    public int[] bubbleSort(int[] data){
        int len = data.length;
        if(len<=1){
            return data;
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){
                if(data[j]>data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        return data;
    }
    //减少多余排序次数,判定是否有数据交换
    public int[] bubbleSort2(int[] data){
        int len = data.length;
        if(len<=1){
            return data;
        }
        for(int i=0;i<len;i++){
            boolean flag = false;
            for(int j=0;j<len-i-1;j++){
                if(data[j]>data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        return data;
    }
    //插入排序
    public int[] insertSort(int[] data){
        int len = data.length;
        if(len<=1){
            return data;
        }
        for(int i=1;i<len;i++){
            int value = data[i];
            int j = i-1;
            for(;j>=0;j--){
                if(data[j]>value){
                    data[j+1] = data[j];
                }else{
                    break;
                }
            }
            data[j+1] = value;
        }
        return data;
    }
    //选择排序
    public int[] selectSort(int[] data){
        int len = data.length;
        if(len<=1){
            return data;
        }
        for(int i=0;i<len;i++){
            int minIndex = i;
            for(int j=i;j<len;j++){
                if(data[j]<data[minIndex]){
                    minIndex = j;
                }
            }
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
        return data;
    }
    //希尔排序
    public int[] shellSort(int[] data){
        int len = data.length;
        if(len<=1){
            return data;
        }
//        for()
        return data;
    }
    //归并排序
    public void mergeSort(int[] data){
        int len = data.length;
        mergeSortIter(data,0,len-1);
        for(int i = 0;i<len;i++){
            System.out.println(data[i]);
        }

    }
    public void mergeSortIter(int[] data,int p,int r){
        if(p>=r){
            return;
        }
        int q = p+(r-p)/2;
        mergeSortIter(data,p,q);
        mergeSortIter(data,q+1,r);
        merge(data,p,q,r);
    }
    public void merge(int[] data,int p,int q,int r){
        int i = p;
        int j = q+1;
        int k = 0;
        int[] temp = new int[r-p+1];
        while(i<=q && j<=r){
            if(data[i]<=data[j]){
                temp[k++] = data[i++];
            }else{
                temp[k++] = data[j++];
            }
        }
        int start = i;
        int end = q;
        if(j<=r){
            start = j;
            end = r;
        }
        while(start<=end){
            temp[k++] = data[start++];
        }
        for(i = 0;i<=r-p;++i){
            data[p+i] = temp[i];
        }
    }
    //快速排序
    public void quickSort(int[] data){
        int len = data.length;
        if(len<=1){
            return;
        }
        quickSortInter(data,0,len-1);
        for(int i=0;i<len;i++){
            System.out.println(data[i]);
        }

    }
    public void quickSortInter(int[] data,int p,int r){
        if(p>=r){
            return;
        }
        int q = partition(data,p,r);
        quickSortInter(data,p,q-1);
        quickSortInter(data,q+1,r);

    }
    public int partition(int[] data,int p,int r){
        int pivot = data[r];
        int i = p;
        for(int j=p;j<r;j++){
            if(data[j]<pivot){
                if(i==j){
                    ++i;
                }else{
                    int tmp = data[i];
                    data[i++] = data[j];
                    data[j] = tmp;
                }
            }
        }
        int tmp = data[i];
        data[i] = data[r];
        data[r] = tmp;
        return i;
    }
    //求解第k个最小值
    public int kthSmallest(int[] data,int k){
        if(data== null||data.length<k){
            return -1;
        }
        int partition = partition(data,0,data.length-1);
        while(partition+1!=k){
            if(partition+1<k){
                partition = partition(data,partition+1,data.length-1);

            }else{
                partition = partition(data,0,partition-1);
            }

        }
        return data[partition];
    }
    public int partiton(int[] data,int p,int r){
        int pivot = data[r];
        int i = p;
        for(int j=p;j<r;j++){
            if(data[j]<=pivot){
                swap(data,i,j);
                i++;
            }
        }
        swap(data,i,r);
        return i;
    }
    public void swap(int[] data,int i,int j){
        if(i==j){
            return;
        }
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    //桶排序
    public void bucketSort(int[] data,int bucketSize){
        if(data.length==0){
            return;
        }
        //求取数组最小值和最大值
        int minValue = data[0];
        int maxValue = data[1];
        for(int i=0;i<data.length;i++){
            if(data[i]<minValue){
                minValue = data[i];
            }else if(data[i]>maxValue){
                maxValue = data[i];
            }
        }
        int bucketCount = (maxValue-minValue)/bucketSize+1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];
        for(int i=0;i<data.length;i++){
            int bucketIndex = (data[i]-minValue)/bucketSize;
            if(indexArr[bucketIndex]==buckets[bucketIndex].length){
                ensureCapacity(buckets,bucketIndex);

            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = data[i];
        }
        //对每个桶排序
        int k=0;
        for (int i=0;i<buckets.length;i++){
            if(indexArr[i]==0){
                continue;
            }
            quickSortInter(buckets[i],0,indexArr[i]-1);
            for(int j=0;j<indexArr[i];j++){
                data[k++] = buckets[i][j];
            }
        }


    }
    //对桶扩容
    public void ensureCapacity(int[][] buckets,int bucketIndex){
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length*2];
        for(int j=0;j<tempArr.length;j++){
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    //计数排序
    public void sountingSort(int[] data){
        int len = data.length;
        if(len<=1){
            return;
        }
        int max = data[0];
        for(int i=1;i<len;++i){
            if(max <data[i]){
                max = data[i];
            }
        }
        int[] c = new int[max+1];
        for(int i=0;i<max+1;++i){
            c[i] = 0;
        }
        for(int i=0;i<len;++i){
            c[data[i]]++;
        }
        for(int i=1;i<max+1;++i){
            c[i] = c[i-1]+c[i];
        }
        int[] r = new int[len];
        for(int i=len-1;i>=0;--i){
            int index = c[data[i]]-1;
            r[index] = data[i];
            c[data[i]]--;
        }
        for(int i=0;i<len;++i){
            data[i] = r[i];
        }
    }
    public static void main(String[] args){
        Sort s = new Sort();
        int[] data = {3,7,5,1,9,2};
        s.quickSort(data);
//        for(int i=0;i<result.length;i++){
//            System.out.println(result[i]);
//        }
    }
}
