package lesson28.comparatorexample.comparators;

import lesson28.comparatorexample.Capability;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        //если channelName != сравниваю по нему
        //если channelName == перехожу к fingerPrint

        //если fingerPrint != сравниваю по нему
        //если fingerPrint == перехожу к dateCreated

        //если dateCreated != сравниваю по нему
        //если == обьекты равны (возвращаем 0)

        int compareResult = ComparatorUtils.compareFields(o1.getChannelName(), o2.getChannelName());

        if (compareResult == 0) {
            compareResult = ComparatorUtils.compareFields(o1.getFingerprint(), o2.getFingerprint());

            if (compareResult == 0) {
                compareResult = ComparatorUtils.compareFields(o2.getDateCreated(), o1.getDateCreated());
            }
        }

        return compareResult;
    }

}

