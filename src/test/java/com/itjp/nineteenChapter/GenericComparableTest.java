package com.itjp.nineteenChapter;

import org.junit.Test;

/**
 * @author wangzi
 * @date 18/2/3 上午3:03.
 */
public class GenericComparableTest {
    @Test
    public void testMehtod01() throws Exception{
        System.out.println(GenericComparable.compareTo(new Integer(3),new Integer(5)));
        System.out.println(GenericComparable.compareTo(new String("523"),new String("444")));
    }
}
