package fr.ghostwan.waoremote;

/**
 * Created by epinault on 29/04/14.
 */
public class QiAddress {

    private String name;
    private String ip;

    public QiAddress(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QiAddress qiAddress = (QiAddress) o;

        if (ip != null ? !ip.equals(qiAddress.ip) : qiAddress.ip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ip != null ? ip.hashCode() : 0;
    }
}
