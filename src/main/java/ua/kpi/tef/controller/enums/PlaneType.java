package ua.kpi.tef.controller.enums;

public enum PlaneType {
    PASSENGER("passenger"),
    CARGO("cargo"),
    BUSINESS("business");

    private String type;

    PlaneType(String type){
        this.type = type;
    }

    static public PlaneType getType(String type) throws Exception{
        switch(type){
            case "passenger": return PASSENGER;
            case "cargo": return CARGO;
            case "business": return BUSINESS;
            default: throw new Exception();
        }
    }
}
