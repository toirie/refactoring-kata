package com.odde;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private List<Order> orders = new ArrayList<Order>();

    public void AddOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");
        sb.append(orders.stream().map(order -> order.toString()).collect(Collectors.joining()));
        if (orders.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append("]}").toString();
    }
}
