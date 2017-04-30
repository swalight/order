package cn.che001.order.Dto;

import cn.che001.order.Base.PageEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Created by 170246 on 2017/4/17.
 */
public class OrderInfoDto extends PageEntity{

    private String personId;
    private String personName;
    private String orgId;
    private String orgName;
    private String menu1;
    private String menu2;
    private String menu3;
    private String menu4;
    private String menu5;
    private String menu6;
    private String menu7;

    private String drink1;

    private String drink2;

    private String drink3;

    private String drink4;

    private String drink5;

    private String drink6;

    private String drink7;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getMenu1() {
        return menu1;
    }

    public void setMenu1(String menu1) {
        this.menu1 = menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public void setMenu2(String menu2) {
        this.menu2 = menu2;
    }

    public String getMenu3() {
        return menu3;
    }

    public void setMenu3(String menu3) {
        this.menu3 = menu3;
    }

    public String getMenu4() {
        return menu4;
    }

    public void setMenu4(String menu4) {
        this.menu4 = menu4;
    }

    public String getMenu5() {
        return menu5;
    }

    public void setMenu5(String menu5) {
        this.menu5 = menu5;
    }

    public String getMenu6() {
        return menu6;
    }

    public void setMenu6(String menu6) {
        this.menu6 = menu6;
    }

    public String getMenu7() {
        return menu7;
    }

    public void setMenu7(String menu7) {
        this.menu7 = menu7;
    }

    public String getDrink1() {
        return drink1;
    }

    public void setDrink1(String drink1) {
        this.drink1 = drink1;
    }

    public String getDrink2() {
        return drink2;
    }

    public void setDrink2(String drink2) {
        this.drink2 = drink2;
    }

    public String getDrink3() {
        return drink3;
    }

    public void setDrink3(String drink3) {
        this.drink3 = drink3;
    }

    public String getDrink4() {
        return drink4;
    }

    public void setDrink4(String drink4) {
        this.drink4 = drink4;
    }

    public String getDrink5() {
        return drink5;
    }

    public void setDrink5(String drink5) {
        this.drink5 = drink5;
    }

    public String getDrink6() {
        return drink6;
    }

    public void setDrink6(String drink6) {
        this.drink6 = drink6;
    }

    public String getDrink7() {
        return drink7;
    }

    public void setDrink7(String drink7) {
        this.drink7 = drink7;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
