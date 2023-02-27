package com.pt.javalib.algorithm.cache;

/**
 * @author : PT
 * @date : create in 2022/12/04 11:33
 * <p></p>
 **/
public class NQueen {

    public int culNQueen(int n) {

        int limit = (1 << n) - 1;
        return doCul(limit, 0, 0, 0);

    }

    private int doCul(int limit, int colLimit, int leftLimit, int rightLimit) {

        if (limit == colLimit) {
            return 1;
        }

        int pos = limit & (~(colLimit | leftLimit | rightLimit));
        int result = 0;
        while (pos != 0) {

            int rightOne = pos & ((~pos) + 1);
            pos -= rightOne;
            result += doCul(limit,
                    colLimit | rightOne,
                    (leftLimit | rightOne) << 1,
                    (rightLimit | rightOne) >> 1);

        }
        return result;

    }
}
