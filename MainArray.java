package ru.sidorenko.jc.TestMainVI;

public final class MainArray {

    int[] getNewArray(final int[] array) {
        if (array == null) return null;
        if (array.length == 0) return array;
        checkFinaleCount(array);

        final int[] newArray;
        final int lengthNewArray;
        final int count;
        final int positionArray;

        count = getFinaleCountPosition(array,4);
        positionArray = count + 1;
        lengthNewArray = array.length - positionArray;
        newArray = new int[lengthNewArray];
        System.arraycopy(array,positionArray,newArray,0,lengthNewArray);
        return newArray;
    }

    boolean checkExistenceNumber(final int[] array){
        if (array == null) return false;
        final int a = getFinaleCountPosition(array,4);
        final int b = getFinaleCountPosition(array, 1);
        if (a == 0 || b == 0) return false;
        return true;
    }

    private void checkFinaleCount(final int[] array){
        final int n = getFinaleCountPosition(array,4);
        if (n == 0) throw new RuntimeException();
    }

    private int getFinaleCountPosition(final int[] array, int count){
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == count) {
                n = i;
            }
        }
        return n;
    }

}
