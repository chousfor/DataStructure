package cn.structure;

public class BinarySearch {
    public int bsearch(int[] data,int value){
        int len = data.length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(data[mid]==value){
                return mid;
            }else if(data[mid]<value){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    //查找第一个等于给定值的元素
    public int bsearch1(int[] data,int value){
        int len = data.length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(data[mid]>=value){
                high = mid-1;
            }else if(data[mid]<value){
                low = mid+1;
            }else{
                if((mid==0)||(data[mid-1]!=value)){
                    return mid;
                }else{
                    high = mid-1;
                }
            }

        }
        return -1;

    }
    //查找最后一个值等于给定值的元素
    public int bsearch2(int[] data,int value){
        int len = data.length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(data[mid]>value){
                high = mid-1;
            }else if(data[mid]<value){
                low = mid+1;
            }else{
                if((mid==len-1)||(data[mid+1]!=value)){
                    return mid;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
    //查找第一个大于等于给定值的元素
    public int bsearch3(int[] data,int value){
        int len = data.length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = low+((high-low))>>1;
            if(data[mid]>=value){
                if((mid==0)||(data[mid-1]<value)){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    //查找最后一个小于等于给定值的元素
    public int bsearch4(int[] data,int value){
        int len = data.length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(data[mid]>value){
                high = mid-1;
            }else{
                if((mid==len-1)||(data[mid+1]>value)){
                    return mid;
                }else{
                    low = mid+1;
                }
            }

        }
        return -1;
    }
}
