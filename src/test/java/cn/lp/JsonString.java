package cn.lp;

import cn.lp.dto.ThreeElements;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonString {
    public static void main(String[] args) {
        String s = "{\n" +
                "  \"result\": {\n" +
                "    \"historyNames\": \"贵州力源液压股份有限公司;\",\n" +
                "    \"cancelDate\": null,\n" +
                "    \"regStatus\": \"存续\",\n" +
                "    \"regCapital\": \"77800.32万人民币\",\n" +
                "    \"city\": \"毕节市\",\n" +
                "    \"staffNumRange\": \"5000-9999人\",\n" +
                "    \"bondNum\": \"600765\",\n" +
                "    \"historyNameList\": [\n" +
                "      \"贵州力源液压股份有限公司\"\n" +
                "    ],\n" +
                "    \"industry\": \"汽车制造业\",\n" +
                "    \"bondName\": \"中航重机\",\n" +
                "    \"revokeDate\": null,\n" +
                "    \"type\": 1,\n" +
                "    \"updateTimes\": 1620622963000,\n" +
                "    \"legalPersonName\": \"姬苏春\",\n" +
                "    \"revokeReason\": \"\",\n" +
                "    \"compForm\": null,\n" +
                "    \"regNumber\": \"520000000005018\",\n" +
                "    \"creditCode\": \"91520000214434146R\",\n" +
                "    \"property3\": \"AVIC Heavy Machinery Co.,Ltd.\",\n" +
                "    \"usedBondName\": \"力源液压->G力源->力源液压\",\n" +
                "    \"approvedTime\": 1582646400000,\n" +
                "    \"fromTime\": 847900800000,\n" +
                "    \"socialStaffNum\": 9023,\n" +
                "    \"actualCapitalCurrency\": \"人民币\",\n" +
                "    \"alias\": \"中航重机\",\n" +
                "    \"companyOrgType\": \"其他股份有限公司(上市)\",\n" +
                "    \"id\": 11684584,\n" +
                "    \"cancelReason\": \"\",\n" +
                "    \"orgNumber\": \"214434146\",\n" +
                "    \"toTime\": null,\n" +
                "    \"actualCapital\": \"77800.32万人民币\",\n" +
                "    \"estiblishTime\": 847900800000,\n" +
                "    \"regInstitute\": \"贵阳市市场监督管理局贵州双龙航空港经济区分局\",\n" +
                "    \"businessScope\": \"法律、法规、国务院决定规定禁止的不得经营；法律、法规、国务院决定规定应当许可（审批）的，经审批机关批准后凭许可（审批）文件经营;法律、法规、国务院决定规定无需许可（审批）的，市场主体自主选择经营。（股权投资及经营管理；军民共用液压件、液压系统、锻件、铸件、换热器、飞机及航空发动机附件，汽车零备件的研制、开发、制造、修理及销售；经营本企业自产机电产品、成套设备及相关技术的出口业务；经营本企业生产、科研所需的原辅材料、机械设备、仪器仪表、备品备件、零配件及技术的进口业务；开展本企业进料加工和“三来一补”业务。液压、锻件、铸件、换热器技术开发、转让和咨询服务；物流；机械冷热加工、修理修配服务。）\",\n" +
                "    \"taxNumber\": \"91520000214434146R\",\n" +
                "    \"regLocation\": \"贵州双龙航空港经济区机场路9号太升国际A栋3单元5层\",\n" +
                "    \"regCapitalCurrency\": \"人民币\",\n" +
                "    \"tags\": \"企业集团;存续;融资轮次;上市信息;项目品牌;投资机构;曾用名\",\n" +
                "    \"district\": \"威宁彝族回族苗族自治县\",\n" +
                "    \"bondType\": \"A股\",\n" +
                "    \"name\": \"中航重机股份有限公司\",\n" +
                "    \"percentileScore\": 9696,\n" +
                "    \"industryAll\": {\n" +
                "      \"categoryMiddle\": \"改装汽车制造\",\n" +
                "      \"categoryBig\": \"汽车制造业\",\n" +
                "      \"category\": \"制造业\",\n" +
                "      \"categorySmall\": \"\"\n" +
                "    },\n" +
                "    \"isMicroEnt\": 0,\n" +
                "    \"base\": \"gz\"\n" +
                "  },\n" +
                "  \"reason\": \"ok\",\n" +
                "  \"error_code\": 0\n" +
                "}";

        ThreeElements threeElements = JSON.parseObject(s, new TypeReference<ThreeElements>() {});
        System.out.println(threeElements.getResult().get("regInstitute"));
    }
}
