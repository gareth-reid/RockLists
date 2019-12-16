package com.gareth.tests;

import com.gareth.RockCollection;
import com.gareth.Threading;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

//Author: Gareth Reid

public class RockCollectionThreadingTests {
    @Test
    public void ArrayThreadTest(){


        Runnable runnableThreading = new Threading();

        Thread thread = new Thread(runnableThreading);
        thread.start();

    }

}
