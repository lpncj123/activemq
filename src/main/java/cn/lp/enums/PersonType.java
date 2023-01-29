package cn.lp.enums;

public enum PersonType {
    ACCOUNT("account","账户"),
    CARDNUM("cardNo","卡号");
    private final String code;
    private final String name;

    PersonType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PersonType getByCode(String code){
        for (PersonType personType : PersonType.values()) {
            if(personType.getCode().equals(code)){
                return personType;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        PersonType.getByCode("account");
    }
}
