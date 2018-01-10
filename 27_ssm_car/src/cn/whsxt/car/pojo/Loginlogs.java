package cn.whsxt.car.pojo;

public class Loginlogs {
    private Integer loginlogid;

    private String loginname;

    private String loginip;

    private String logintime;

    public Integer getLoginlogid() {
        return loginlogid;
    }

    public void setLoginlogid(Integer loginlogid) {
        this.loginlogid = loginlogid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime == null ? null : logintime.trim();
    }
}