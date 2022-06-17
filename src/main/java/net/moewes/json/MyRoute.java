package net.moewes.json;

import lombok.Data;

@Data
public class MyRoute {

    private String name;
    private String pattern;
    private String target;
}
