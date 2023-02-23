package cn.lp.enums;

import cn.lp.utils.MessageUtils;
import com.alibaba.cola.domain.ApplicationContextHelper;

public enum BaseRespStatusEnum {
    SUCCESS("1", "base.status.success"),
    FAIL("2", "base.status.fail"),
    IN_PROCESS("3", "base.status.handing");

    private String code;
    private String desc;

    public static String getDescByCode(String code) {
        BaseRespStatusEnum tmp = getByCode(code);
        return tmp == null ? "" : tmp.getDesc();
    }

    public static BaseRespStatusEnum getByCode(String code) {
        if (code != null && !"".equals(code)) {
            BaseRespStatusEnum[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                BaseRespStatusEnum tmp = var1[var3];
                if (tmp.getCode().equals(code)) {
                    return tmp;
                }
            }

            return null;
        } else {
            return null;
        }
    }

    private BaseRespStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        MessageUtils messageUtils = (MessageUtils) ApplicationContextHelper.getBean(MessageUtils.class);
        String i18n = messageUtils.get(this.desc);
        return i18n;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
