package utils;

import java.util.*;

/**
 @author Jeffrey Ng
 @created 2020-05-14 */
public class PythonMethods {

    /*
        toString methods courtesy of Java Array Docs
    */
    private static String toString(byte[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String toString(short[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String toString(int[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String toString(long[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String toString(char[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String toString(float[] a) {
        if (a == null) {
            return "null";
        }

        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String toString(double[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String toString(boolean[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String toString(Object[] a) {
        if (a == null) {
            return "null";
        }

        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private static String deepToString(Object[] a) {
        if (a == null) {
            return "null";
        }

        int bufLen = 20 * a.length;
        if (a.length != 0 && bufLen <= 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuilder buf = new StringBuilder(bufLen);
        deepToString(a, buf, new HashSet<>());
        return buf.toString();
    }

    private static void deepToString(Object[] a, StringBuilder buf, Set<Object[]> dejaVu) {
        if (a == null) {
            buf.append("null");
            return;
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            buf.append("[]");
            return;
        }

        dejaVu.add(a);
//        buf.append('[');
        for (int i = 0; ; i++) {

            Object element = a[i];
            if (element == null) {
                buf.append("null");
            } else {
                Class<?> eClass = element.getClass();

                if (eClass.isArray()) {
                    if (eClass == byte[].class) {
                        buf.append(toString((byte[]) element));
                    } else if (eClass == short[].class) {
                        buf.append(toString((short[]) element));
                    } else if (eClass == int[].class) {
                        buf.append(toString((int[]) element));
                    } else if (eClass == long[].class) {
                        buf.append(toString((long[]) element));
                    } else if (eClass == char[].class) {
                        buf.append(toString((char[]) element));
                    } else if (eClass == float[].class) {
                        buf.append(toString((float[]) element));
                    } else if (eClass == double[].class) {
                        buf.append(toString((double[]) element));
                    } else if (eClass == boolean[].class) {
                        buf.append(toString((boolean[]) element));
                    } else { // element is an array of object references
                        if (dejaVu.contains(element)) {
                            buf.append("[...]");
                        } else {
                            deepToString((Object[]) element, buf, dejaVu);
                        }
                    }
                } else {  // element is non-null and not an array
                    buf.append(element.toString());
                }
            }
            if (i == iMax) {
                break;
            }
            buf.append(", ");
        }
//        buf.append(']');
        dejaVu.remove(a);
    }

    public static void print(Object... obj) {
        StringBuilder sb = new StringBuilder();

        for (Object element : obj) {
            if (element != null) {
                Class<?> eClass = element.getClass();
                if (eClass.isArray()) {
                    Object[] aux = new Object[] {element};
                    String temp = deepToString(aux);
                    sb.append(temp);
                } else {
                    sb.append(element);
                }
            } else {
                sb.append("null");
            }
            sb.append(' ');
        }

        System.out.println(sb.toString().trim());
    }

    public static byte[][] zip(byte[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (byte[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        byte[][] zipped = new byte[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            byte[] inner = new byte[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static short[][] zip(short[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (short[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        short[][] zipped = new short[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            short[] inner = new short[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static int[][] zip(int[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (int[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        int[][] zipped = new int[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            int[] inner = new int[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static long[][] zip(long[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (long[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        long[][] zipped = new long[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            long[] inner = new long[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static float[][] zip(float[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (float[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        float[][] zipped = new float[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            float[] inner = new float[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static double[][] zip(double[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (double[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        double[][] zipped = new double[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            double[] inner = new double[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static boolean[][] zip(boolean[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (boolean[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        boolean[][] zipped = new boolean[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            boolean[] inner = new boolean[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static String[][] zip(String[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (String[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        String[][] zipped = new String[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            String[] inner = new String[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static Object[][] zip(Object[]... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (Object[] l : zipMe) {
            if (l.length < capacity) {
                capacity = l.length;
            }
        }
        Object[][] zipped = new Object[capacity][zipInnerSize];
        for (int i = 0; i < capacity; i++) {
            Object[] inner = new Object[zipInnerSize];
            for (int j = 0; j < zipInnerSize; j++) {
                inner[j] = zipMe[j][i];
            }
            zipped[i] = inner;
        }

        return zipped;
    }

    public static List<List> zip(List... zipMe) {
        int capacity = Integer.MAX_VALUE;
        int zipInnerSize = zipMe.length;
        for (List l : zipMe) {
            if (l.size() < capacity) {
                capacity = l.size();
            }
        }
        List<List> zipped = new ArrayList(capacity);
        for (int i = 0; i < capacity; i++) {
            List inner = new ArrayList(zipInnerSize);
            for (List list : zipMe) {
                inner.add(list.get(i));
            }
            zipped.add(Collections.unmodifiableList(inner));
        }

        return zipped;
    }

    public static List<List> enumerate(List x) {
        return enumerate(x, 0);
    }

    public static List<List> enumerate(List x, int o) {
        List<List> enumerated = new ArrayList(x.size());
        for (int i = o; i < x.size() + o; i++) {
            enumerated.add(List.of(i, x.get(i - o)));
        }

        return enumerated;
    }

    public static void main(String[] args) {
//        print("Hello World");
//        print("Hello" + "World");
//        print("Hello", new byte[] {1, 2, 3});
//        print("Hello", new int[] {1, 2, 3});
//        print("Hello", Arrays.asList(1, 2, 3));
//
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 1);
//        map.put(2, 2);
//        map.put(3, 3);
//        print("Hello", map);
//        print("Hello" + map);
//
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        print("Hello", set);
//        print("Hello" + set);
//
//        int[] intArr1 = new int[] {1, 2, 3};
//        int[] intArr2 = new int[] {4, 5, 6};
//        for (int[] tup : zip(intArr1, intArr2)) {
//            int i = tup[0];
//            int j = tup[1];
//            print(i, j);
//        }
//
//        String[] stringArr1 = new String[] {"Jeffrey", "Claudia", "Geoff",};
//        String[] stringArr2 = new String[] {"Alana", "Manny", "Robert",};
//        String[] stringArr3 = new String[] {"Reed", "Kathryn", "Sergiy",};
//
//        Object[] objectArr1 = new String[] {"Jeffrey", "Claudia", "Geoff",};
//        Object[] objectArr2 = new String[] {"Alana", "Manny", "Robert",};
//        Object[] objectArr3 = new String[] {"Reed", "Kathryn", "Sergiy",};
//
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
//
//        List<String> stringList1 = Arrays.asList(stringArr1);
//        List<String> stringList2 = Arrays.asList(stringArr2);
//        List<String> stringList3 = Arrays.asList(stringArr3);
//        List<Integer> integerList = Arrays.asList(1,2,3);
//
//        zip(stringList1, stringList2).forEach(PythonMethods::print);
//        zip(stringList1, stringList2, stringList3).forEach(PythonMethods::print);
//        zip(stringList1, stringList2, integerList).forEach(PythonMethods::print);
//
//        List<Integer> emptyList1 = new ArrayList<>();
//        List<Integer> emptyList2 = new ArrayList<>();
//        zip(emptyList1, emptyList2).forEach(PythonMethods::print);
//
//        List<List> e = enumerate(stringList1);
//        e.forEach(PythonMethods::print);
//
//        List<List> eWithO = enumerate(stringList1, 2);
//        eWithO.forEach(PythonMethods::print);

    }
}
