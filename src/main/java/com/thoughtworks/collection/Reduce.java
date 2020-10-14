package com.thoughtworks.collection;

import org.apache.commons.lang3.NotImplementedException;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public double getAverage() {
        //return arrayList.stream().collect(Collectors.averagingInt(Integer::intValue));
        Integer result = arrayList.stream().reduce(0, (sum,current) -> { sum += current; return sum;});

        return new BigDecimal(result).divide(new BigDecimal(arrayList.size())).doubleValue();


    }

    public int getMaxValue() {
        //return arrayList.stream().reduce(0,(max, current)-> { if(max<current){ max = current; } return max;});
        int maxed = arrayList.stream().reduce(0, (max, current) -> max > current ? max : current);
        return arrayList.stream().reduce(0, Integer::max);


    }

    public int getLastOdd() {
        //.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
      return arrayList.stream().filter(integer -> integer % 2 == 1).reduce(0,(odd, current) -> { odd = current; return odd;});

    }
}
