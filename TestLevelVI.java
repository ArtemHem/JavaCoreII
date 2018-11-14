package ru.sidorenko.jc.TestMainVI;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class TestLevelVI {

    private MainArray mainArray;

    private int[] arrayNew;

    private boolean checkArrayTrue;

    @Test
    public void getNewArrayTest1(){
        int[] array = {1,2,4,4,2,3,4,1,7};
        mainArray = new MainArray();
        arrayNew = mainArray.getNewArray(array);
        System.out.println(Arrays.toString(arrayNew));
    }

    @Test
    @Ignore
    public void getNewArrayTest2(){
        int[] array = {1,2,2,3,5,3,5,1,7};
        mainArray = new MainArray();
        arrayNew = mainArray.getNewArray(array);
        System.out.println(Arrays.toString(arrayNew));
    }

    @Test
    public void getNewArrayTest3(){
        int[] array = null;
        mainArray = new MainArray();
        arrayNew = mainArray.getNewArray(array);
        System.out.println(Arrays.toString(arrayNew));
        Assert.assertNull(array);
    }

    @Test(expected = RuntimeException.class)
    public void getNewArrayTest4(){
        int[] array = {1,2,2,0,0,3,5,1,7};
        mainArray = new MainArray();
        arrayNew = mainArray.getNewArray(array);
        System.out.println(Arrays.toString(arrayNew));
    }

    @Test
    public void checkValueArrayTest1(){
        int[] array = {1,2,2,3,5,3,5,1,7};
        mainArray = new MainArray();
        checkArrayTrue = mainArray.checkExistenceNumber(array);
        System.out.println(checkArrayTrue);
    }

    @Test
    public void checkValueArrayTest2(){
        int[] array = {1,2,2,4,5,3,5,1,7};
        mainArray = new MainArray();
        checkArrayTrue = mainArray.checkExistenceNumber(array);
        System.out.println(checkArrayTrue);
    }

    @Test
    public void checkValueArrayTest3(){
        int[] array = {4,2,2,3,5,3,5,4,7};
        mainArray = new MainArray();
        checkArrayTrue = mainArray.checkExistenceNumber(array);
        System.out.println(checkArrayTrue);
        Assert.assertFalse(checkArrayTrue);
    }

    @Test
    @Ignore
    public void checkValueArrayTest4(){
        int[] array = null;
        mainArray = new MainArray();
        checkArrayTrue = mainArray.checkExistenceNumber(array);
        System.out.println(checkArrayTrue);
        Assert.assertNull(array);
    }

}
