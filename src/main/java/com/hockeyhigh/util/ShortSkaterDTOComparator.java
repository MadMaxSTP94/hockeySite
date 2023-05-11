package com.hockeyhigh.util;

import com.hockeyhigh.dto.ShortSkaterDTO;

import java.util.Comparator;

public class ShortSkaterDTOComparator implements Comparator<ShortSkaterDTO> {
    @Override
    public int compare(ShortSkaterDTO o1, ShortSkaterDTO o2) {
        Integer o1Total = o1.getTotal();
        Integer o2Total = o2.getTotal();
        return o1Total.compareTo(o2Total);
    }
}
