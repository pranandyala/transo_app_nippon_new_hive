package com.transo.nippon.customer.vendor.nein.user.utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataUtils {

    public static String returnStringData(String data) {
        try {
            if (data == null || data.equals("null"))
                return "N/A";
            else
                return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    public static String returnData(String data) {
        try {
            if (data.isEmpty())
                return "0";
            else
                return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static float returnFloatData(String data) {
        try {
            if (data.isEmpty())
                return 0;
            else
                return Float.parseFloat(data);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static float returnIntData(String data) {
        try {
            if (data.isEmpty())
                return 0;
            else
                return Integer.parseInt(data);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String returnStringData(Integer data) {
        try {
            if (data == 0)
                return "0";
            else
                return String.valueOf(data);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static String returnStringData(Float data) {
        try {
            if (data == 0)
                return "0";
            else
                return String.valueOf(data);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static String joinNonBlankStringArray(String[] s, String separator) {
        StringBuilder sb = new StringBuilder();
        if (s != null && s.length > 0) {
            for (String w : s) {
                if (w != null && !w.trim().isEmpty()) {
                    sb.append(w);
                    sb.append(separator);
                }
            }
        }
        return sb.substring(0, sb.length() - 1);// length() - 1 to cut-down last extra separator
    }

    public static String mergeData(String[] strings, String separator) {
        String mergedData = "";
        try {
            StringBuilder sb = new StringBuilder();
            if (strings != null && strings.length > 0) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    mergedData = Stream.of(strings)
                            .filter(s -> s != null && !s.isEmpty() && !s.equals("null"))
                            .collect(Collectors.joining(","));
                } else {
                    for (String w : strings) {
                        if (w != null && !w.trim().isEmpty() && !w.equals("null")) {
                            sb.append(w);
                            sb.append(separator);
                        }
                    }
//                    System.out.println("sb.length()-->" + sb.length());
                    if (sb.length() > 0) {
                        mergedData = sb.substring(0, sb.length() - 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mergedData;
    }

    public static String returnStringDataValue(String data) {
        try {
            if (data == null || data.equals("null"))
                return "";
            else
                return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String returnStringDatas(Float data) {
        try {
            if (data == 0)
                return "";
            else
                return String.valueOf(data);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String returnStringDatas(String data) {
        try {
            if (data.equals("0") || data.equals("0.0"))
                return "";
            else
                return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
