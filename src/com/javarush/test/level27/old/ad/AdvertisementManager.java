package com.javarush.test.level27.old.ad;

import com.javarush.test.level27.old.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.StrictMath.pow;

/**
 * Created by Dmitry on 19.02.2016.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> advideos = storage.list();
        List<Advertisement> actualAdvideos = new ArrayList<>();    // исходный лист с положительным hits
        for (Advertisement adv : advideos){
            if (adv.getHits() > 0)
                actualAdvideos.add(adv);
        }
        int size = actualAdvideos.size();
        // лист маска для исходного листа (по нему мы включаем или нет в результат элементы исходного 1 - да, 0 - нет)
        List<Integer> mask = new ArrayList<>(size + 1);
        // обнулим для начала
        for (int i = 0; i < size + 1; i++) {
            mask.add(i, 0);
        }
        // лист для результата выбора роликов
        List<Advertisement> listResult;
        // вызов нашей чудо функции
        listResult = subSet(actualAdvideos, size, mask, 0);
        if (listResult.isEmpty())
            throw new NoVideoAvailableException();
        Comparator<Advertisement> advComparator = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long sum1 = o1.getAmountPerOneDisplaying();
                long sum2 = o2.getAmountPerOneDisplaying();
                long sumSec1 = o1.getDuration() !=0 ? sum1*1000/o1.getDuration() : 0L;
                long sumSec2 = o2.getDuration() !=0 ? sum2*1000/o2.getDuration() : 0L;
                if (sum1 != sum2)
                    return Long.compare(sum2, sum1);
                if (sumSec1 != sumSec2)
                    return Long.compare(sumSec1, sumSec2);
                return 0;
            }
        };
        Collections.sort(listResult, advComparator);
        for (Advertisement adv : listResult)
            ConsoleHelper.writeMessage(adv.getName() + " is displaying... " + adv.getAmountPerOneDisplaying() + ", " + (adv.getDuration() !=0 ? adv.getAmountPerOneDisplaying()*1000/adv.getDuration() : 0));
        //2.6 Для каждого показанного рекламного ролика пересчитать его данные вызвав метод revalidate() у объекта класса Advertisement.
        for (Advertisement adv : listResult)
            adv.revalidate();
    }
    private List<Advertisement> subSet(List<Advertisement> adv, int size, List<Integer> mask, int curPos){
        // curPos - текущая добавляемая позиция в листе mask
        // всего вариантов 2^n от размера исходного массива
        List<List<Advertisement>> listOfSets = new ArrayList<>();
        // список для создания подсписка
        List<Advertisement> tmpList = new ArrayList<>();
        if (curPos != pow(2, size)) {
            // инкрементируем mask (эмуляция прибавления единицы в двоичной системе):
            for (int i = 0; i < curPos; i++) {
                if (mask.get(i) == 0) {
                    mask.set(i, 1);
                    break;
                } else {
                    mask.set(i, 0);
                }
                if (i == curPos - 1) {
                    for (int j = 0; j < curPos; j++) {
                        mask.set(i, 0);
                    }
                    mask.set(curPos, 1);
                }
            }
            // накладываем маску на исходный (создаём подсписок)
            int time = 0;
            for (int i = 0; i < size; i++) {
                if (mask.get(i) != 0) {
                    tmpList.add(adv.get(i));
                    time += adv.get(i).getDuration();
                } else {
                    //skip element
                }
            }
            // если превышено время - не добавлять в  listOfSets
            if (time <= timeSeconds)
                listOfSets.add(tmpList);
            curPos++;
            listOfSets.add(subSet(adv, size, mask, curPos));
            // сортировка
            Collections.sort(listOfSets, new Comparator<List<Advertisement>>()
            {
                @Override
                public int compare(List<Advertisement> o1, List<Advertisement> o2)
                {
                    if (o1 != null && o2 != null)
                    {
                        int time1 = 0;
                        int time2 = 0;
                        long sum1 = 0L;
                        long sum2 = 0L;
                        for (Advertisement a1 : o1)
                        {
                            time1 += a1.getDuration();
                            sum1 += a1.getAmountPerOneDisplaying();
                        }
                        for (Advertisement a2 : o2)
                        {
                            time1 += a2.getDuration();
                            sum1 += a2.getAmountPerOneDisplaying();
                        }
                        if (sum1 != sum2)
                            return Long.compare(sum2, sum1);
                        if (time1 != time2)
                            return Integer.compare(time2, time1);
                        if (o1.size() != o2.size())
                            return Integer.compare(o1.size(), o2.size());
                    }
                    return 0;
                }
            });
        }
        return listOfSets.size() != 0 ? listOfSets.get(0) : null;
    }
}