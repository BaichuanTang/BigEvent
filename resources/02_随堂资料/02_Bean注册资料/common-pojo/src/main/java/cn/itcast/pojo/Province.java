package cn.itcast.pojo;

public class Province {
    //省份名称
    private String name;
    //省份方位
    private String direction;
    public Province() {
    }

    public Province(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
