package utils;

import java.util.*;

/**
 @author Jeffrey Ng
 @created 2020-05-16 */
public class PythonCollections {
    public static List list(byte[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return l;
    }

    public static List list(short[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return l;
    }

    public static List list(int[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return l;
    }

    public static List list(long[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return l;
    }

    public static List list(float[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return l;
    }

    public static List list(double[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return l;
    }

    public static List list(boolean[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return l;
    }

    public static <T> List<T> list(T... a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return l;
    }

    public static List list(String a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length(); i++) {
            l.add(a.charAt(i));
        }
        return l;
    }

    public static List list(Set a) {
        return new ArrayList(a);
    }

    public static List list(Map a) {
        return new ArrayList(a.keySet());
    }

    // set()
    public static Set set(byte[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return set(l);
    }

    public static Set set(short[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return set(l);
    }

    public static Set set(int[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return set(l);
    }

    public static Set set(long[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return set(l);
    }

    public static Set set(float[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return set(l);
    }

    public static Set set(double[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return set(l);
    }

    public static Set set(boolean[] a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return set(l);
    }

    public static <T> Set<T> set(T... a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        return set(l);
    }

    public static Set set(String a) {
        List l = new ArrayList();
        for (int i = 0; i < a.length(); i++) {
            l.add(a.charAt(i));
        }
        return set(l);
    }

    public static Set set(List a) {
        return new HashSet(a);
    }

    // dict()
    public static Map dict(List<List> a) {
        assert enforceInnerSize(a);
        Map map = new HashMap();
        for (int i = 0; i < a.size(); i++) {
            List inner = a.get(i);
            map.put(inner.get(0), inner.get(1));
        }
        return map;
    }

    private static boolean enforceInnerSize(List<List> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).size() != 2) {
                return false;
            }
        }
        return true;
    }

    public static Map dict(List... a) {
        assert enforceInnerSize(a);
        Map map = new HashMap();
        for (int i = 0; i < a.length; i++) {
            List inner = a[i];
            map.put(inner.get(0), inner.get(1));
        }

        return map;
    }

    private static boolean enforceInnerSize(List... a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].size() != 2) {
                return false;
            }
        }
        return true;
    }

    // zip()
    public static byte[][] zip(byte[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (byte[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        byte[][] zipped = new byte[c][ic];
        for (int i = 0; i < c; i++) {
            byte[] inner = new byte[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static short[][] zip(short[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (short[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        short[][] zipped = new short[c][ic];
        for (int i = 0; i < c; i++) {
            short[] inner = new short[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static int[][] zip(int[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (int[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        int[][] zipped = new int[c][ic];
        for (int i = 0; i < c; i++) {
            int[] inner = new int[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static long[][] zip(long[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (long[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        long[][] zipped = new long[c][ic];
        for (int i = 0; i < c; i++) {
            long[] inner = new long[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static float[][] zip(float[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (float[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        float[][] zipped = new float[c][ic];
        for (int i = 0; i < c; i++) {
            float[] inner = new float[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static double[][] zip(double[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (double[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        double[][] zipped = new double[c][ic];
        for (int i = 0; i < c; i++) {
            double[] inner = new double[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static boolean[][] zip(boolean[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (boolean[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        boolean[][] zipped = new boolean[c][ic];
        for (int i = 0; i < c; i++) {
            boolean[] inner = new boolean[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static String[][] zip(String[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (String[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        String[][] zipped = new String[c][ic];
        for (int i = 0; i < c; i++) {
            String[] inner = new String[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static Object[][] zip(Object[]... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (Object[] l : a) {
            if (l.length < c) {
                c = l.length;
            }
        }
        Object[][] zipped = new Object[c][ic];
        for (int i = 0; i < c; i++) {
            Object[] inner = new Object[ic];
            for (int j = 0; j < ic; j++) {
                inner[j] = a[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static List<List> zip(List... a) {
        int c = a.length == 0 ? 0 : Integer.MAX_VALUE;
        int ic = a.length;
        for (List l : a) {
            if (l.size() < c) {
                c = l.size();
            }
        }
        List<List> zipped = new ArrayList(c);
        for (int i = 0; i < c; i++) {
            List inner = new ArrayList(ic);
            for (List list : a) {
                inner.add(list.get(i));
            }
            zipped.add(Collections.unmodifiableList(inner));
        }

        return zipped;
    }

    public static List<List> enumerate(List a) {
        return enumerate(a, 0);
    }

    public static List<List> enumerate(List a, int o) {
        List<List> enumerated = new ArrayList(a.size());
        for (int i = o; i < a.size() + o; i++) {
            enumerated.add(List.of(i, a.get(i - o)));
        }

        return enumerated;
    }

    public static void main(String[] args) {
        final String me = "Jeffrey";
        int[] intArr1 = new int[] {1, 2, 3};
        int[] intArr2 = new int[] {4, 5, 6};
//        for (int[] tup : zip(intArr1, intArr2)) {
//            int i = tup[0];
//            int j = tup[1];
//            print(i, j);
//        }

        String[] stringArr1 = new String[] {"Jeffrey", "Claudia", "Geoff",};
        String[] stringArr2 = new String[] {"Alana", "Manny", "Robert",};
        String[] stringArr3 = new String[] {"Reed", "Kathryn", "Sergiy",};

        Object[] objectArr1 = new String[] {"Jeffrey", "Claudia", "Geoff",};
        Object[] objectArr2 = new String[] {"Alana", "Manny", "Robert",};
        Object[] objectArr3 = new String[] {"Reed", "Kathryn", "Sergiy",};

//        for (String[] tup : zip(stringArr1, stringArr2)) {
//            String x = tup[0];
//            String y = tup[1];
//            print(x, y);
//        }
//        for (String[] tup : zip(stringArr1, stringArr2, stringArr3)) {
//            String x = tup[0];
//            String y = tup[1];
//            String z = tup[2];
//            print(x, y, z);
//        }
//        for (Object[] tup : zip(objectArr1, objectArr2)) {
//            Object x = tup[0];
//            Object y = tup[1];
//            print(x, y);
//        }
//        for (Object[] tup : zip(objectArr1, objectArr2, objectArr3)) {
//            Object x = tup[0];
//            Object y = tup[1];
//            Object z = tup[2];
//            print(x, y, z);
//        }

        List<String> stringList1 = list(stringArr1);
        List<String> stringList2 = list(stringArr2);
        List<String> stringList3 = list(stringArr3);

//        zip(stringList1, stringList2).forEach(PythonMethods::print);
//        zip(stringList1, stringList2, stringList3).forEach(PythonMethods::print);
//        zip(stringList1, stringList2, integerList).forEach(PythonMethods::print);

        List<Integer> emptyList1 = list();
        List<Integer> emptyList2 = new ArrayList<>();
//        zip(emptyList1, emptyList2).forEach(PythonMethods::print);

        List<List> e = enumerate(stringList1);
//        e.forEach(PythonMethods::print);

        List<List> eWithO = enumerate(stringList1, 2);
//        eWithO.forEach(PythonMethods::print);

        Set<String> stringSet1 = set(stringArr1);
        Set<String> stringSet2 = set(stringList1);
//        print(stringSet1);
//        print(stringSet2);

//        Set<Character> stringToCharSet = set(me);
//        print(stringToCharSet);
//        List<Character> stringToCharList  = list(me);
//        print(stringToCharList);
//        stringToCharList = list(stringToCharSet);
//        print(stringToCharList);

        Set<Integer> intArrToSet = set(intArr1);
//        print(intArrToSet);

        List tup1 = list(me, 4);
        List tup2 = list("Claudia", 1);
        List tup3 = list("Geoff", 2);
        Map<String, Integer> mapWithLists = dict(tup1, tup2, tup3);
//        print(mapWithLists);

        List<List> listOfTups = list(tup1, tup2, tup3);

        Map<String, Integer> mapWithNestLists = dict(listOfTups);
//        print(mapWithNestLists);
    }
}
