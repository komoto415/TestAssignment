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

    public static void main(String[] args) {
        print("Hello World");
        print("Hello" + "World");
        print("Hello", new byte[] {1, 2, 3});
        print("Hello", new int[] {1, 2, 3});
        print("Hello", Arrays.asList(1, 2, 3));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        print("Hello", map);
        print("Hello" + map);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        print("Hello", set);
        print("Hello" + set);

    }
}
