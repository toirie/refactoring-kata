package com.odde;

import com.sun.tools.javac.code.Attribute;

import java.util.Arrays;
import java.util.List;

public class Product {
    public static final int SIZE_NOT_APPLICABLE = -1;
    private String code;
    private int color;
    private int size;
    private double price;
    private String currency;

    public Product(String code, int color, int size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"code\": \"");
        sb.append(code);
        sb.append("\", ");
        sb.append("\"color\": \"");
        sb.append(Color.getColor(color));
        sb.append("\", ");
        if (size != SIZE_NOT_APPLICABLE) {
            sb.append("\"size\": \"");
            sb.append(Size.getSize(size));
            sb.append("\", ");
        }

        sb.append("\"price\": ");
        sb.append(price);
        sb.append(", ");
        sb.append("\"currency\": \"");
        sb.append(currency);
        sb.append("\"}, ");
        return sb.toString();
    }

    private enum Size {
        XS(1, "XS"),
        S(2, "S"),
        M(3, "M"),
        L(4, "L"),
        XL(5, "XL"),
        XXL(6, "XXL"),
        INVALID_SIZE(0, "Invalid Size");

        private int id;
        private String value;
        private static List<Size> sizes;

        static {
            sizes = Arrays.asList(XS, S, M, L, XL, XXL);
        }

        Size(int id, String value) {
            this.id = id;
            this.value = value;
        }

        public static String getSize(int id) {
            return sizes.stream().filter(size -> size.getId() == id).findAny().orElse(INVALID_SIZE).getValue();
        }

        public int getId() {
            return id;
        }

        public String getValue() {
            return value;
        }
    }

    private enum Color {
        BLUE(1, "blue"),
        RED(2, "red"),
        YELLOW(3, "yellow"),
        NO_COLOR(0, "no color");

        private int id;
        private String value;
        private static List<Color> colors;

        static {
            colors = Arrays.asList(BLUE, RED, YELLOW, NO_COLOR);
        }

        Color(int id, String value) {
            this.id = id;
            this.value = value;
        }
        public static String getColor(int id) {
            return colors.stream().filter(color -> color.getId() == id).findAny().orElse(NO_COLOR).getValue();
        }
        public int getId() {
            return id;
        }

        public String getValue() {
            return value;
        }
    }
}
